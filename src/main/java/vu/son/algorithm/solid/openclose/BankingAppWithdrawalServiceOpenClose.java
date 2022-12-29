package vu.son.algorithm.solid.openclose;

import java.util.ArrayList;

/**
 * Consequently, the BankingAppWithdrawalService is open for the extension with new account types,
 * but closed for modification, in that the new types don't require it to change in order to integrate
 *
 * Objects or entities should be open for extension but closed for modification.
 */
public class BankingAppWithdrawalServiceOpenClose {

    ArrayList<AccountOpenClose> listAccountOpenClose;

    BankingAppWithdrawalServiceOpenClose() {
        listAccountOpenClose = new ArrayList<>();

        CurrentAccountOpenClose account = new CurrentAccountOpenClose();
        listAccountOpenClose.add(account);

        SavingAccountOpenClose savingAccount = new SavingAccountOpenClose();
        listAccountOpenClose.add(savingAccount);
    }

    public void proceed() {

        for(AccountOpenClose accountOpenClose : listAccountOpenClose) {
            accountOpenClose.deposit(2000);
            accountOpenClose.withdraw(1000);
        }
    }

    public static void main(String[] args) {
        BankingAppWithdrawalServiceOpenClose bankingAppWithdrawalServiceOpenClose = new BankingAppWithdrawalServiceOpenClose();
        bankingAppWithdrawalServiceOpenClose.proceed();
    }
}
