package org.katakam.corejava.designpatterns.singleton;

public enum SingletonEnum {
	INSTANCE;
	
	public void execute (String arg) {
        System.out.println("Singleton using Enum");
    }
	
}
