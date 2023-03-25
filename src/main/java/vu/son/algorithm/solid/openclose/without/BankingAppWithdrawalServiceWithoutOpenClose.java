package vu.son.algorithm.solid.openclose.without;

import java.util.ArrayList;

public class BankingAppWithdrawalServiceWithoutOpenClose {

    ArrayList listAccount = new ArrayList();

    public BankingAppWithdrawalServiceWithoutOpenClose() {
        CurrentAccountWithoutOpenClose current = new CurrentAccountWithoutOpenClose() ;
        listAccount.add(current);

        SavingAccountWithoutOpenClose saving = new SavingAccountWithoutOpenClose();
        listAccount.add(saving);
    }

    public void proceed() {
        for(int i=0;i<listAccount.size();i++) {
            if(listAccount.get(i) instanceof CurrentAccountWithoutOpenClose) {
                CurrentAccountWithoutOpenClose currentAccountWithoutOpenClose = (CurrentAccountWithoutOpenClose)listAccount.get(i);
                currentAccountWithoutOpenClose.deposit(500);
                currentAccountWithoutOpenClose.withdraw(100);
            } else if (listAccount.get(i) instanceof SavingAccountWithoutOpenClose) {
                SavingAccountWithoutOpenClose savingAccountWithoutOpenClose = (SavingAccountWithoutOpenClose)listAccount.get(i);
                savingAccountWithoutOpenClose.deposit(800);
                savingAccountWithoutOpenClose.withdraw(1600);
            }
        }
    }

    public static void main(String[] args) {
        BankingAppWithdrawalServiceWithoutOpenClose bankingAppWithdrawalServiceWithoutOpenClose = new BankingAppWithdrawalServiceWithoutOpenClose();
        bankingAppWithdrawalServiceWithoutOpenClose.proceed();
    }

}
