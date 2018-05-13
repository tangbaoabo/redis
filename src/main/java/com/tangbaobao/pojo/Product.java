package com.tangbaobao.pojo;

/**
 * 商品表
 *
 * @author 唐学俊
 * @create 2018/04/10
 **/

/**
 * `pri_id` int(11) NOT NULL AUTO_INCREMENT,
 * `produt_name` varchar(15) COLLATE utf8_bin DEFAULT NULL,
 * `pro_status` int(11) DEFAULT NULL,
 */
public class Product {
    private int pri_id;
    private String product_name;
    private int pro_status;

    public int getPri_id() {
        return pri_id;
    }

    public void setPri_id(int pri_id) {
        this.pri_id = pri_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPro_status() {
        return pro_status;
    }

    public void setPro_status(int pro_status) {
        this.pro_status = pro_status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pri_id=" + pri_id +
                ", product_name='" + product_name + '\'' +
                ", pro_status=" + pro_status +
                '}';
    }
}
