package org.katakam.corejava.reflection;

/**
 * Program to test reflection and access concepts
 * @since 01/10/2017
 * courtesy: hackerrank
 *
 * You are given a class AccessTest and an inner class Inner.Private.
 * The main method of class AccessTest takes an integer as input.
 * The powerof2 in class Inner.Private checks whether a number is a power of .
 * You have to call the method powerof2 of the class Inner.Private from the main method of the class AccessTest.

 Constraints

 Sample Input

 8

 Sample Output

 8 is power of 2
 An instance of class: Solution.Inner.Private has been created

 Write code only between //YOUR CODE STARTS HERE and //YOUR CODE ENDS HERE
 *
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.Permission;


public class AccessTest {

	public static void main(String[] args) throws Exception {
		DoNotTerminate.forbidExit();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine().trim());
			Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private

			//YOUR CODE STARTS HERE
			AccessTest.Inner parent = new AccessTest.Inner();
			Class innerClass = Class.forName("org.katakam.corejava.reflection.AccessTest$Inner$Private");
			Constructor con = innerClass.getDeclaredConstructor(AccessTest.Inner.class);
			//since its private class make constructor accessible
			con.setAccessible(true);
			//preferred way to construct an object is using newInstance on Constructor
			o = con.newInstance(parent);

			//First way: Get all methods and call specific method
			for (Method method : innerClass.getDeclaredMethods()){
				System.out.println("Method details: "+method.toString());
				System.out.println("Method name: "+method.getName());
				for (Class<?> pclass : method.getParameterTypes()){
					System.out.println("Parameter type: "+pclass.getName());
				}
				if (method.getName().equals("powerof2")){
					method.setAccessible(true);
					System.out.println(num + " is " + method.invoke(o,num));
					break;
				}

			}


			//Second way to call the private method
			Method powMethod = innerClass.getDeclaredMethod("powerof2",new Class[]{Integer.TYPE});
			powMethod.setAccessible(true);
			System.out.println(num + " is " + powMethod.invoke(o,num));

			//Third way to call private method by directly specifying type as int.class
			powMethod = innerClass.getDeclaredMethod("powerof2",new Class[]{int.class});
			powMethod.setAccessible(true);
			System.out.println(num + " is " + powMethod.invoke(o,num));

			//YOUR CODE ENDS HERE
			System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");


		}//end of try

		catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}//end of main

	static class Inner {
		private class Private {
			private String powerof2(int num) {
				return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
			}
		}
	}//end of Inner

}//end of Solution

class DoNotTerminate { //This class prevents exit(0)

	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if (permission.getName().contains("exitVM")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}

	public static class ExitTrappedException extends SecurityException {

		private static final long serialVersionUID = 1L;
	}
}

