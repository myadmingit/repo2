package com.local.controller;

import com.local.domain.SysLog;
import com.local.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogContronller {
    @Autowired
    LogService service;
    @RequestMapping("/findAll.do")
    public ModelAndView findAllLog(){
        ModelAndView mv = new ModelAndView();
        List<SysLog> log  = service.findAllLog();
        mv.addObject("sysLogs",log);
        mv.setViewName("syslog-list");
        return mv;
    }
}
