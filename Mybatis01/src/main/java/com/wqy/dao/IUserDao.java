package com.wqy.dao;

import com.wqy.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查找所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 插入用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 更新用户
     */
    void updateUser(User user);

    /**
     * 删除用户
     */
    void deleteUser(int id);

    /**
     * 模糊查询
     */
    List<User> findByName(String name);
}
