package com.bins.dao;

import com.bins.bean.Role;
import com.bins.bean.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {

    List<Role> findAllRoles();

    List<Role> findNoRolesByUserId(int id);

    void addRole(UserRole userRole);

    void deleteRole(@Param("userIds")List<Integer> userIds);
}