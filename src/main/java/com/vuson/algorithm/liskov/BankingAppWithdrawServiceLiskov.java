package com.vuson.algorithm.liskov;

import java.util.ArrayList;
import java.util.List;

/**
 * If for each object o1 of type S there is an object o2 of type T
 * such that for all programs P defined in terms of T,
 * the behavior of P is unchanged when o1 is substituted for o2 then S is a subtype of T.
 */
public class BankingAppWithdrawServiceLiskov {
    List<AccountLiskov> listAccounts;

    BankingAppWithdrawServiceLiskov() {
        listAccounts = new ArrayList<>();

        CurrentAccountLiskovLiskov account = new CurrentAccountLiskovLiskov();
        listAccounts.add(account);

        SavingsAccountLiskov savingAccount = new SavingsAccountLiskov();
        listAccounts.add(savingAccount);

        FixedTermDepositAccountLiskov fixedTermAccount = new FixedTermDepositAccountLiskov();
        listAccounts.add(fixedTermAccount);
    }

    public void proceed() {
        for(AccountLiskov account : listAccounts) {
            account.deposit(2000);
            if(account instanceof WithdrawableAccountLiskov) {
                ((WithdrawableAccountLiskov) account).withdraw(3000);
            }
        }
    }

    public static void main(String[] args) {
        BankingAppWithdrawServiceLiskov bankingService = new BankingAppWithdrawServiceLiskov();
        bankingService.proceed();
    }
}
