package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class Main8001 {
    public static void main(String[] args) {
        SpringApplication.run(Main8001.class, args);
    }
}