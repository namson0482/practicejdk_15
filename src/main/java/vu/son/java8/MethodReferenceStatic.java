package vu.son.java8;

@FunctionalInterface
interface ExecuteFunction {
    int execute(int a, int b);
}

class MathUtils {
    public static int sum(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }
}

public class MethodReferenceStatic {

    public static void main(String[] args) {
        int a = 7;
        int b = 6;
        int sum = doAction(a, b, MathUtils::sum);
        System.out.println("a + b = " + sum);
        int minus = doAction(a, b, MathUtils::minus);
        System.out.println("a - b = " + minus);
    }

    public static final int doAction(int a, int b, ExecuteFunction func) {
        return func.execute(a, b);
    }
}
