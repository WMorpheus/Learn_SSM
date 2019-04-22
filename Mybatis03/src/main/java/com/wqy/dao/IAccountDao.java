package com.wqy.dao;

import com.wqy.domain.Account;

import java.util.List;

public interface IAccountDao {

    public List<Account> findAll();
}
