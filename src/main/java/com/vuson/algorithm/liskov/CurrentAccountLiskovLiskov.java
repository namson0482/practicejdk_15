package vu.son.algorithm.solid.liskov;

public class CurrentAccountLiskovLiskov extends WithdrawableAccountLiskov {
    @Override
    public void deposit(long money) {
        System.out.println("CurrentAccountLiskovLiskov deposit " + money);
    }

    @Override
    public void withdraw(long money) {
        System.out.println("CurrentAccountLiskovLiskov withdraw " + money);
    }
}
