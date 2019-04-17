package com.wqy.dao.impl;

import com.wqy.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {
    public void saveAccount() {
        System.out.println("I have saved account2222222222.");
    }
}
