package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Description: </p>
 * <p>Date: ${YEAR}/${MONTH}/${DAY} ${HOUR}:${MINUTE}</p>
 *
 * @author cuiyy
 * @version v1.0.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class Main9001 {
    public static void main(String[] args) {
        SpringApplication.run(Main9001.class,args);
    }
}