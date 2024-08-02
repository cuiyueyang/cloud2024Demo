package com.atguigu.cloud.utils;

import java.time.ZonedDateTime;

/**
 * <p>Description: </p>
 * <p>Date: 2024/07/30 17:03</p>
 *
 * @author cuiyy
 * @version v1.0.0
 **/
public class Time {

    /**
     * 获取安全时间
     * @param args
     */
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }

}
