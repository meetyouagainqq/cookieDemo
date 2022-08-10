package com.javasm.demo.service;

import com.javasm.demo.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProductList();
    public List<Product> getProductsByIds(List<Integer> ids,List<Product> cookieProductData);
}
