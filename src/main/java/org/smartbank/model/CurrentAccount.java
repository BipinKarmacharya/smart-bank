package org.smartbank.model;

public class CurrentAccount extends Account{

    private double overdraftLimit = 5000;

    public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        if (amount > balance + overdraftLimit) {
            throw new IllegalArgumentException("Overdraft limit exceeded");
        }

        balance -= amount;
    }
}
