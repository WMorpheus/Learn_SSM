package com.wqy.service.imp;

import com.wqy.service.IAccountService;

import java.util.Date;

public class AccountService1 implements IAccountService {
    private int age;
    private String name;
    private Date birthday;

    public AccountService1(int age,String name,Date birthday) {
        this.age=age;
        this.name=name;
        this.birthday=birthday;
    }

    public void saveAccount() {
        System.out.println("I have save account "+age+" "+name+" "+birthday);
    }
}
