package com.vuson.algorithm.java8.object;

class ObjectBase {

    private void f() {
        System.out.println("objectBase.f");
    }

    public void test() {
        f();
    }
}

class ObjectTwo extends ObjectBase {

    public void f() {
        System.out.println("ObjectTwo.f");
    }

}



public class ObjectOne {

    public ObjectOne() {

    }

    public static void main(String[] args) {
        ObjectBase base = new ObjectTwo();
        base.test();

        ObjectTwo two = new ObjectTwo();
        two.test();
    }
}


