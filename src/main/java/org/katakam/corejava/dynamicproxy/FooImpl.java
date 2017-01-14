package org.katakam.corejava.dynamicproxy;

public class FooImpl implements Foo {

	@Override
	public Object bar(Object obj) throws Exception {
		System.out.println("Invoking FooImpl.bar() method");
		return "From FooImpl Implementation";
	}

}
