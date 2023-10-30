package com.ptc.xworx.pql;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

import wt.method.RemoteAccess;
import wt.method.RemoteMethodServer;
import wt.services.Manager;
import wt.services.ManagerServiceFactory;
import wt.util.WTException;

public class DynamicInvocation implements InvocationHandler, RemoteAccess, Externalizable {
	private Class<?> interfaceType = null;
	private Object targetObject = null;
	private transient String host = null; // http://software.ptc.com/Windchill/
	
	public DynamicInvocation() {
		
	}

	public DynamicInvocation(Object object) {
		this.targetObject = object;
	}

	public DynamicInvocation(Class<?> interfaceType) {
		this.interfaceType = interfaceType;
	}

	@Override
	public void writeExternal(ObjectOutput objectoutput) throws IOException {
		objectoutput.writeObject(this.interfaceType);
		objectoutput.writeObject(this.targetObject);
	}

	@Override
	public void readExternal(ObjectInput objectinput) throws IOException, ClassNotFoundException {
		this.interfaceType = (Class<?>) objectinput.readObject();
		this.targetObject = objectinput.readObject();
	}

	private Manager getManager() throws WTException {
		Manager manager = ManagerServiceFactory.getDefault().getManager(interfaceType);
		if (manager == null) {
			Object aobj[] = { interfaceType.getName() };
			throw new WTException("wt.fc.fcResource", "40", aobj);
		} else {
			return manager;
		}
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			if (RemoteMethodServer.ServerFlag) {
				return method.invoke(this.getManager(), args);
			} else {
				Class<?>[] argsType = { String.class, Class[].class, Object[].class };
				Object[] argsObj = { method.getName(), method.getParameterTypes(), args };
				RemoteMethodServer rms = null;
				if ((host != null) && (host != "")) {
					URL myHost = new URL(host);
					rms = RemoteMethodServer.getInstance(myHost, "MethodServer");
				} else
					rms = RemoteMethodServer.getDefault();

				return rms.invoke("invoke", null, this, argsType, argsObj);
			}
		} catch (InvocationTargetException e) {
			Throwable x = e.getTargetException();
			if (x == null) {
				throw e;
			} else {
				if (x instanceof ExceptionInInitializerError) {
					Throwable y = ((ExceptionInInitializerError) x).getException();
					if (y != null) {
						throw y;
					}
				} else {
					throw x;
				}
			}
		} catch (ExceptionInInitializerError e) {
			Throwable x = e.getException();
			if (x == null) {
				throw e;
			} else {
				throw x;
			}
		}

		return null;
	}

	public Object invoke(String methodName, Class<?>[] argsType, Object[] args) throws Throwable {
		try {
			if (RemoteMethodServer.ServerFlag) {
				Manager manager = getManager();
				Method method = manager.getClass().getMethod(methodName, argsType);
				return method.invoke(manager, args);
			}
		} catch (InvocationTargetException e) {
			Throwable x = e.getTargetException();
			if (x == null) {
				throw e;
			} else {
				if (x instanceof ExceptionInInitializerError) {
					Throwable y = ((ExceptionInInitializerError) x).getException();
					if (y != null) {
						throw y;
					}
				} else {
					throw x;
				}
			}
		} catch (ExceptionInInitializerError e) {
			Throwable x = e.getException();
			if (x == null) {
				throw e;
			} else {
				throw x;
			}
		}
		return null;
	}

	public Object invoke(String className, String methodName, Class<?>[] cls, Object[] objs) throws Throwable {
		try {
			if (RemoteMethodServer.ServerFlag) {
				if (this.targetObject == null) {
					Class<?> nameClass = Class.forName(className);
					Constructor<?> constructor = nameClass.getConstructor();
					Object obj = constructor.newInstance();
					Method method = nameClass.getMethod(methodName, cls);
					return method.invoke(obj, objs);
				} else {
					Class<?> nameClass = this.targetObject.getClass();
					Object obj = this.targetObject;
					Method method = nameClass.getMethod(methodName, cls);
					return method.invoke(obj, objs);
				}
			} else {
				Class<?>[] argsType = { String.class, String.class, Class[].class, Object[].class };
				Object[] argsObj = { className, methodName, cls, objs };
				RemoteMethodServer rms = null;
				if ((this.host != null) && (this.host != "")) {
					URL myHost = new URL(this.host);
					rms = RemoteMethodServer.getInstance(myHost, "MethodServer");
				} else
					rms = RemoteMethodServer.getDefault();
				return rms.invoke("invoke", null, this, argsType, argsObj);
			}
		} catch (InvocationTargetException e) {
			Throwable x = e.getTargetException();
			if (x == null) {
				throw e;
			} else {
				if (x instanceof ExceptionInInitializerError) {
					Throwable y = ((ExceptionInInitializerError) x).getException();
					if (y != null) {
						throw y;
					}
				} else {
					throw x;
				}
			}
		} catch (ExceptionInInitializerError e) {
			Throwable x = e.getException();
			if (x == null) {
				throw e;
			} else {
				throw x;
			}
		}

		return null;
	}
}
