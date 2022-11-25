<<<<<<<< HEAD:src/main/java/vunam/java8/DefaultInterface.java
package vunam.java8;
========
package vu.son.java8;
>>>>>>>> revert-7-beta:src/main/java/vu/son/java8/DefaultInterface.java

interface TestInterFace {

	default String getName() {
		return "default function";
	}

	static String getNameStatic() {
		return "Static function";
	}

	static String getNameStatic_2() {
		return "Static function 2";
	}
}

class TestClass implements TestInterFace {

	public TestClass() {
	}
}

public class DefaultInterface {

	public static void main(String[] args) {

		TestClass testClass = new TestClass();
		System.out.println(testClass.getName());
		System.out.println(TestInterFace.getNameStatic());
		System.out.println(TestInterFace.getNameStatic_2());
	}
}
