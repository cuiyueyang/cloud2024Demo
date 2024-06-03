package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * <p>Description: </p>
 * <p>Date: ${YEAR}/${MONTH}/${DAY} ${HOUR}:${MINUTE}</p>
 *
 * @author cuiyy
 * @version v1.0.0
 **/
@SpringBootApplication
@MapperScan("com.atguigu.cloud.mapper")
//将应用注册到服务注册中心
@EnableDiscoveryClient
//动态刷新
@RefreshScope
public class Main8002 {
    public static void main(String[] args) {
        SpringApplication.run(Main8002.class, args);
    }
}