package org.katakam.corejava.dynamicproxy;

public class DebugProxyTest {

	public static void main(String[] args) {
		Foo foo = (Foo) DebugProxy.newInstance(new FooImpl());
	    try {
			foo.bar(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
