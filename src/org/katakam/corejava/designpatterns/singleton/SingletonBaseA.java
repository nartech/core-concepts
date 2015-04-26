package org.katakam.corejava.designpatterns.singleton;



public class SingletonBaseA {

	private static SingletonBaseA  aSingletonBaseA = new SingletonBaseA();
	protected SingletonBaseA(){
	   
    }
	public static SingletonBaseA getInstance(){
		return aSingletonBaseA;
	}

}
