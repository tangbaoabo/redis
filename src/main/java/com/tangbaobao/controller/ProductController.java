package com.tangbaobao.controller;

import com.tangbaobao.pojo.Product;
import com.tangbaobao.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 显示最新商品
 *
 * @author 唐学俊
 * @create 2018/04/10
 **/
@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    public String findNewProduct(){
        List<Product> productList = productService.findNewProduct();
        return "product";
    }
}
