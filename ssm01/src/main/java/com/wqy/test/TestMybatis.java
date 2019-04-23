package com.wqy.test;

import com.wqy.controller.AcccountController;
import com.wqy.dao.IAccountDao;
import com.wqy.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    InputStream in;
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;
    IAccountDao accountDao;
    @Before
    public void init() throws IOException {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
        session=sqlSessionFactory.openSession();
        accountDao=(IAccountDao)session.getMapper(IAccountDao.class);
    }
    @Test
    public void testFindAll() throws IOException {
        List<Account> ls=accountDao.findAll();
        for(Account account:ls){
            System.out.println(account);
        }
        session.close();
        in.close();
    }

    @Test
    public void testSave() throws IOException{
        Account account=new Account();
        account.setMoney(100.0);
        account.setName("小芳");
        accountDao.saveAccount(account);
        session.commit();
        session.close();
        in.close();
    }
}
