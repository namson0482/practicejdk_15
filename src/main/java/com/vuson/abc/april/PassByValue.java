package com.vuson.abc.april;

public class PassByValue {

    public int value = 10;

    public PassByValue() {

    }

    static void proceed(PassByValue object) {
        object = new PassByValue();
        object.value = 50;
    }

    public static void main(String[] args) {
        PassByValue object = new PassByValue();
        proceed(object);
        System.out.println(object.value);
    }
}
