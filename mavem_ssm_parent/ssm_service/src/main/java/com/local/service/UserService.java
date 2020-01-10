package com.local.service;

import com.local.domain.Permission;
import com.local.domain.Role;
import com.local.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> userService();

    void usersaveService(UserInfo userInfo);

    UserInfo findUserRoleper(String userId);

    List<Role> findRoleAll();

    void saveRole(Role role);
/*-----------------------------------------*/

    List<Role> findOtherRole(String id);

    void addRoletoUsers(String userid, String[] roleid);



    void insertPermission(String roleId, String[] ids);
}
