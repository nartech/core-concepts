package org.katakam.corejava.autoboxing;

/**
 * Autoboxing : Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes.
 * For example, converting an int to an Integer, a double to a Double, and so on. If the conversion goes the other way, this is called unboxing.
 *
 * @autor Narasimha
 * @since 20-Jan-17
 */
public class TestAutoboxingConversion {

	private static int foo1;
	private static Integer box1;

	public static void acceptObjectVersion(Integer intValue){
		System.out.println("acceptObjectVersion: Integer value: " + intValue);
	}

	public static void acceptPrimitiveVersion(int intValue){
		System.out.println("acceptPrimitiveVersion: Integer value: " + intValue);
	}

	public static void main(String[] args) {
		System.out.println("Testing Autoboxing");
		acceptObjectVersion(foo1);
		acceptObjectVersion(box1);

		System.out.println("Testing Unboxing");
		acceptPrimitiveVersion(foo1);
		Integer box2 = 12;
		acceptPrimitiveVersion(box2);
		acceptPrimitiveVersion(box1);
	}
}
