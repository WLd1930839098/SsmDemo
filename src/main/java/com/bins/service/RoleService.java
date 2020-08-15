package com.bins.service;

import com.bins.bean.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    List<Role> findNoRoles(int id);

    void addRoleToUser(List<Integer> ids, int userId);
}