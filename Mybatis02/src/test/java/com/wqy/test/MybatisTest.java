package com.wqy.test;

import com.wqy.dao.IUserDao;
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

    //测试查询所有
    @Test
    public void selectTest() throws IOException {

        List<User> users=userDao.findAll();
//        List<User> users=session.selectList("findAll");
        for(User user:users){
            System.out.println(user);
        }
        session.close();
        in.close();
    }

    //测试插入
    @Test
    public void insertTest() throws IOException {
        User user=new User();
        user.setUserAddress("zjdx");
        user.setUserBirthday(new Date(1994,10,11));
        user.setUserSex("男");
        user.setUserName("帅比宇5");
//        session.insert("insertUser",user);
        userDao.insertUser(user);
        session.commit();
        System.out.println(user);
    }

    //测试更新用户
    @Test
    public void updateTest() throws IOException {
        User user=new User();
        user.setUserAddress("zjdx");
        user.setUserId(50);
        user.setUserBirthday(new Date(1994,10,11));
        user.setUserSex("女");
        user.setUserName("韩达至");
        userDao.updateUser(user);
        session.commit();
    }

    //测试删除用户
    @Test
    public void deleteTest() throws IOException {
        int id=58;
        userDao.deleteUser(id);
        session.commit();
    }

    //测试根据名字模糊查询
    @Test
    public void findTest() throws IOException {
        List<User> users=userDao.findByName("%王%");
        for(User user:users){
            System.out.println(user);
        }
    }

    //测试插入用户并获取id
    @Test
    public void insertUserGetId() throws IOException{
        User user=new User();
        user.setUserAddress("zjdx");
        user.setUserBirthday(new Date(1994,10,11));
        user.setUserSex("男");
        user.setUserName("帅比宇6");
//        session.insert("insertUser",user);
        int a=userDao.insertUserGetId(user);
        session.commit();
        System.out.println(user);
    }

    //测试统计用户总数
    @Test
    public void countUser() throws IOException{
        int num=userDao.countUser();
        System.out.println(num);
    }
}
