package org.katakam.corejava.designpatterns.singleton;


//Extending a singleton can defeat the original purpose of singleton by 
//exposing the sub-class constructor as public
public class SingletonChildB extends SingletonBaseA{

	private static SingletonChildB  aSingletonBaseA = new SingletonChildB();
	
	private SingletonChildB(){
	   
    }
	
	public static SingletonChildB getInstance(){
		return aSingletonBaseA;
	}

}
