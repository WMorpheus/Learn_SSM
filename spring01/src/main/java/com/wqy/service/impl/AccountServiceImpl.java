package com.wqy.service.impl;

import com.wqy.dao.IAccountDao;
import com.wqy.dao.impl.AccountDaoImpl;
import com.wqy.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    IAccountDao account=new AccountDaoImpl();

    public void saveAccount() {
        account.saveAccount();
    }
}
