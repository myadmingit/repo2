package com.local.service.Impl;

import com.local.dao.ProductDao;
import com.local.domain.Product;
import com.local.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao dao;
    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Product product) {
        dao.save(product);
    }
}
