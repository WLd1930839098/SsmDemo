package com.bins.service.impl;

import com.bins.bean.User;
import com.bins.dao.RoleDao;
import com.bins.dao.UserDao;
import com.bins.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service            //使Autowired注解能够找到
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;

    @Override
    public boolean login(String username, String password) {
        User user = userDao.findUserByName(username);
        boolean flag = (user!=null&&user.getPassword().equals(password));

        return flag;
    }

    @Override
    public List<User> findAll(String searchName) {
        return userDao.findAllUsers(searchName);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void deleteAll(List<Integer> ids) {
        roleDao.deleteRole(ids);
        userDao.deleteAllUsers(ids);
    }

    @Override
    public void add(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateById(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User findById(int id) {
        return userDao.findUserById(id);
    }

}