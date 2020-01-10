package com.local.service.Impl;

import com.github.pagehelper.PageHelper;
import com.local.dao.OrderDao;
import com.local.domain.Orders;
import com.local.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao dao;
    @Override
    public List<Orders> findAll(int page , int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public Orders findById(String id) {
        return dao.orderFindById(id);
    }
}
