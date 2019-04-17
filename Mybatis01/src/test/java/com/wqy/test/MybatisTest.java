package com.wqy.test;

import com.wqy.dao.IUserDao;
import com.wqy.domain.User;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
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
        }
        session.close();
        in.close();
    }

    @Test
    public void insertTest() throws IOException {
        User user=new User();
        user.setAddress("zjdx");
        user.setBirthday(new Date(1994,10,11));
        user.setSex("男");
        user.setUsername("帅比宇5");
        userDao.insertUser(user);
        session.commit();
        System.out.println(user);
    }

    @Test
    public void updateTest() throws IOException {
        User user=new User();
        user.setAddress("zjdx");
        user.setId(50);
        user.setBirthday(new Date(1994,10,11));
        user.setSex("女");
        user.setUsername("韩达至");
        userDao.updateUser(user);
        session.commit();
    }

    @Test
    public void deleteTest() throws IOException {
        int id=50;
        userDao.deleteUser(id);
        session.commit();
    }

    @Test
    public void findTest() throws IOException {
        List<User> users=userDao.findByName("%王%");
        for(User user:users){
            System.out.println(user);
        }
    }
}
