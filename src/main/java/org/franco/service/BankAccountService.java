package org.franco.service;

import org.franco.entities.BankAccount;

import java.util.HashMap;
import java.util.Map;

public class BankAccountService {
    private Map<Integer, BankAccount> accounts = new HashMap<>();

    public void addAccount(BankAccount account) {
        accounts.put(account.getId(), account);
    }

    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }
}