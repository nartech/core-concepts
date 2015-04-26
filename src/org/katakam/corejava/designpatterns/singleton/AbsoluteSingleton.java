package org.katakam.corejava.designpatterns.singleton;

import java.lang.reflect.*;

/**
 * There can be only one - ie. even if the class is loaded in several different
 * classloaders, there will be only one instance of the object.
 * 
 * Copyright:: http://surguy.net/articles/communication-across-classloaders.xml
 */
public class AbsoluteSingleton implements SingletonInterface {

	/**
	 * This is effectively an instance of this class (although actually it may
	 * be instead a java.lang.reflect.Proxy wrapping an instance from the
	 * original classloader).
	 */
	public static SingletonInterface instance = null;

	/**
	 * Retrieve an instance of AbsoluteSingleton from the original classloader.
	 * This is a true Singleton, in that there will only be one instance of this
	 * object in the virtual machine, even though there may be several copies of
	 * its class file loaded in different classloaders.
	 */
	public synchronized static SingletonInterface getInstance() {
		ClassLoader myClassLoader = AbsoluteSingleton.class.getClassLoader();
		if (instance == null) {
			// The root classloader is sun.misc.Launcher package. If we are not
			// in a sun package,
			// we need to get hold of the instance of ourself from the class in
			// the root classloader.
			if (!myClassLoader.toString().startsWith("sun.")) {
				try {
					// So we find our parent classloader
					ClassLoader parentClassLoader = AbsoluteSingleton.class
							.getClassLoader().getParent();
					// And get the other version of our current class
					Class otherClassInstance = parentClassLoader
							.loadClass(AbsoluteSingleton.class.getName());
					// And call its getInstance method - this gives the correct
					// instance of ourself
					Method getInstanceMethod = otherClassInstance
							.getDeclaredMethod("getInstance", new Class[] {});
					Object otherAbsoluteSingleton = getInstanceMethod.invoke(
							null, new Object[] {});
					// But, we can't cast it to our own interface directly
					// because classes loaded from
					// different classloaders implement different versions of an
					// interface.
					// So instead, we use java.lang.reflect.Proxy to wrap it in
					// an object that *does*
					// support our interface, and the proxy will use reflection
					// to pass through all calls
					// to the object.
					instance = (SingletonInterface) Proxy
							.newProxyInstance(myClassLoader,
									new Class[] { SingletonInterface.class },
									new PassThroughProxyHandler(
											otherAbsoluteSingleton));
					// And catch the usual tedious set of reflection exceptions
					// We're cheating here and just catching everything - don't
					// do this in real code
				} catch (Exception e) {
					e.printStackTrace();
				}
				// We're in the root classloader, so the instance we have here
				// is the correct one
			} else {
				instance = new AbsoluteSingleton();
			}
		}

		return instance;
	}

	private AbsoluteSingleton() {
	}

	private String value = "";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}