package org.smartbank.model;

public abstract class Account {     //Abstract class cannot create object
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Getter Method
    public String getAccountNumber(){
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive!!");
        }
        balance += amount;
    }

    // Withdraw method
    public abstract void withdraw(double amount); // No implementation, each child must define its own rule

//    public void withdraw(double amount) {
//        if (amount <= 0) {
//            throw new IllegalArgumentException("Please enter a positive amount");
//        }
//        if (amount > balance) {
//            throw new IllegalArgumentException("Sorry! Insufficient balance!!");
//        }
//        balance -= amount;
//    }
}
