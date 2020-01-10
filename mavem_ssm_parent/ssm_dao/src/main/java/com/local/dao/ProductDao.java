package com.local.dao;

import com.local.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {
    /**
     * 查询所有
     * @return
     */
    /*@Select("select * from product")*/
    List<Product> findAll();
    //保存
    void save(Product product);

    /**
     *
     * @param productId
     * @return
     */
    Product findById(String productId);
}
