/**
 * @author Narasimha
 * @since 01/11/17
 *
 * What is the output of the following?
 * 		Step 1: before change 50
 *
 * 		Step 2: after change 50
 *
 * 		because parameter(data ) to the method change is shadowing the class member data
 * 		so we are actually working on the input parameter not the class member data.
 * 		this is not really a question for call by value or ref
 */
package org.katakam.corejava.passbyvalue;


class Operation {
	int data = 50;

	void change(int data) {
		data = data + 100;
	}
}
public class PassByRefOrValueTest2 {
	public static void main(String[] args) {
		Operation op=new Operation();

		System.out.println("Step 1: before change "+op.data);
		op.change(500);
		System.out.println("Step 2: after change "+op.data);
	}
}
