package org.smartbank.model;

public class SavingAccount extends Account {
    public SavingAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }

        if (amount > getBalance()) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        balance -= amount;
    }
}
