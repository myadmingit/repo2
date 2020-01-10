package com.local.controller;

import com.local.domain.Role;
import com.local.domain.UserInfo;
import com.local.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Repository
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfo = service.userService();
        mv.addObject("userList", userInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String saveUser(UserInfo userInfo) {
        ModelAndView mv = new ModelAndView();
        service.usersaveService(userInfo);
        return "redirect:findAll.do";

    }

    @RequestMapping("/findById.do")
    public ModelAndView findUserRoleper(String id) {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = service.findUserRoleper(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;

    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUsersRoles(@RequestParam(name = "id", required = true) String id) {
        ModelAndView mv = new ModelAndView();
        UserInfo users = service.findUserRoleper(id);
        List<Role> roles = service.findOtherRole(id);
        mv.addObject("user", users);
        mv.addObject("roleList", roles);
        mv.setViewName("user-role-add");
        return mv;
    }

    /*给用户绑定角色*/
    @RequestMapping("/addRoleToUser.do")
    public String saveUsersRole(@RequestParam(name = "userId", required = true) String userid, @RequestParam(name = "ids", required = true) String[] roleid) {
        service.addRoletoUsers(userid, roleid);
        return "redirect:findAll.do";
    }


}
