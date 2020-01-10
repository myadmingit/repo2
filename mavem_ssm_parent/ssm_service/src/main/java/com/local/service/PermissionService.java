package com.local.service;

import com.local.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findPermission();

    void savePermission(Permission permission);
}
