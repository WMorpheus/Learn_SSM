package com.wqy.dao;

import com.wqy.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {
    /**
     * 查找所有用户
     * @return
     */
    @Select("select * from user")
    @Results(
            id="userMap",
            value={
                    @Result(id = true,column = "id",property = "userId"),
                    @Result(column = "username",property = "userName"),
                    @Result(column = "sex",property = "userSex"),
                    @Result(column = "birthday",property = "userBirthday"),
                    @Result(column = "address",property = "userAddress")
    }
    )
    List<User> findAll();

    /**
     * 插入用户
     * @param user
     */
    @Insert("insert user(username,sex,birthday,address) values (#{userName},#{userSex},#{userBirthday},#{userAddress})" )
    void insertUser(User user);

    /**
     * 更新用户
     */
    @Update("update user set username=#{userName}, sex=#{userSex}, address=#{userAddress}, birthday=#{userBirthday} where id=#{userId}")
    void updateUser(User user);

    /**
     * 删除用户
     */
    @Delete("delete from user where id=#{uid}")
    void deleteUser(int id);

    /**
     * 模糊查询
     */
    @Select("select * from user where username like #{name}")
    @ResultMap("userMap")
    List<User> findByName(String name);

    /**
     * 插入用户并获取id
     */
    @Insert("insert user(username,sex,birthday,address) values (#{userName},#{userSex},#{userBirthday},#{userAddress})")
    @SelectKey(keyColumn = "id",keyProperty = "userId",statement = {"select last_insert_id()"},resultType = Integer.class,before=false)
    int insertUserGetId(User user);

    /**
     * 聚合查询
     */
    @Select("select count(*) from user")
    int countUser();
}
