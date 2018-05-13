package com.tangbaobao.test;

import com.tangbaobao.pojo.Product;
import com.tangbaobao.service.ProductService;
import com.tangbaobao.service.ProductTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/10
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProductTest {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTask productTask;

    @Test
    public void fun1() {
        //执行定时器任务
        List<Product> newProduct = productService.findNewProduct();
        newProduct.forEach(x -> System.out.println(x));
    }

    @Test
    public void execute() {
        productTask.execute();
    }
}
