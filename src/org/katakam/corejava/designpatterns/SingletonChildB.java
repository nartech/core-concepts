package org.katakam.corejava.designpatterns;



public class SingletonChildB extends SingletonBaseA{

	private static SingletonChildB  aSingletonBaseA = new SingletonChildB();
	
	private SingletonChildB(){
	   
    }
	
	public static SingletonChildB getInstance(){
		return aSingletonBaseA;
	}

}
