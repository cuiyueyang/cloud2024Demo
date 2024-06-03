package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Description: </p>
 * <p>Date: 2024/04/12 15:15</p>
 *
 * @author cuiyy
 * @version v1.0.0
 **/
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String PaymentSrv_URL = "http://cloud-payment-service";

    @PostMapping(value = "/consumer/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
         return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/"+id, ResultData.class, id);
    }



}
