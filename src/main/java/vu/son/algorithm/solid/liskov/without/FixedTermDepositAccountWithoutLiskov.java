package vu.son.algorithm.solid.liskov.without;

public class FixedTermDepositAccountWithoutLiskov extends AccountWithoutLiskov {
    @Override
    public void deposit(long money) {
        System.out.println("FixedTermDepositAccountWithoutLiskov deposit " + money);
    }

    @Override
    public void withdraw(long money) {
        throw new RuntimeException("Can't withdraw with Fixed Term Account");

    }
}
