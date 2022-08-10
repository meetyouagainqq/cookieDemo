package com.javasm.demo.controller;

import com.google.gson.Gson;
import com.javasm.demo.entity.Product;
import com.javasm.demo.entity.R;
import com.javasm.demo.entity.ResponseEnum;
import com.javasm.demo.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getCartList")
public class CartList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> productIds = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().startsWith("product_")) {
                Integer productId = Integer.parseInt(cookie.getName().split("_")[1]);
                productIds.add(productId);
                Product product = new Product(productId, Integer.parseInt(cookie.getValue()));
                productList.add(product);
            }
        }
        ProductServiceImpl productService = new ProductServiceImpl();
        List<Product> products = productService.getProductsByIds(productIds, productList);
        R r = new R();
        if (productList.size() > 0) {
            r.setCode(ResponseEnum.SUCCESS.getCode());
            r.setMsg(ResponseEnum.SUCCESS.getMsg());
            r.setData(products);
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
