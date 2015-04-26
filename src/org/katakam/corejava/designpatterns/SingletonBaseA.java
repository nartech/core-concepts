package org.katakam.corejava.designpatterns;



public class SingletonBaseA {

	private static SingletonBaseA  aSingletonBaseA = new SingletonBaseA();
	protected SingletonBaseA(){
	   
    }
	public static SingletonBaseA getInstance(){
		return aSingletonBaseA;
	}

}
