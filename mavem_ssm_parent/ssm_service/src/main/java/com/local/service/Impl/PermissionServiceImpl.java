package com.local.service.Impl;

import com.local.dao.PermissionDao;
import com.local.domain.Permission;
import com.local.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionDao dao;

    @Override
    public List<Permission> findPermission() {
        return dao.findAll();
    }

    @Override
    public void savePermission(Permission permission) {
        dao.savePermission(permission);
    }
}
