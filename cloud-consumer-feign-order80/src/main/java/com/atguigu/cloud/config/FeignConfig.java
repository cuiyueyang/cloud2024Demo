package com.atguigu.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Description: </p>
 * <p>Date: 2024/06/04 17:55</p>
 *
 * @author cuiyy
 * @version v1.0.0
 **/
@Configuration
public class FeignConfig {


    /**
     * 调用接口重试配置
     * @return
     */
    @Bean
    public Retryer myRetryer() {

        //Feign默认配置，不走重试策略，直接返回
        return Retryer.NEVER_RETRY;

//        //设置最大请求次数为3(1+2)，初始间隔时间为100ms,重试最大时间间隔为1s
//        return new Retryer.Default(100, 1, 3);

    }


    /**
     * feign日志级别
     * ONE -- 默认的，不显示任何日志,
     * BASIC -- 仅记录请求方法、URL、响应状态码及执行时间,
     * HEADERS -- 除了base 信息外，还有请求和响应的头信息,
     * FULL -- 除了headers中定义的信息之外，还包括请求和响应的正文及元数据;
     * @return
     */
//    @Bean
//    Logger.Level feignLoggerLevel() {
//        return Logger.Level.FULL;
//    }



}










