package com.local.service.Impl;

import com.local.dao.RoleDao;
import com.local.domain.Permission;
import com.local.domain.Role;
import com.local.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired RoleDao dao;
    @Override
    public Role findRole(String roleid) {
        return dao.findRole(roleid);
    }

    @Override
    public List<Permission> findPermission(String roleid) {
        return dao.findPermission(roleid);
    }
}
