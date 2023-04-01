package vu.son.leetcode.string;

import java.util.*;

public class StringSplit {

    public static void main(String[] args) {
        String inputString = "sdfgabcwetrrytruyrtuabcpotre!@#abcprtort";
        ArrayList<HashMap<String, String>> resultList = new ArrayList<HashMap<String, String>>();

        resultList.add(processString(inputString,"abc"));
        resultList.add(processString(inputString,"s"));
        resultList.add(processString(inputString,"r"));
        resultList.add(processString(inputString,"zi"));

        printResult(resultList);
    }

    private static HashMap<String, String> processString(String inputStr, String separator) {

        HashMap<String, String> result = new HashMap<String, String>();
        String [] elements =  inputStr.split(separator);
        int count  = elements.length - 1;
        String prefix = elements[0];

        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i= 1; i < elements.length; i++) {
            queue.add(elements[i]);
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            sb.append(queue.poll());
            sb.append(" ");
        }
        String sortedItems = sb.toString().trim();
        StringBuilder sb1 = new StringBuilder();
        for (int j = 0; j < inputStr.length(); j = j+2) {
            sb1.append(inputStr.charAt(j));
        }
        String evenChars = sb1.toString();
        result.put("Count", Integer.toString(count));
        result.put("Prefix", prefix);
        result.put("sortedItems", sortedItems);
        result.put("evenChars", evenChars);

        //Add the implementation here
        return result;
    }

    private static void printResult(ArrayList<HashMap<String, String>> resultList) {
        /*
    		Below is an example output when executed with inputString = "abcdefSEPgabcwetSEPsdsSEPdsfgSEPfro", separator = "SEP"

    		Count: 4
    		Prefix: abcdef
    		sortedItems: dsfg fro gabcwet sds
    		evenChars: aceSPaceSPdSPsgEfo
		*/

        //Add the implementation here

        for(int i=0;i<resultList.size();i++) {
            HashMap<String, String> map =  resultList.get(i);
            String count = "";
            String prefix = "";
            String sortedItems = "";
            String evenChars = "";
            for (String key : map.keySet()) {
                if(key.equals("Count")) {
                    count = key + ":" + map.get(key);
                } else if(key.equals("Prefix")) {
                    prefix = key + ":" + map.get(key);
                } else if(key.equals("evenChars")) {
                    evenChars = key + ":" + map.get(key);
                } else if(key.equals("sortedItems")) {
                    sortedItems = key + ":" + map.get(key);
                }
            }
            System.out.println(count);
            System.out.println(prefix);
            System.out.println(sortedItems);
            System.out.println(evenChars);
        }
    }


}
