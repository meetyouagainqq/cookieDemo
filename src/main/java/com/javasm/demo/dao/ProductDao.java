package com.javasm.demo.dao;

import com.javasm.demo.entity.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getProductList();
    public List<Product> getProductsByIds(List<Integer> ids);
}
