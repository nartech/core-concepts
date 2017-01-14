package org.katakam.corejava.threads;

class Common{
	
	public synchronized void synchronizedMethod1(String threadName){
		System.out.println("synchronizedMethod1 Thread " + threadName + "Begin");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("synchronizedMethod1 Thread " + threadName + "End");
	}
	
	public synchronized void synchronizedMethod2(String threadName){
		System.out.println("synchronizedMethod2 Thread " + threadName + "Begin");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("synchronizedMethod2 Thread " + threadName + "End");
	}
}

public class ThreadSleepIntvDemo extends Thread{

	int id;
	Common commonObj;
	public ThreadSleepIntvDemo(String name, int id, Common commonObj) {
		 super(name);
		 this.id = id;
		 this.commonObj = commonObj;
	}
	
	@Override
	public void run() {
		
		if (id == 0){
			commonObj.synchronizedMethod1(getName());
		}else{
			commonObj.synchronizedMethod2(getName());
		}
		
	}

	
	/**
	 * Expected output: one of these outputs since Thread.sleep does not give up locks, execution of 
	 * one synchronized method will complete and then only proceed to next one's 
	 * execution
	 * 
		synchronizedMethod1 Thread MyThread1Begin
		synchronizedMethod1 Thread MyThread1End
		synchronizedMethod2 Thread MyThread2Begin
		synchronizedMethod2 Thread MyThread2End
		
				or
		
		synchronizedMethod2 Thread MyThread2Begin
		synchronizedMethod2 Thread MyThread2End
		synchronizedMethod1 Thread MyThread1Begin
		synchronizedMethod1 Thread MyThread1End

	 * 
	 */
	public static void main(String[] args) {
		
		Common c = new Common();
		ThreadSleepIntvDemo t1 = new ThreadSleepIntvDemo("MyThread1",0,c);
		ThreadSleepIntvDemo t2 = new ThreadSleepIntvDemo("MyThread2",1,c);
		t1.start();
		t2.start();
		
	}

}
