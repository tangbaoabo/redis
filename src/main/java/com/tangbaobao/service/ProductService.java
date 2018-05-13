package com.tangbaobao.service;

import com.alibaba.fastjson.JSON;
import com.tangbaobao.dao.ProductDao;
import com.tangbaobao.pojo.Product;
import com.tangbaobao.utils.JedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/10
 **/
@Service
public class ProductService {
    /**
     * redis中商品列表的key
     */
    private final String PRODUCT_LIST = "productList";

    @Autowired
    private ProductDao productDao;
    @Autowired
    private JedisUtils jedisUtils;
    /**
     * 业务逻辑值在正常情况下只和redis交互
     * 如果reids出现异常,直接从MySQL数据库中读取数据
     *
     * @return
     */
    public List<Product> findNewProduct() {
        Jedis jedis = jedisUtils.getJedis();

        String productList = jedis.get(PRODUCT_LIST);

        if (productList == null) {
            System.out.println("调用MySQL数据库");
            return productDao.findAllProduct();
        }
        return JSON.parseArray(productList,Product.class);
    }
}
