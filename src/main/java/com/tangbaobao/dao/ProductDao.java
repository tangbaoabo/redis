package com.tangbaobao.dao;

import com.tangbaobao.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 查找所有商品
 *
 * @author 唐学俊
 * @create 2018/04/10
 **/
@Component
public interface ProductDao {
    /**
     * 返回所有商品
     *
     * @return
     */
    public List<Product> findAllProduct();
}
