package vu.son.algorithm.java8;

public class Java8Main {

    public static void main(String[] args) {
        InterfaceGreeting greeting = name -> "son " + name;


        System.out.println(greeting.getGreeting("a"));

        InterfaceGreeting testGreeting = (String name) -> {
            return "Hi" + name;
        };

    }
}
