package com.vuson.algorithm.solid.openclose;

public class CurrentAccountOpenClose extends AccountOpenClose {
    @Override
    public void deposit(long value) {
        System.out.println("CurrentAccount deposit");
    }

    @Override
    public void withdraw(long value) {
        System.out.println("CurrentAccount withDraw " + value);
    }
}
