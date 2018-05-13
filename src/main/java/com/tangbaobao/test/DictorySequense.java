package com.tangbaobao.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 字典序排序
 *
 * @author 唐学俊
 * @create 2018/04/10
 * <p>
 * 12345
 * 12354
 * <p>
 * 12354
 * 12435
 * <p>
 * 13254
 * 13425
 * <p>
 * 21435
 * 23145
 * <p>
 * 1.找到逆序区域
 * 2.选出逆序区域中比非逆序区中小的一个,交换位置
 * 3.对逆序区域顺序排序
 **/

public class DictorySequense {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要转换的序列:");
        String str = scanner.next();
        String sequense = getSequense(str);
        System.out.println(sequense);
    }

    /**
     * 返回字典序列
     *
     * @param str
     * @return
     */
    public static String getSequense(String str) {
        char[] chars = str.toCharArray();
        int point = 0;
        char temp = chars[0];
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i + 1] < chars[i]) {
                point = i + 1;
                temp = chars[i];
                break;
            }
        }
        //从逆序区域中找出仅次于temp的数
        //13254
        char min = temp;
        int max = 0;
        int point2 = 0;
        for (int i = point; i < chars.length - 1; i++) {
            if (chars[i] > temp) {
                max = chars[i];
            }
            if (chars[i + 1] > temp && chars[i + 1] < max) {
                min = chars[i + 1];
                point2 = i + 1;
            }
        }
        //交换位置
        chars[point2] = chars[point];
        chars[point] = min;

        //3.将逆序排序

        return String.valueOf(chars);
    }
}
