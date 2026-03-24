package org.smartbank.service.impl;

import org.smartbank.domain.Account;
import org.smartbank.repository.AccountRepository;
import org.smartbank.service.BankService;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankService {

    private final AccountRepository accountRepository = new AccountRepository();
    @Override
    public String openAccount(String name, String email, String accountType) {
        String customerId = UUID.randomUUID().toString();
//        String accountNumber = UUID.randomUUID().toString();   // CHANGE LATER -> AC11
        String accountNumber = getAccountNumber();
        Account account = new Account(accountNumber, accountType, (double) 0, customerId);

        // SAVE
        accountRepository.save(account);
        return ("Your Account Number Is: " + accountNumber);
    }

    @Override
    public List<Account> listAccounts() {
        return accountRepository.findAll().stream()
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());
    }

    private String getAccountNumber() {
        int size = accountRepository.findAll().size() + 1;
        return String.format("AC%06d", size);
    }
}
