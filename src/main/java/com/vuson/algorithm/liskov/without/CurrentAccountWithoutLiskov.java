package com.vuson.algorithm.liskov.without;

public class CurrentAccountWithoutLiskov extends AccountWithoutLiskov{
    @Override
    public void deposit(long money) {
        System.out.println("CurrentAccountWithoutLiskov deposit " + money);
    }

    @Override
    public void withdraw(long money) {
        System.out.println("CurrentAccountWithoutLiskov withdraw " + money);
    }
}
