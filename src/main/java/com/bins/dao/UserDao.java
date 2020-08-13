package com.bins.dao;

import com.bins.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User findUserByName(String username);

    List<User> findAllUsers(@Param("searchName")String searchName);

    void deleteUserById(int id);
    void deleteAllUsers();

    void addUser(User user);

    void updateUser(User user);

    User findUserById(int id);
}