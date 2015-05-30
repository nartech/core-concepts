/**
 * Source
 * http://docs.oracle.com/javase/1.5.0/docs/guide/reflection/proxy.html#serial
 * How to create a dynamic proxy in java using Reflection proxy class
 * and achieve interceptor mechanism
 * 
 */
package org.katakam.corejava.dynamicproxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author DhaNarsi
 *
 */
public class DebugProxy implements java.lang.reflect.InvocationHandler {

    private Object obj;

    public static Object newInstance(Object obj) {
	return java.lang.reflect.Proxy.newProxyInstance(
	    obj.getClass().getClassLoader(),
	    obj.getClass().getInterfaces(),
	    new DebugProxy(obj));
    }

    private DebugProxy(Object obj) {
	this.obj = obj;
    }

    public Object invoke(Object proxy, Method m, Object[] args)
	throws Throwable
    {
        Object result;
	try {
	    System.out.println("before method " + m.getName());
	    System.out.println("Method executed at time" + new Date());
	    result = m.invoke(obj, args);
        } catch (InvocationTargetException e) {
	    throw e.getTargetException();
        } catch (Exception e) {
	    throw new RuntimeException("unexpected invocation exception: " +
				       e.getMessage());
	} finally {
	    System.out.println("after method " + m.getName());
	}
	return result;
    }
}