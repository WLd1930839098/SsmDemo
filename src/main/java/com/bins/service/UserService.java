package com.bins.service;

import com.bins.bean.User;

import java.util.List;

public interface UserService {
    boolean login(String username,String password);

    List<User> findAll(String searchname);

    void deleteById(int id);

    void deleteAll(List<Integer> ids);

    void add(User user);

    void updateById(User user);

    User findById(int id);
}