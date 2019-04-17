package com.wqy.service.com.wqy.ui;

import com.sun.org.apache.bcel.internal.generic.IADD;
import com.wqy.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ViewTest {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("Bean.xml");

        //测试构造函数注入
//        IAccountService service= (IAccountService) ac.getBean("AccountService1");
//        service.saveAccount();

        //测试set方法注入
//        IAccountService service=(IAccountService) ac.getBean("AccountService2");
//        service.saveAccount();

        //测试集合注入
        IAccountService service=(IAccountService) ac.getBean("AccountService3");
        service.saveAccount();
    }
}
