package com.wqy.dao;

import com.wqy.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查找所有用户
     * @return
     */
    List<User> findAll();
}
