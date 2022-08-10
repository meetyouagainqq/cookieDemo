package com.javasm.demo.controller;

import com.google.gson.Gson;
import com.javasm.demo.entity.Product;
import com.javasm.demo.entity.R;
import com.javasm.demo.entity.ResponseEnum;
import com.javasm.demo.service.ProductService;
import com.javasm.demo.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/getAllProducts")
public class ProductList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        List<Product> productList = productService.getProductList();
        R r = new R();
        if (productList.size() > 0) {
            r.setCode(ResponseEnum.SUCCESS.getCode());
            r.setMsg(ResponseEnum.SUCCESS.getMsg());
            r.setData(productList);
        } else {
            r.setCode(ResponseEnum.ERROR.getCode());
            r.setMsg(ResponseEnum.ERROR.getMsg());
        }
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        Gson gson = new Gson();
        writer.print(gson.toJson(r));
        writer.flush();
        writer.close();
    }
}
