package vu.son.java8;

public class Java8Main {

    public static void main(String[] args) {
        InterfaceGreeting greeting = new InterfaceGreeting() {
            @Override
            public String getGreeting(String name) {
                return "son";
            }
        };

        InterfaceGreeting testGreeting = (String name) -> {
            return "Hi" + name;
        };

    }
}
