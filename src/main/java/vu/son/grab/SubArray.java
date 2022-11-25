package vu.son.grab;

<<<<<<<< HEAD:src/main/java/vunam/grab/SubArray.java
package vunam.grab;

import java.util.ArrayList;
import java.util.List;
========
package vu.son.grab;
>>>>>>>> revert-7-beta:src/main/java/vu/son/grab/SubArray.java

public class SubArray {

	public static void printlnAllSubArraya(int[] arrayInput, int length, int n) {

		/*for (int i = 0; i < length - 1; i++) {
           			int loopTemp = 0;
           			List<Integer> listTemp = new ArrayList<Integer>();
           			listTemp.add(arrayInput[i]);
           			loopTemp++;
           			lblPoint_1: for (int j = i + 1; j < length && loopTemp < n; j++) {
           				listTemp.add(arrayInput[j]);
           				loopTemp++;
           				if (loopTemp == n && (i + 1) < length) {
           					listTemp.forEach(x -> System.out.print(x + " "));
           					listTemp.remove(listTemp.size() - 1);
           					loopTemp--;
           					System.out.println("");
           				}
           			}
           			listTemp.forEach(x -> System.out.print(x + " "));
           			System.out.println("");

           		}*/
	}

	// for given array
	static void printSubArrays(int[] arr, int start, int end) {
		// Stop if we have reached the end of the array
		if (end == arr.length)
			return;

		// Increment the end point and start from 0
		else if (start > end)
			printSubArrays(arr, 0, end + 1);

		// Print the subarray and increment the starting point
		else {
			System.out.print("[");
			for (int i = start; i < end; i++) {
				System.out.print(arr[i] + ", ");
			}

			System.out.println(arr[end] + "]");
			printSubArrays(arr, start + 1, end);
		}

		return;
	}

	public static void main(String[] args) {

		int[] arrayInput = { 1, 2, 3 };
//		printlnAllSubArraya(arrayInput, arrayInput.length, 2);
		printSubArrays(arrayInput, 0 , 0);
	}

}
