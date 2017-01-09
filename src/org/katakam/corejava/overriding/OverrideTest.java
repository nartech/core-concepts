/**
 *
 * 	OverrideTest.java
 *
 *  What does the below program print?
 *  	Ans) Animal eats Flesh
 * 	Why?
 * 		Because we are not overriding the method but overloading
 * 	How do you print Dog eats Flesh?
 * 		See Hint line 36
 *
 */

package org.katakam.corejava.overriding;

class Food{
	@Override
	public String toString() {
		return "Food";
	}
}
class Flesh extends Food{
	@Override
	public String toString() {
		return "Flesh";
	}
}

class Animal{
	void eat(Food f)
	{
		System.out.println("Animal eats "+f);
	}
}

class Dog extends Animal{

	//Hint: Uncomment this for the answer
/*	void eat(Food f)
	{
		System.out.println("Dog eats food "+f);
	}*/

	void eat(Flesh f)
	{

		System.out.println("Dog eats "+f);
	}
}
public class OverrideTest {

	public static void main(String[] args)
	{
		Food fl = new Flesh();
		Animal a = new Dog();
		a.eat(fl);	//This prints Animal eats Flesh
	}


}