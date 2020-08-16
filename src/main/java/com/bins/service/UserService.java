package com.bins.service;

import com.bins.bean.PageInfo;
import com.bins.bean.User;

import java.util.List;

public interface UserService {
    User login(String username,String password);

    PageInfo findAll(String searchname, int currentPage);

    void deleteById(int id);

    void deleteAll(List<Integer> ids);

    void add(User user);

    void updateById(User user);

    User findById(int id);
}