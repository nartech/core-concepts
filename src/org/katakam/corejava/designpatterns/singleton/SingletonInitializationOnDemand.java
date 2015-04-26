package org.katakam.corejava.designpatterns.singleton;

/*
 * Singleton without using synchronized or volatile and using lazy initialization
 * http://en.wikipedia.org/wiki/Singleton_pattern#Lazy_initialization
 * Initialization-on-demand holder idiom

 University of Maryland Computer Science researcher Bill Pugh has written about the code 
 issues underlying the Singleton pattern when implemented in Java.[7] 
 Pugh's efforts on the "Double-checked locking" idiom led to changes in the Java memory model
 in Java 5 and to what is generally regarded as the standard method to implement Singletons
 in Java. The technique known as the initialization-on-demand holder idiom is as lazy as
 possible, and works in all known versions of Java. It takes advantage of language guarantees
 about class initialization, and will therefore work correctly in all Java-compliant compilers
 and virtual machines.

 The nested class is referenced no earlier (and therefore loaded no earlier by the class loader)
 than the moment that getInstance() is called. Thus, this solution is thread-safe without 
 requiring special language constructs (i.e. volatile or synchronized).
 * 
 * */
public class SingletonInitializationOnDemand {
	// Private constructor. Prevents instantiation from other classes.
	private SingletonInitializationOnDemand() {
	}

	/**
	 * Initializes singleton.
	 *
	 * SingletonHolder is loaded on the first execution of
	 * SingletonInitializationOnDemand.getInstance() or the 
	 * first access to SingletonHolder.INSTANCE, not before.
	 */
	private static class SingletonHolder {
		private static final SingletonInitializationOnDemand INSTANCE = new SingletonInitializationOnDemand();
	}

	public static SingletonInitializationOnDemand getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
