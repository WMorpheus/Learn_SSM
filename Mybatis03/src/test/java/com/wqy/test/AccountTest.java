package com.wqy.test;

import com.wqy.dao.IAccountDao;
import com.wqy.dao.IUserDao;
import com.wqy.domain.Account;
import com.wqy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    InputStream in;
    SqlSessionFactoryBuilder builder;
    SqlSessionFactory factory;
    SqlSession session;
    IAccountDao accountDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder=new SqlSessionFactoryBuilder();
        factory=builder.build(in);
        session=factory.openSession();
        accountDao=session.getMapper(IAccountDao.class);
    }

    @After
    public void close() throws IOException {
//        session.commit();
        if(in!=null){
            in.close();
        }
        if(session!=null){
            session.close();
        }
    }
    @Test
    public void selectTest() throws IOException {

        List<Account> accounts=accountDao.findAll();
//        List<User> users=session.selectList("findAll");
        for(Account account:accounts){
            System.out.println(account);
            System.out.println(account.getUser());
        }
        session.close();
        in.close();
    }
}
