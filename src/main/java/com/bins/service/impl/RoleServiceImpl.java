package com.bins.service.impl;

import com.bins.bean.Role;
import com.bins.bean.UserRole;
import com.bins.dao.RoleDao;
import com.bins.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;


    @Override
    public List<Role> findAll() {
        return roleDao.findAllRoles();
    }

    @Override
    public List<Role> findNoRoles(int id) {
        return roleDao.findNoRolesByUserId(id);
    }

    @Override
    public void addRoleToUser(List<Integer> ids, int userId) {
        UserRole userRole = new UserRole();
        for(int tmp:ids){
            userRole.setRoleId(tmp);
            userRole.setUserId(userId);
            roleDao.addRole(userRole);
        }
    }
}