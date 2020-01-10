package com.local.service;

import com.local.domain.Permission;
import com.local.domain.Role;

import java.util.List;

public interface RoleService {
    Role findRole(String roleid);

    List<Permission> findPermission(String roleid);
}
