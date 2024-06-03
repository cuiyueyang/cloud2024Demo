package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * <p>Description: </p>
 * <p>Date: ${YEAR}/${MONTH}/${DAY} ${HOUR}:${MINUTE}</p>
 *
 * @author cuiyy
 * @version v1.0.0
 **/

@SpringBootApplication
//将应用注册到服务注册中心
@EnableDiscoveryClient
//动态刷新
@RefreshScope
public class Main80 {
    public static void main(String[] args) {
        SpringApplication.run(Main80.class, args);
    }
}