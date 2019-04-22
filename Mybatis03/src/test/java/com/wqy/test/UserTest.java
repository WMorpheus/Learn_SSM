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

public class UserTest {
    InputStream in;
    SqlSessionFactoryBuilder builder;
    SqlSessionFactory factory;
    SqlSession session;
    IUserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder=new SqlSessionFactoryBuilder();
        factory=builder.build(in);
        session=factory.openSession();
        userDao=session.getMapper(IUserDao.class);
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

        List<User> users=userDao.findAll();
        for(User user:users){
            System.out.println(user);
            System.out.println(user.getAccountList());
        }
        session.close();
        in.close();
    }
}
