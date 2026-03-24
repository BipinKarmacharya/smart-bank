package org.smartbank.service;

import org.smartbank.domain.Account;

import java.util.List;

public interface BankService {
    String openAccount(String name, String email, String accountType);
    List <Account> listAccounts();
}
