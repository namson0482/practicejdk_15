package vu.son.algorithm.solid.liskov.without;

public class SavingsAccountWithoutLiskov extends AccountWithoutLiskov{
    @Override
    public void deposit(long money) {
        System.out.println("SavingsAccountWithoutLiskov deposit " + money);
    }

    @Override
    public void withdraw(long money) {
        System.out.println("SavingsAccountWithoutLiskov withdraw " + money);
    }
}
