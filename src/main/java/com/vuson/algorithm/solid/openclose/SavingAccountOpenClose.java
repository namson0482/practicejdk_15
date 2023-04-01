package com.vuson.algorithm.solid.openclose;

public class SavingAccountOpenClose extends AccountOpenClose {
    @Override
    public void deposit(long value) {
        System.out.println("SavingAccount deposit");
    }

    @Override
    public void withdraw(long money) {
        System.out.println("SavingAccount withDraw " + money);
    }
}
