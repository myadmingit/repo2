package com.local.service;

import com.local.domain.Product;

import java.util.List;

/**
 * 业务层
 */
public interface ProductService {
    List<Product> findAll();

    void save(Product product);
}
