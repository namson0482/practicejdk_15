package vu.son.leetcode.string;

public class CompareString {


    public int compareStringOne(String str1, String str2) {
        int max = Math.max(str1.length(), str2.length());
        int min = Math.min(str1.length(), str2.length());

        String sTempOne = str1.substring(0, min);
        String sTempTwo = str2.substring(0, min);

        if (sTempOne.equals(sTempTwo) && min != max) {
            if (str1.length() < max) {
                return 1;
            } else if (str2.length() < max) {
                return -1;
            }
        }

        return 0;
    }


    public int compareString(String str1, String str2) {

        char[] arrayOne = str1.toCharArray();
        char[] arrayTwo = str2.toCharArray();
        int maxLength = Math.max(arrayOne.length, arrayTwo.length);
        int min = Math.min(arrayOne.length, arrayTwo.length);
        int i = 0;
        int indexOne = 0;
        int indexTwo = 0;

        while (i < maxLength) {
            if (indexOne < arrayOne.length && indexTwo < arrayTwo.length) {
                if (arrayOne[i] > arrayTwo[i]) {
                    return 1;
                } else if (arrayOne[i] > arrayTwo[i]) {
                    return -1;
                }
            }

            if (i >= min) {
                if (indexOne < arrayOne.length && arrayOne[i] != '.' && arrayOne[i] != '0') {
                    return 1;
                } else if (indexTwo < arrayTwo.length && arrayTwo[i] != '.' && arrayTwo[i] != '0') {
                    return -1;
                }
            }

            indexOne++;
            indexTwo++;
            i++;

        }
        return 0;
    }

    public static void main(String[] args) {
        String str1 = "1.3";
        String str2 = "1.2.1";

        CompareString compareString = new CompareString();
        System.out.println(compareString.compareString(str1, str2));

    }

}
