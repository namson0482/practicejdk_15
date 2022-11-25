package vu.son.grab;<<<<<<<< HEAD:src/main/java/vunam/grab/Consecutive.java
package vunam.grab;
========
package vu.son.grab;
>>>>>>>> revert-7-beta:src/main/java/vu/son/grab/Consecutive.java

public class Consecutive {

	public static boolean checkConsecutive(int[] arrayInput) {

		if (arrayInput == null || arrayInput.length < 2) {
			return false;
		}
		int increment = arrayInput[1] - arrayInput[0];
		if (arrayInput[1] == arrayInput[0]) {
			return false;
		} else {
			increment = arrayInput[1] - arrayInput[0];
		}
		for (int i = 1; i < arrayInput.length - 1; i++) {
			int tempIncrement = arrayInput[i + 1] - arrayInput[i];
			if (increment != tempIncrement) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		int arrayInput[] = { 1, 2, 3, 4, 5 };
		System.out.println(checkConsecutive(arrayInput));
	}
}
