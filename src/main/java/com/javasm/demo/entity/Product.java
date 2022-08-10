package com.javasm.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String remark;
    private String img;
    private Integer num;//显示购物车数量的使用

    public Product(Integer id, Integer num) {
        this.id = id;
        this.num = num;
    }
}
