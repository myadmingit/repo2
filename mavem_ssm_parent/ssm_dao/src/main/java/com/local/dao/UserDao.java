package com.local.dao;

import com.local.domain.Permission;
import com.local.domain.Role;
import com.local.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    //
    public UserInfo findByUsername(String username);
//
    List<UserInfo> userInfoAll();
//
    void userSaveDao(UserInfo userInfo);
//
    UserInfo findUserRoleper(String id);
// <!--查询所有的角色-->
    List<Role> findRoleAll();
//<!--保存角色-->
    void saveRole(Role role);

    List<Role> findOtherRole(String id);

    void addRoletoUsers(@Param("userid") String userid, @Param("roleid") String roleid);



    void insertPermission(@Param("roleId") String roleId, @Param("pid") String pid);
}
