package com.ptc.xworx.pql.repo;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ptc.xworx.pql.PQLProxyFactory;
import com.ptc.xworx.pql.XPersistenceHelper;
import com.ptc.xworx.util.XException;

import wt.fc.Persistable;
import wt.fc.QueryResult;
import wt.method.RemoteAccess;

public class RepositoryInvocation implements InvocationHandler, RemoteAccess {
	protected static final Logger LOGGER = LoggerFactory.getLogger(RepositoryInvocation.class);

	static class CallInvoke {
		String className;
		String methodName;
		Class<?>[] types;
		Object[] values;

		public Object invokeParamHandle(Object object) throws Exception {
			if (object == null || methodName == null || methodName.trim().isEmpty())
				throw new XException("Method name is null.");

			if (object instanceof Class<?>) {
				Class<?> clazz = (Class<?>) object;
				Method method = clazz.getMethod(methodName, types);
				return method.invoke(clazz, values);
			} else {
				Class<?> clazz = object.getClass();
				Method method = clazz.getMethod(methodName, types);
				return method.invoke(object, values);
			}
		}

		public String toString() {
			if (this.className.trim().isEmpty()) {
				return (this.methodName + Arrays.toString(this.types)).replace("[", "(").replace("]", ")");
			} else {
				return (this.className + "." + this.methodName + Arrays.toString(this.values)).replace("[", "(").replace("]", ")");
			}
		}
	}

	public RepositoryInvocation() {
	}

	/**
	 * 动态代理调用的目标方法
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Map<String, Class<?>> types = new HashMap<>();
		Map<String, Object> values = new HashMap<>();
		Map<String, Object> arguments = new HashMap<>();
		Parameter[] parameters = method.getParameters();
		int len = parameters.length;
		for (int i = 0; i < len; i++) {
			Parameter parameter = parameters[i];
			Object argument = args[i];
			Param param = parameter.getAnnotation(Param.class);
			if (param != null) {
				String name = param.value();
				if (isBlank(name)) {
					throw new XException("@Param argument is blank.");
				}
				types.put(name, parameter.getType());
				values.put(name, argument);
				if (argument == null) {
					throw new XException("@Param argument:" + name + " got a null value.");
				}
				arguments.put(name, argument);
			} else {
				throw new XException("Please use @Param to annotaion " + parameter.getName());
			}
		}

		/**
		 * 获取@Call、@Calls定义，其返回值可作为@Query的@Param
		 */
		Calls calls = method.getAnnotation(Calls.class);
		List<Call> callList = new ArrayList<>();
		if (calls != null) {
			for (Call _call : calls.value()) {
				callList.add(_call);
			}
		}
		Call anno = method.getAnnotation(Call.class);
		if (anno != null) {
			callList.add(anno);
		}

		/**
		 * 调用@Call、@Calls定义的方法，将其返回值放入arguments
		 */
		for (Call call : callList) {
			String name = call.name();
			String invoke = call.invoke();
			if (StringUtils.isBlank(invoke)) {
				throw new XException("@Call name:" + name + " got a blank invoke field.");
			}
			CallInvoke callInvoke = this.parseCallHandle(invoke, types, values);
			/**
			 * CallInvoke的className是空，说明Call的Handle指向的是当前的Repository
			 */
			if (callInvoke.className.trim().isEmpty()) {
				Object result = callInvoke.invokeParamHandle(proxy);
				if (result == null) {
					throw new XException("@Call name:" + name + " got a null result.");
				}
				arguments.put(name, result);
			} else {
				Class<?> clazz = Class.forName(callInvoke.className);
				/**
				 * 如果CallInvoke的className是一个接口，说明此接口就是Repository，必须使用Proxy的方式进行调用:
				 * 通过PQLProxyFactory.getRepositoryObject()去获取Repository接口的动态代理类；
				 */
				if (clazz.isInterface()) {
					Object proxyRepos = PQLProxyFactory.getRepositoryObject((Class<?>) clazz);
					Object result = callInvoke.invokeParamHandle(proxyRepos);
					if (result == null) {
						throw new XException("@Call argument:" + name + " got a null value.");
					}
					arguments.put(name, result);
				} else {
					Object result = callInvoke.invokeParamHandle(clazz);
					if (result == null) {
						throw new XException("@Call argument:" + name + " got a null value.");
					}
					arguments.put(name, result);
				}
			}
		}

