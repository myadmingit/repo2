package com.local.dao;

import com.local.domain.Orders;

import java.util.List;

public interface OrderDao {
    List<Orders> findAll();

    Orders orderFindById(String id);

}
