package org.katakam.corejava.generics;

/**
 * Created by NKATAKAMDURGA on 09-Jan-17.
 *
 * Will this code compile? If so what does it output?
 *
 * 		Yes its perfectly valid since Arrays are covariant i.e Subtypes are perfectly valid as per compiler
 *
 * 	During run-time : java.lang.ArrayStoreException because of type mismatch
 * 		we are inserting double value into integer array
 * 		attempt of heap pollution
 *
 */
public class CovarianceCompilation {


	public static void main(String[] args) {

		Integer[] intArray = {1,2,3,4};
		Number[] numArray = intArray;

		System.out.println(numArray);

		numArray[0] = 10.14;

		System.out.println(numArray);
	}


}
