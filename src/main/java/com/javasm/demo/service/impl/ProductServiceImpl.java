package com.javasm.demo.service.impl;

import com.javasm.demo.dao.ProductDao;
import com.javasm.demo.dao.impl.ProductDaoImpl;
import com.javasm.demo.entity.Product;
import com.javasm.demo.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getProductList() {
        ProductDao productDao=new ProductDaoImpl();
        List<Product> productList = productDao.getProductList();
        return productList;
    }

    @Override
    public List<Product> getProductsByIds(List<Integer> ids, List<Product> cookieProductData) {
        ProductDao productDao=new ProductDaoImpl();
        //根据cookie中的id查询用户购物车数据
        List<Product> productList = productDao.getProductsByIds(ids);
        for (Product product : productList) {
            for (Product ckData : cookieProductData) {
                if(product.getId().equals(ckData.getId())){
                    product.setNum(ckData.getNum());
                }
            }
        }
        return productList;
    }

}
