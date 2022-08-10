package com.javasm.demo;

import com.javasm.demo.dao.impl.ProductDaoImpl;
import com.javasm.demo.entity.Product;
import com.javasm.demo.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args)  {
        List<Integer> ids=new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ProductDaoImpl productDao = new ProductDaoImpl();
        List<Product> list = productDao.getProductsByIds(ids);
        list.forEach(System.out::println);
    }
}
