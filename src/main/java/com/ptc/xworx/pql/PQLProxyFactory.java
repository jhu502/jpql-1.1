package com.ptc.xworx.pql;

import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ptc.xworx.pql.repo.RepositoryInvocation;
import com.ptc.xworx.util.XException;

/**
 * @author hujin
 * @date 2012-11-22
 * @version 1.0
 */
public class PQLProxyFactory {
	private static Map<Class<?>, Object> cachedProxyMap = new ConcurrentHashMap<>();

	public static Object getInterfaceObject(Class<?> interType) {
		return Proxy.newProxyInstance(interType.getClassLoader(), new Class[] { interType }, (new DynamicInvocation(interType)));
	}

	public static Object getInterfaceObject(Class<?> intype, Class<?> outtype) {
		return Proxy.newProxyInstance(outtype.getClassLoader(), new Class[] { outtype }, (new DynamicInvocation(intype)));
	}

	@SuppressWarnings("unchecked")
	public static <T> T getRepositoryObject(Class<T> interType) {
		Object proxyObject = cachedProxyMap.get(interType);
		if (proxyObject == null) {
			proxyObject = Proxy.newProxyInstance(interType.getClassLoader(), new Class[] { interType }, (new RepositoryInvocation()));
			cachedProxyMap.put(interType, proxyObject);
		}
		return (T) proxyObject;
	}

	public static Object invoke(String className, String methodName, Class<?>[] cls, Object[] objs) {
		if (className == null || className.trim().length() == 0 || methodName == null || methodName.trim().length() == 0)
			return null;

		DynamicInvocation helper = new DynamicInvocation();
		try {
			return helper.invoke(className, methodName, cls, objs);
		} catch (Throwable e) {
			XException.throwException(e);
		}
		return null;
	}

	public static Object invoke(Object object, String methodName, Class<?>[] cls, Object[] objs) {
		if (object == null || methodName == null || methodName.trim().length() == 0)
			return null;

		DynamicInvocation helper = new DynamicInvocation(object);
		try {
			return helper.invoke(object.getClass().getName(), methodName, cls, objs);
		} catch (Throwable e) {
			XException.throwException(e);
		}
		return null;
	}
}