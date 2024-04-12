package com.atguigu.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Description: </p>
 * <p>Date: 2024/04/12 15:13</p>
 *
 * @author cuiyy
 * @version v1.0.0
 **/
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
