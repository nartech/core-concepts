package org.katakam.corejava.designpatterns.singleton;

/*
 * Singleton using Double checking locking with lazy initialization and volatile keyword
 * 
 * */
public class SingletonUsingDoubleCheckingLocking {
	
	/*
	 * https://docs.oracle.com/javase/tutorial/essential/concurrency/atomic.html
	 * Reads and writes are atomic for all variables declared volatile
	 * (including long and double variables).
	 * 
	 * Atomic actions cannot be interleaved, so they can be used without fear of
	 * thread interference. However, this does not eliminate all need to
	 * synchronize atomic actions, because memory consistency errors are still
	 * possible. Using volatile variables reduces the risk of memory consistency
	 * errors, because any write to a volatile variable establishes a
	 * happens-before relationship with subsequent reads of that same variable.
	 * This means that changes to a volatile variable are always visible to
	 * other threads. What's more, it also means that when a thread reads a
	 * volatile variable, it sees not just the latest change to the volatile,
	 * but also the side effects of the code that led up the change.
	 */
	
	
    private static volatile SingletonUsingDoubleCheckingLocking instance;
    private SingletonUsingDoubleCheckingLocking() { }
 
    public static SingletonUsingDoubleCheckingLocking getInstance() {
        if (instance == null ) {
        	//use a class level lock since its static 
            synchronized (SingletonUsingDoubleCheckingLocking.class) {
                if (instance == null) {
                    instance = new SingletonUsingDoubleCheckingLocking();
                }
            }
        }
 
        return instance;
    }
}