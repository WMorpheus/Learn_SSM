package com.wqy.ui;

import com.wqy.dao.IAccountDao;
import com.wqy.service.IAccountService;
import com.wqy.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("Bean.xml");

//        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("Bean.xml");
        IAccountService as=(IAccountService)ac.getBean("accountServiceImpl");
//        IAccountService as2=(IAccountService)ac.getBean("accountServiceImpl");

        as.saveAccount();

        System.out.println(as);

//        ac.close();
//        System.out.println(as==as2);


    }
}
