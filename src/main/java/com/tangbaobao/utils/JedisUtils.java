package com.tangbaobao.utils;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author 唐学俊
 * @create 2018/04/10
 **/
public class JedisUtils {
    /**
     * 注入jedisPool
     */
    @Autowired
    private JedisPool pool;

    public Jedis getJedis() {
        Jedis resource = pool.getResource();
        return resource;
    }
}
