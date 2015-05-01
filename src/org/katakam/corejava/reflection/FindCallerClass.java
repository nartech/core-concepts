package org.katakam.corejava.reflection;
//import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

class CallerClassFinder{
	public void printCallerUsingStackTrace(){
		StackTraceElement []st = new Throwable().getStackTrace();
		System.out.println("Caller name using stack trace:\t\t"+st[1].getClassName());
	}
	
	/*
	 * This approach is not working even after specifying the annotation
	 * Exception in thread "main" java.lang.InternalError: CallerSensitive annotation expected at frame 1
	at sun.reflect.Reflection.getCallerClass(Native Method)
	at org.katakam.corejava.reflection.CallerClassFinder.printCallerUsingReflection(FindCallerClass.java:13)
	at org.katakam.corejava.reflection.FindCallerClass.main(FindCallerClass.java:38)

	 * */
	//@CallerSensitive
	public void printCallerUsingReflection(){
		Class<?> callerClass = Reflection.getCallerClass(1);
//		System.out.println("Caller name using reflection:  "+callerClass);
		System.out.println("Caller name using reflection:\t\t"+callerClass.getName());
	}
	
	public void printCallerUsingSecurityManager() {
		//getClassContext() is a protected api, so this style simulates extending that class
	    new SecurityManager() {
	        {
	            String name = getClassContext()[1].getName();
	            System.out.println("Caller name using SecurityManager:\t" + (name == null ? "null" : name));
	            //System.err.println(name == null ? "null" : name);
	        }
	    };
	}
	
}

public class FindCallerClass {
	public static void main(String[] args){
		CallerClassFinder ccf = new CallerClassFinder();
		ccf.printCallerUsingStackTrace();
		
		ccf.printCallerUsingSecurityManager();
		
		ccf.printCallerUsingReflection();
		

	}

}
