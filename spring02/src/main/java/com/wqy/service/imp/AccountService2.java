package com.wqy.service.imp;

import com.wqy.service.IAccountService;

import java.util.Date;

public class AccountService2 implements IAccountService{
    private int age;
    private String name;
    private Date birthday;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("I have save account " + age + " " + name + " " + birthday);
    }
}