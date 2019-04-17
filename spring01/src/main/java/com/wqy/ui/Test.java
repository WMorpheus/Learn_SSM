package com.wqy.ui;

import com.wqy.dao.IAccountDao;
import com.wqy.service.IAccountService;
import com.wqy.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("Bean.xml");
        IAccountService as=(IAccountService)ac.getBean("AccountService");
        IAccountDao ad=ac.getBean("AccountDao",IAccountDao.class);
        System.out.println(as);
        System.out.println(ad);

    }
}
