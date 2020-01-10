package com.local.dao;

import com.local.domain.Permission;

import java.util.List;

public interface PermissionDao {
    public List<Permission> findPermission(String id);

    List<Permission> findAll();

    List<Permission> findPermissionByRoleId(String id);

    void savePermission(Permission permission);
}
