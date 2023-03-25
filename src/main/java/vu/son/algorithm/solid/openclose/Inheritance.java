package vu.son.algorithm.solid.openclose;

class ObjectA {

    private void test() {

        System.out.println("A.test");

    }

    public void mytest() {

        test();

    }

}

class ObjectB extends ObjectA {

    public void test() {

        System.out.println("B.test");

    }

}

public class Inheritance {

    public static void main(String[] args) {

        ObjectA objectA = new ObjectB();

        objectA.mytest();

    }

}
