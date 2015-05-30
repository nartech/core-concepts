package org.katakam.corejava.exception;

public class ExceptionDemo {

	public ExceptionDemo(){
		
	}
	
	
	
	/**
	 * output if you run this method :
	 * 	Caught ex : class not found exception
		Finally caught ... 
	 */
	public void exceptionTest1(){
		
		try {
			test(1);
			test(2);
			test(3);
		} catch (Exception ex) {
			System.out.println("Caught ex : " + ex.getMessage());
		}
		finally{
			System.out.println("Finally caught ... ");
		}
		
	}
	
	/**
	 * output if you run this method :
	 * Finally caught ... 
	java.lang.NoClassDefFoundError: No class def found error
	at org.katakam.corejava.exception.ExceptionDemo.test(ExceptionDemo.java:56)
	at org.katakam.corejava.exception.ExceptionDemo.exceptionTest2(ExceptionDemo.java:35)
	at org.katakam.corejava.exception.ExceptionDemo.main(ExceptionDemo.java:70)

	 * 
	 */
	public void exceptionTest2(){
		
		try {
			test(2);
			test(3);
		} catch (Exception ex) {
			System.out.println("Caught ex : " + ex.getMessage());
		}
		finally{
			System.out.println("Finally caught ... ");
		}
		
	}
	
	
	/**
	 * Finally caught ... 
	Exception in thread "main" java.lang.OutOfMemoryError: out of memory error
	at org.katakam.corejava.exception.ExceptionDemo.test(ExceptionDemo.java:85)
	at org.katakam.corejava.exception.ExceptionDemo.exceptionTest3(ExceptionDemo.java:67)
	at org.katakam.corejava.exception.ExceptionDemo.main(ExceptionDemo.java:99)
	 */
	public void exceptionTest3(){
		
		try {
			//test(2);
			test(3);
		} catch (Exception ex) {
			System.out.println("Caught ex : " + ex.getMessage());
		}
		finally{
			System.out.println("Finally caught ... ");
		}
		
	}
	
	public void test(int inp) throws Exception{
		
		switch(inp){
		case 1:
			throw new ClassNotFoundException("class not found exception");
		case 2:
			throw new NoClassDefFoundError("No class def found error");
		case 3:
			throw new OutOfMemoryError("out of memory error");
			
		}
		
		
	}
	
	public static void main(String[] args) {
		
		ExceptionDemo demo = new ExceptionDemo();
		demo.exceptionTest1();
		
		demo.exceptionTest2();
		
		//This code will be hit only if previous one is commented
		demo.exceptionTest3();
	}

}