		Query query = method.getAnnotation(Query.class);
		if (query == null) {
			if (method.isDefault()) {
				/**
				 * 在接口中编写的default方法必需采用特殊的方式进行调用
				 */
				return this.invokeDefaultMethod(proxy, method, args);
			} else {
				throw new XException("Please define @Query annotaion for " + method.getName());
			}
		} else {
			String pql = query.value();
			if (pql == null || pql.trim().isEmpty())
				return null;

			QueryResult qr = new QueryResult();
			if (query.permission()) {
				qr = XPersistenceHelper.manager.find(pql, arguments);
			} else {
				qr = XPersistenceHelper.manager.query(pql, arguments);
			}
			/**
			 * 根据被@Query注解的方法的返回值类型，来决定QuerySpec查询结果的处理方式。
			 * 例如：若方法的返回值类型是Persistable类型，程序自动解开QueryResult，取出第一数据返回
			 */
			Class<?> retClass = method.getReturnType();
			if (Collection.class.isAssignableFrom(retClass)) {
				Constructor<?> constructor = retClass.getConstructor();
				@SuppressWarnings("unchecked")
				Collection<Object[]> result = (Collection<Object[]>) constructor.newInstance();
				if (qr.hasMoreElements()) {
					Object[] array = (Object[]) qr.nextElement();
					result.add(array);
				}
				return result;
			} else if (Persistable.class.isAssignableFrom(retClass)) {
				if (qr.hasMoreElements()) {
					Object[] array = (Object[]) qr.nextElement();
					if (array == null)
						return null;
					return array[0];
				} else {
					return null;
				}
			} else if (boolean.class.equals(retClass)) {
				if (qr.hasMoreElements()) {
					Object[] array = (Object[]) qr.nextElement();
					if (array == null)
						return false;
					return array[0];
				} else {
					return false;
				}
			} else if (Short.class.equals(retClass) || Integer.class.equals(retClass) || Float.class.equals(retClass) || Double.class.equals(retClass) || Boolean.class.equals(retClass)
					|| Long.class.equals(retClass) || String.class.equals(retClass)) {
				if (qr.hasMoreElements()) {
					Object[] array = (Object[]) qr.nextElement();
					if (array == null)
						return null;
					return array[0];
				} else {
					return null;
				}
			} else if (short.class.equals(retClass) || int.class.equals(retClass) || float.class.equals(retClass) || double.class.equals(retClass) || long.class.equals(retClass)) {
				if (qr.hasMoreElements()) {
					Object[] array = (Object[]) qr.nextElement();
					if (array == null)
						return -1;
					return array[0];
				} else {
					return -1;
				}
			} else if (QueryResult.class.equals(retClass)) {
				return qr;
			} else {
				throw new XException("QueryResult cannot convert to " + retClass.getName());
			}
		}
	}

	/**
	 * 解析@Call的invoke字符串成CallInvoke对象
	 * 
	 * @param invoke   方法调用定义：getWTPartMaster(number), 从目标类中获取对应的方法
	 * @param typeMap
	 * @param valueMap
	 * @return
	 */
	private CallInvoke parseCallHandle(String invoke, Map<String, Class<?>> typeMap, Map<String, Object> valueMap) {
		CallInvoke callInvoke = new CallInvoke();
		if (invoke == null || invoke.trim().isEmpty()) {
			return callInvoke;
		}

		String className = "";
		String function = "";
		/**
		 * 若handle的字符串中带有“.”, 说明当前@Call调用的是其他Repository的方法 若handle的字符串中没有“.”,
		 * 说明当前@Call调用的是本Repository的方法
		 */
		if (invoke.indexOf(".") > 0) {
			int index = invoke.lastIndexOf(".");
			className = invoke.substring(0, index);
			function = invoke.substring(index + 1);
		} else {
			function = invoke;
		}

		int a = function.indexOf("(");
		int b = function.indexOf(")");
		if ((a > 0 && b < 0) || (a < 0 && b > 0) || (a > 0 && b > 0 && a > b)) {
			throw new XException("@Param handle value format is incorrect, correct format: getXXX(number, name)");
		}
		/**
		 * 如果a > 0,说明@Call是带参数调用；否则就是不带参数调用
		 */
		if (a > 0) {
			String name = function.substring(0, a);
			String pstr = function.substring(a + 1, b);
			callInvoke.className = className.trim();
			callInvoke.methodName = name.trim();
			/**
			 * 根据传入的typeMap & valueMap去解析@Call中handle指定方法的参数类型 & 传入参数值
			 */
			List<Class<?>> typeList = new ArrayList<>();
			List<Object> valueList = new ArrayList<>();
			for (String param : pstr.split(",")) {
				String p = param.trim();
				if (p.trim().isEmpty())
					continue;

				if (!typeMap.containsKey(p))
					throw new XException("Parameter:" + p + " is not found.");
				typeList.add(typeMap.get(p));
				valueList.add(valueMap.get(p));
			}
			callInvoke.types = typeList.toArray(new Class<?>[0]);
			callInvoke.values = valueList.toArray(new Object[0]);

			return callInvoke;
		} else {
			callInvoke.className = className;
			callInvoke.methodName = function.trim();
			return callInvoke;
		}
	}

	/**
	 * 通过反射执行接口的default方法：从接口获取default方法，然后将method绑定到proxy对象后进行调用
	 * 
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws Throwable
	 */
	private Object invokeDefaultMethod(Object proxy, Method method, Object[] args)
			throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException, Throwable {
		/**
		 * 获取接口default方法的MethodHandle
		 */
		Constructor<Lookup> constructor = Lookup.class.getDeclaredConstructor(Class.class, int.class);
		constructor.setAccessible(true);
		Lookup lookupObject = constructor.newInstance(method.getDeclaringClass(), Lookup.PUBLIC | Lookup.PRIVATE | Lookup.PROTECTED | Lookup.PACKAGE);
		MethodHandle methodHandle = lookupObject.unreflectSpecial(method, method.getDeclaringClass());
		/**
		 * 绑定接口default方法到proxy对象，返回MethodHandle
		 */
		MethodHandle proxyHandle = methodHandle.bindTo(proxy);
		
		return proxyHandle.invokeWithArguments(args);
	}

	private static boolean isBlank(String str) {
		int strLen;
		if (str != null && (strLen = str.length()) != 0) {
			for (int i = 0; i < strLen; ++i) {
				if (!Character.isWhitespace(str.charAt(i))) {
					return false;
				}
			}

			return true;
		} else {
			return true;
		}
	}
}
