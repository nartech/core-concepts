package org.katakam.corejava;

public class StackOverflowTest {
	public static int counter = 1;
	public void method1() throws Exception{
		try{
			System.out.println("Inside try Before method call " + counter++);
			method1();
			System.out.println("Inside try After method call " + counter);
		}catch(Throwable th){
			System.out.println("Inside Throwable " + counter);
			System.out.println("Caught Error "+th.getMessage()+th.getStackTrace().length);
		}
		finally{
			System.out.println("Inside finally Before method call " + counter++);
			method1();
			System.out.println("Inside finally After method call  " + counter);
		}
	}

	public static void main(String[] args) throws Exception {

		StackOverflowTest sot = new StackOverflowTest();
		sot.method1();
	}

}
