package com.local.controller;

import com.local.domain.Permission;
import com.local.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService service;

    @RequestMapping("/findAll.do")
    public ModelAndView findPermission() {
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionss = service.findPermission();
        mv.addObject("permissionList", permissionss);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String savePermission(Permission permission) {
        service.savePermission(permission);
        return "redirect:findAll.do";
    }
}
