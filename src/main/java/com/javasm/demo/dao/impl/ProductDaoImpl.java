package com.javasm.demo.dao.impl;

import com.javasm.demo.dao.ProductDao;
import com.javasm.demo.entity.Product;
import com.javasm.demo.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public List<Product> getProductList() {
        Connection connection = null;
        try {
            connection = DruidUtils.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql="select * from tb_product";
        List<Product> productList=new ArrayList<>();
        QueryRunner queryRunner = new QueryRunner();
        try {
            productList= queryRunner.query(connection, sql, new BeanListHandler<>(Product.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DruidUtils.close(connection);
        }
        return productList;
    }

    @Override
    public List<Product> getProductsByIds(List<Integer> ids) {
        Connection connection = null;
        try {
            connection = DruidUtils.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Product> productList=new ArrayList<>();
        String sql="select * from tb_product where id in (";
        for (int i = 0; i < ids.size(); i++) {
            if(i==ids.size()-1){
                sql+="?)";
            }else {
                sql+="?,";
            }
        }
        QueryRunner queryRunner = new QueryRunner();
        try {
          productList=  queryRunner.query(connection,sql,new BeanListHandler<>(Product.class),ids.toArray());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DruidUtils.close(connection);
        }
        return productList;
    }
}
