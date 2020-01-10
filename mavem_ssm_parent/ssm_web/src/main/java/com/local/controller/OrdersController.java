package com.local.controller;


import com.github.pagehelper.PageInfo;
import com.local.domain.Orders;
import com.local.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrderService service;

   /* @RequestMapping("/findAll.do")
    public ModelAndView findById() {
        ModelAndView mv = new ModelAndView();
        List<Orders> byId = service.findAll();
        mv.addObject("ordersList", byId);
        mv.setViewName("orders-list");
        return mv;
    }*/

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4")Integer size) {
        ModelAndView mv = new ModelAndView();
        List<Orders> byId = service.findAll(page,size);
        PageInfo<Orders> info = new PageInfo<>(byId);
        mv.addObject("ordersList", info);
        mv.setViewName("orders-list");
        return mv;
    }


    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name  = "id", required = true)String id) {
        ModelAndView mv = new ModelAndView();
        Orders orders = service.findById(id);
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
