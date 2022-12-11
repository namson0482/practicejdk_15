package vu.son.algorithm.solid.liskov.without;

import java.util.ArrayList;
import java.util.List;

public class BankingAppWithdrawServiceWithoutLiskov {

    List<AccountWithoutLiskov> listAccounts;
    BankingAppWithdrawServiceWithoutLiskov() {
        listAccounts = new ArrayList<>();

        CurrentAccountWithoutLiskov account = new CurrentAccountWithoutLiskov();
        listAccounts.add(account);

        SavingsAccountWithoutLiskov savingAccount = new SavingsAccountWithoutLiskov();
        listAccounts.add(savingAccount);

        FixedTermDepositAccountWithoutLiskov fixedTermDepositAccountWithoutLiskov = new FixedTermDepositAccountWithoutLiskov();
        listAccounts.add(fixedTermDepositAccountWithoutLiskov);
    }

    public void proceed() {
        for(AccountWithoutLiskov accountOpenClose : listAccounts) {
            accountOpenClose.deposit(2000);
            accountOpenClose.withdraw(1000);
        }
    }

    public static void main(String[] args) {
        BankingAppWithdrawServiceWithoutLiskov banking = new BankingAppWithdrawServiceWithoutLiskov();
        banking.proceed();
    }
}
