package vu.son.grab;

public class Sum2Arrays {

	public static String sum2Numbers(String inputOne, String inputTwo) {

		if (inputOne == null || inputTwo == null)
			return null;
		inputOne = inputOne.trim();
		inputTwo = inputTwo.trim();
		if (inputOne.length() == 0 || inputTwo.length() == 0)
			return null;

		String[] arrayOne = inputOne.split("");
		String[] arrayTwo = inputTwo.split("");

		int loop = arrayOne.length > arrayTwo.length ? arrayOne.length : arrayTwo.length;
		String[] tempResult = new String[loop];
		int tempLoop = loop;
		int loopOne = arrayOne.length;
		int loopTwo = arrayTwo.length;
		int memory = 0;

		while (tempLoop > 0) {

			String tempOne = "0";
			if (loopOne > 0) {
				tempOne = arrayOne[loopOne - 1];
			}
			String tempTwo = "0";
			if (loopTwo > 0) {
				tempTwo = arrayTwo[loopTwo - 1];
			}
			int intOne = Integer.parseInt(tempOne);
			int intTwo = Integer.parseInt(tempTwo);
			int tempSum = intOne + intTwo + memory;
			String tempStrResult = "";
			if (tempSum > 9) {
				tempStrResult = (tempSum + "").split("")[1];
				memory = Integer.parseInt((tempSum + "").split("")[0]);
			} else {
				tempStrResult = tempSum + "";
				memory = 0;
			}
			tempResult[tempLoop - 1] = tempStrResult;
			loopOne--;
			loopTwo--;
			tempLoop--;
		}

		String[] finalResult;
		finalResult = tempResult;
		if (memory != 0) {
			finalResult = new String[loop + 1];
			finalResult[0] = memory + "";
			for (int i = 0; i < tempResult.length; i++) {
				finalResult[i + 1] = tempResult[i];
			}
		}

		String result = "";
		for (String temp : finalResult) {
			result += temp;
		}
		return result;
	}

	public static void main(String[] args) {

		// Output : 3407733333332222
		System.out.println(sum2Numbers("223399", "87611"));
		// label for outer loop
		outer: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 1) {
					break outer;
				}
				System.out.println(" value of j = " + j);
			}
		}

	}
}
