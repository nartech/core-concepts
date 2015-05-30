/*
 * Here is an example of a utility invocation handler class that provides 
 * default proxy behavior for methods inherited from java.lang.Object and 
 * implements delegation of certain proxy method invocations to distinct objects 
 * depending on the interface of the invoked method:
 * */
package org.katakam.corejava.dynamicproxy;

import java.lang.reflect.*;

public class Delegator implements InvocationHandler {

	// preloaded Method objects for the methods in java.lang.Object
	private static Method hashCodeMethod;
	private static Method equalsMethod;
	private static Method toStringMethod;
	static {
		try {
			hashCodeMethod = Object.class.getMethod("hashCode", null);
			equalsMethod = Object.class.getMethod("equals",
					new Class[] { Object.class });
			toStringMethod = Object.class.getMethod("toString", new Class[]{});
		} catch (NoSuchMethodException e) {
			throw new NoSuchMethodError(e.getMessage());
		}
	}

	private Class[] interfaces;
	private Object[] delegates;

	public Delegator(Class[] interfaces, Object[] delegates) {
		this.interfaces = (Class[]) interfaces.clone();
		this.delegates = (Object[]) delegates.clone();
	}

	public Object invoke(Object proxy, Method m, Object[] args)
			throws Throwable {
		Class declaringClass = m.getDeclaringClass();

		if (declaringClass == Object.class) {
			if (m.equals(hashCodeMethod)) {
				return proxyHashCode(proxy);
			} else if (m.equals(equalsMethod)) {
				return proxyEquals(proxy, args[0]);
			} else if (m.equals(toStringMethod)) {
				return proxyToString(proxy);
			} else {
				throw new InternalError("unexpected Object method dispatched: "
						+ m);
			}
		} else {
			for (int i = 0; i < interfaces.length; i++) {
				if (declaringClass.isAssignableFrom(interfaces[i])) {
					try {
						return m.invoke(delegates[i], args);
					} catch (InvocationTargetException e) {
						throw e.getTargetException();
					}
				}
			}

			return invokeNotDelegated(proxy, m, args);
		}
	}

	protected Object invokeNotDelegated(Object proxy, Method m, Object[] args)
			throws Throwable {
		throw new InternalError("unexpected method dispatched: " + m);
	}

	protected Integer proxyHashCode(Object proxy) {
		return new Integer(System.identityHashCode(proxy));
	}

	protected Boolean proxyEquals(Object proxy, Object other) {
		return (proxy == other ? Boolean.TRUE : Boolean.FALSE);
	}

	protected String proxyToString(Object proxy) {
		return proxy.getClass().getName() + '@'
				+ Integer.toHexString(proxy.hashCode());
	}

	/*
	 * Subclasses of Delegator can override invokeNotDelegated to implement the
	 * behavior of proxy method invocations not to be directly delegated to
	 * other objects, and they can override proxyHashCode, proxyEquals, and
	 * proxyToString to override the default behavior of the methods the proxy
	 * inherits from java.lang.Object.
	 * 
	 * To construct a Delegator for an implementation of the Foo interface:
	 */
	public static void main(String[] args) {

		Class[] proxyInterfaces = new Class[] { Foo.class };
		
		InvocationHandler handler = new Delegator(proxyInterfaces,
				new Object[] { new FooImpl() });
		Foo foo1 = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
				proxyInterfaces, handler);
		
		Foo foo2 = foo1;
		try {
			System.out.println("foo.bar result " + foo1.bar(null));
			System.out.println("Equals method Invocation result "+foo2.equals(foo1));
			System.out.println("toString method Invocation result " + foo2.toString());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}