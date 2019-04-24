package com.wqy.service;

import com.wqy.domain.Account;

import java.util.List;

public interface IAccountService {
    public List<Account> findAll();

    public void saveAccount(Account account);
}
