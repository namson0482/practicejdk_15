package vu.son.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class ApplicationManager {

    public  List<String> getOpenApplications(List<String> commands) {

        List<String> result = new ArrayList<>();
        for(int i=0;i<commands.size();i++) {
            String temp = commands.get(i);
            if(temp.indexOf("clear") > -1) {
                result = new ArrayList<>();
            } else if(temp.indexOf("close") > -1) {
                String arr[] = temp.split(" ");
                int k = Integer.parseInt(arr[1]);
                while(k > 0 && result.size() > 0) {
                    result.remove(result.size() - 1);
                    k--;
                }
            } else {
                String arr[] = temp.split(" ");
                result.add(arr[1]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ApplicationManager applicationManager = new ApplicationManager();
        List<String> commands = new ArrayList<>();
        commands.add("open firefox");
        commands.add("open terminal");
        commands.add("open curl");
        commands.add("close 2");
        commands.add("open ps");
        List<String> result = applicationManager.getOpenApplications(commands);
        result.forEach(x -> System.out.println(x + " "));
    }
}
