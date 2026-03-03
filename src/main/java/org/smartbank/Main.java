package org.smartbank;

import org.smartbank.model.Account;

public class Main {
    public static void main(String[] args) {
//        Account account = new Account("A101", "Bipin", 100000);

        try {
//            account.deposit(-5000);
//            account.withdraw(4000);
//
//            System.out.println("Account Holder: "+ account.getAccountHolderName());
//            System.out.println("Balance: "+account.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " +e.getMessage());
        }
    }
}