package com.wqy.dao.impl;

import com.wqy.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class AccountDaoImpl1 implements IAccountDao{
    public void saveAccount() {
        System.out.println("I have saved account111111111111.");
    }
}
