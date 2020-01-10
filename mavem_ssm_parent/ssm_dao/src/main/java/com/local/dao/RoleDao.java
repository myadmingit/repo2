package com.local.dao;

import com.local.domain.Permission;
import com.local.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findRoleByUserId(String userId);

    Role findRole(String roleId);

    List<Permission> findPermission(String roleId);

}
