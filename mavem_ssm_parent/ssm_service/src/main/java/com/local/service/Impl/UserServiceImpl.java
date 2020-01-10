package com.local.service.Impl;

import com.local.dao.UserDao;
import com.local.domain.Permission;
import com.local.domain.Role;
import com.local.domain.UserInfo;
import com.local.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao dao;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          UserInfo userInfo = dao.findByUsername(username);
        //System.out.println(userInfo);
       // User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true,true,true,true,getAuthority(userInfo.getRoles()));
          return user;
    }
   public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
     List<SimpleGrantedAuthority> list = new ArrayList<>();
     for(Role role : roles){

         list.add(new SimpleGrantedAuthority("ROLE_"+(role.getRoleName()).toUpperCase()));
     }
     return list;
   }
/*用户管理*/
    @Override
    public List<UserInfo> userService() {
        return dao.userInfoAll();

    }

    @Override
    public void usersaveService(UserInfo userInfo) {
        //设置用户密码加密
       userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        dao.userSaveDao(userInfo);
    }

    @Override
    public UserInfo findUserRoleper(String id) {
        return dao.findUserRoleper(id);
    }

    @Override
    public List<Role> findRoleAll() {
        return dao.findRoleAll();
    }

    @Override
    public void saveRole(Role role) {
        dao.saveRole(role);
    }

    @Override
    public List<Role> findOtherRole(String id) {
        return dao.findOtherRole(id);
    }

    @Override
    public void addRoletoUsers(String userid, String[] roleids) {
        for(String roleid : roleids){
            dao.addRoletoUsers(userid,roleid);
        }
    }



    @Override
    public void insertPermission(String roleId, String[] ids) {
       for(String pid : ids){
           dao.insertPermission(roleId,pid);
       }
    }


}
