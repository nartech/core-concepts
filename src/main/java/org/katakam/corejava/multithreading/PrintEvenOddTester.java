package org.katakam.corejava.multithreading;

//Source: http://stackoverflow.com/questions/16689449/printing-even-and-odd-using-two-threads-in-java

class Printer {

	boolean isOdd = false;

	synchronized void printEven(int number) {

		while (isOdd == false) {
			try {
				// wait() will release the locks, so other thread can proceed
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(number);
		isOdd = false;
		notifyAll();
	}

	synchronized void printOdd(int number) {
		while (isOdd == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(number);
		isOdd = true;
		notifyAll();
	}

}

class TaskEvenOdd implements Runnable {

	private int max;
	private Printer print;
	private boolean isEvenNumber;

	TaskEvenOdd(Printer print, int max, boolean isEvenNumber) {
		this.print = print;
		this.max = max;
		this.isEvenNumber = isEvenNumber;
	}

	@Override
	public void run() {
		// Even thread and odd threads count their own numbers
		int number = isEvenNumber == true ? 2 : 1;
		while (number <= max) {

			if (isEvenNumber) {
				print.printEven(number);
			} else {
				print.printOdd(number);
			}
			number += 2;
		}

	}

}

public class PrintEvenOddTester {

	public static void main(String... args) {
		
		//two new tasks of TaskEvenOdd but single print object
		//strict alternations case of producer - consumer problem
		Printer print = new Printer();
		Thread t1 = new Thread(new TaskEvenOdd(print, 100, false));
		Thread t2 = new Thread(new TaskEvenOdd(print, 100, true));
		t1.start();
		t2.start();
	}

}
