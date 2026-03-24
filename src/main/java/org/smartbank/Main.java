package org.smartbank;

import org.smartbank.service.BankService;
import org.smartbank.service.impl.BankServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            boolean running = true;
            System.out.println("Welcome to Console Bank");
            BankService bankService = new BankServiceImpl();
            while (running) {
                System.out.println("--------------------------");
                System.out.println("""
                        1. Open Account
                        2. Deposit
                        3. Withdraw
                        4. Transfer Money
                        5. Account Statement
                        6. List Accounts
                        7. Search Account by Customer Name
                        0. Exit
                        """);
                System.out.print("Select your option: ");
                String choice = sc.nextLine().trim();
                System.out.println("Choice: " + choice);
                System.out.println("--------------------------");
                switch (choice){
                    case "1" -> openAccount(sc, bankService);
                    case "2" -> deposit(sc);
                    case "3" -> withdraw(sc);
                    case "4" -> transfer(sc);
                    case "5" -> statement(sc);
                    case "6" -> listAccounts(sc, bankService);
                    case "7" -> searchAccounts(sc);
                    case "0" -> running = false;
                    default -> System.out.println("Invalid choice");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.print("Error: " + e.getMessage());
        }
    }

    private static void openAccount(Scanner sc, BankService bankService) {
        System.out.print("Customer Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Customer email: ");
        String email = sc.nextLine().trim();
        System.out.print("Account Type (SAVING/CURRENT): ");
        String type = sc.nextLine().trim();
        System.out.print("Initial deposit (Optional, blank for 0) : ");
        String initialDepositStr = sc.nextLine().trim();
        Double depositAmount = Double.valueOf(initialDepositStr);
        bankService.openAccount(name, email, type);
    }

    private static void deposit(Scanner sc) {
    }

    private static void withdraw(Scanner sc) {
    }

    private static void transfer(Scanner sc) {
    }

    private static void statement(Scanner sc) {
    }

    private static void listAccounts(Scanner sc, BankService bankService) {
        bankService.listAccounts().forEach(account -> {
            System.out.println(account.getAccountNumber() + " | " + account.getAccountType() + " | " + account.getBalance());
        });
    }

    private static void searchAccounts(Scanner sc) {
    }
}