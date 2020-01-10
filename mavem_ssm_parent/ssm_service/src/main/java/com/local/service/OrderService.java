package com.local.service;

import com.local.domain.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> findAll(int page , int size);

    Orders findById(String id);
}
