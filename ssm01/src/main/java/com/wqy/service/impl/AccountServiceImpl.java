package com.wqy.service.impl;

import com.wqy.domain.Account;
import com.wqy.service.IAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AccountService")
public class AccountServiceImpl implements IAccountService {
    @Override
    public List<Account> findAll() {
        System.out.println("业务层，查询所有账户");
        return null;
    }

    @Override
    public void saveAccount() {
        System.out.println("业务层，保存账户");
    }
}
