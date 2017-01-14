/**
 * What is the output of the following?
 * 		Step 1: before = 10 11
 *
 * 		Step 2: after modifyList1 = 10 11
 *
 * 		Since java params are passed by value, a new copy of reference to list input is created
 * 	and sent to the method modifyList1(). Inside the when a new list is crated, the list variable points to new list
 * 	where as original input list is still pointing to original list
 *
 * 		Step 3: after modifyList2 = 10 11 2
 *
 *		In this method, we are working on the list object so any changes to the object will be reflected
 */

package org.katakam.corejava.passbyvalue;

import java.util.ArrayList;
import java.util.List;


public class PassByRefOrValueTest1 {
	public static void modifyList1(List<Integer> list) {
		list = new ArrayList<Integer>();
		list.add(1);
	}

	public static void modifyList2(List<Integer> list) {
		list.add(2);
	}

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<Integer>();
		input.add(10);
		input.add(11);
		System.out.println("Step 1: before = " + input);
		modifyList1(input);
		System.out.println("Step 2: after modifyList1 = " + input);
		modifyList2(input);
		System.out.println("Step 3: after modifyList2 = " + input);

	}
}

