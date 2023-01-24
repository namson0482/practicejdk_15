package vu.son.algorithm.string;

class MinWindowSubstring {

    static final int no_of_chars = 256;

    static String findSubString(String str, String pat) {
        int len1 = str.length();
        int len2 = pat.length();
        if (len1 < len2) {
            System.out.println("No such window exists");
            return "";
        }

        int hash_pat[] = new int[no_of_chars];
        int hash_str[] = new int[no_of_chars];

        for (int i = 0; i < len2; i++) {
            hash_pat[pat.charAt(i)]++;
        }

        int start = 0, start_index = -1,
                min_len = Integer.MAX_VALUE;


        int count = 0;
        for (int j = 0; j < len1; j++) {


            hash_str[str.charAt(j)]++;

            if (hash_str[str.charAt(j)]
                    <= hash_pat[str.charAt(j)]) {
                count++;
            }
            if (count == len2) {


                while (hash_str[str.charAt(start)]
                        > hash_pat[str.charAt(start)]
                        || hash_pat[str.charAt(start)]
                        == 0) {

                    if (hash_str[str.charAt(start)]
                            > hash_pat[str.charAt(start)]) {
                        hash_str[str.charAt(start)]--;
                    }
                    start++;
                }

                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }


        if (start_index == -1) {
            System.out.println("No such window exists");
            return "";
        }

        return str.substring(start_index,
                start_index + min_len);
    }

    // Function
    static String minimumWindow(char[] s, char[] t) {

        int m[] = new int[256];
        // Answer
        int ans = Integer.MAX_VALUE; // length of ans
        int start = 0; // starting index of ans
        int count = 0;
        // creating map
        for (int i = 0; i < t.length; i++) {
            if (m[t[i]] == 0) {
                count++;
            }
            m[t[i]]++;
        }

        // References of Window
        int i = 0;
        int j = 0;

        // Traversing the window
        while (j < s.length) {

            // Calculations
            m[s[j]]--;
            if (m[s[j]] == 0) {
                count--;
            }

            // Condition matching
            if (count == 0) {
                while (count == 0) {

                    // Sorting ans
                    if (ans > j - i + 1) {
                        ans = Math.min(ans, j - i + 1);
                        start = i;
                    }

                    // Sliding I
                    // Calculation for removing I
                    m[s[i]]++;
                    if (m[s[i]] > 0) {
                        count++;
                    }

                    i++;
                }
            }
            j++;
        }

        if (ans != Integer.MAX_VALUE) {
            return String.valueOf(s).substring(start,
                    ans + start);
        } else {
            return "-1";
        }
    }

    public static String reverseString(String str) {
        String nstr="";
        char ch;
        for (int i=0; i<str.length(); i++)
        {
            ch= str.charAt(i);
            nstr= ch+nstr;
        }
        return nstr;
    }

    public static String stringChallenge(String[] strArr) {
        // code goes here

        String reverseChallenge = reverseString("ugoftsmc9");
        String minimumStr = findSubString(strArr[0], strArr[1]);
        String reverseResult = reverseString(minimumStr);
        return reverseResult + ":" + reverseChallenge;
    }

    public static void main(String[] args) {
       String []value = new String[] {"ahffaksfajeeubsne", "jefaa"};

       System.out.println( stringChallenge(value));
    }
}


