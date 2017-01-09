/**
 *
 *
 * Taken from https://www.caveofprogramming.com/java/are-you-a-java-expert-test-your-knowledge-with-these-four-tricky-questions.html
 *
 * Whether below code compiles or not?
 * 		No, The problem here is that you can only use static variables in static or top-level classes,
 * 		and we've got a static variable in a class that isn't top-level.
 *
 */
package org.katakam.corejava.compilation;

//Inner classes cannot have static variables
public class UnUsualClassDeclarations {
	public static void main(String[] args) {

		final class Constants {

			public static String name = "PI";
		}

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(Constants.name);
			}

		});

		thread.start();
	}
}
