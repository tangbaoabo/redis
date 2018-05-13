package com.tangbaobao.service;

import com.alibaba.fastjson.JSON;
import com.tangbaobao.dao.ProductDao;
import com.tangbaobao.utils.JedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定时器类
 * 执行的任务为:从MySQL中读取数据转成string,并设置失效时间,存在redis中
 */
@Component
public class ProductTask implements Runnable {
    private final String PRODUCT_LIST = "productList";
    @Autowired
    private ProductDao productDao;
    @Autowired
    private JedisUtils jedisUtils;
    @Autowired
    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    @Override
    public void run() {
        Jedis jedis = null;
        try {
            jedis = jedisUtils.getJedis();
            //1.转换成json字符串
            String productList = JSON.toJSONString(productDao.findAllProduct());
            //2.将json放入Redis中
            jedis.set(PRODUCT_LIST, productList);
            //3.为key设置超时时间 10min
            jedis.expire(PRODUCT_LIST, 60 * 10);
        } finally {
            jedis.close();
        }
    }
    /**
     * 任务执行器
     * 每隔一分钟就开始执行一遍任务
     */
    public void execute(){
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(new ProductTask(),0,1,TimeUnit.MINUTES);
    }
}