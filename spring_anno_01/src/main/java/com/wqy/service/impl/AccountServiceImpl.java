package com.wqy.service.impl;

import com.wqy.dao.IAccountDao;
import com.wqy.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service
//@Scope("prototype") //Scope指定单例还是多例对象

public class AccountServiceImpl implements IAccountService {


//    @Autowired  //自动依赖注入
//    @Qualifier("accountDao1")  //qualifier指定id

    //指定id的依赖注入
    @Resource(name = "accountDao2")
    private IAccountDao account;

    //对基本类型和string的依赖注入用Value
    @Value("18")
    private int age;


    public void saveAccount() {
        account.saveAccount();
        System.out.println(age);
    }

    @PostConstruct
    public void init(){
        System.out.println("对象创建了");
    }

    @PreDestroy
    public void destory(){
        System.out.println("对象销毁了");
    }

}
