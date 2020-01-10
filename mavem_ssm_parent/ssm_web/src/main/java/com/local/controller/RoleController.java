package com.local.controller;

import com.local.domain.Permission;
import com.local.domain.Role;
import com.local.service.RoleService;
import com.local.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private UserService service;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findRoleAll() {
        ModelAndView mv = new ModelAndView();
        List<Role> roles = service.findRoleAll();
        mv.addObject("roleList", roles);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String saveRole(Role role) {
        service.saveRole(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRolePermission.do")
    public ModelAndView saveRolePermission(@RequestParam(name = "id", required = true) String roleid) {
        ModelAndView mv = new ModelAndView();
        //根据roleID查询role
        Role role = roleService.findRole(roleid);
        //根据roleid查询可以添加的权限
        List<Permission> permissions = roleService.findPermission(roleid);
        mv.addObject("role", role);
        mv.addObject("permissionList", permissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/insertPermission.do")
    public String insertPermission(@RequestParam(name="roleId" ,required = true)String roleId,@RequestParam(name="ids",required =true )String[] ids) {
        service.insertPermission(roleId,ids);
        return "redirect:findAll.do";
    }
}
