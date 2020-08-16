package com.bins.dao;

import com.bins.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User findUserByName(String username);

    List<User> findAllUsers(@Param("searchName")String searchName,@Param("start")int start);

    void deleteUserById(int id);
    void deleteAllUsers(@Param("ids")List<Integer>ids);

    void addUser(User user);

    void updateUser(User user);

    User findUserById(int id);

    int getCount(@Param("searchName")String searchName);
}