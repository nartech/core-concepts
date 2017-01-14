package org.katakam.corejava.designpatterns.singleton;

public class SingletonStaticBlockInit {

	    private static final SingletonStaticBlockInit instance;
	 
	    //static blocks are inherently thread safe
	    static {
	        try {
	            instance = new SingletonStaticBlockInit();
	        } catch (Exception e) {
	            throw new RuntimeException("Darn, an error occurred!", e);
	        }
	    }
	 
	    public static SingletonStaticBlockInit getInstance() {
	        return instance;
	    }
	 
	    private SingletonStaticBlockInit() {
	        // ...
	    }
	}