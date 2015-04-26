package org.katakam.corejava.designpatterns.singleton;

public class SingletonEagerInit {

	//eager initialization
	//not preferred if it involves cost eg like loading big images
    private static final SingletonEagerInit instance = new SingletonEagerInit();
 
    private SingletonEagerInit() {}
 
    public static SingletonEagerInit getInstance() {
        return instance;
    }
}