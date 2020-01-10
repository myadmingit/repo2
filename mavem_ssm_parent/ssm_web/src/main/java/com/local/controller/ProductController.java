package com.local.controller;

import com.local.domain.Product;
import com.local.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;


    /**
     * 查询全部信息
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
          ModelAndView mv = new ModelAndView();
          List<Product> all = service.findAll();
          mv.addObject("productList",all);
          mv.setViewName("product-list");
          return mv;
      }

    /**
     * 保存
     * @return
     */
    @RequestMapping("/save.do")
    public String saveid(Product product){
       service.save(product);
       return "redirect:findAll.do";
    }

    /*@RequestMapping("/findById.do")
    public String findById(Product product){

        service.save(product);
        return "redirect:findAll.do";
    }*/



    }


