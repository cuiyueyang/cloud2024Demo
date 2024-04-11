package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Description: </p>
 * <p>Date: 2024/04/11 16:19</p>
 *
 * @author cuiyy
 * @version v1.0.0
 **/
@RestController
@Slf4j
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    public String addPay(@RequestBody Pay pay) {
        log.info("add pay");
        Integer i = payService.add(pay);
        return "添加成功:返回值:" + i;
    }

    @DeleteMapping(value = "/pay/del/{id}")
    public Integer deletePay(@PathVariable("id") Integer id) {
        return payService.delete(id);
    }

    @PutMapping(value = "/pay/update")
    public String updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        Integer i = payService.update(pay);
        return "修改成功：返回值:" + i;
    }

    @GetMapping(value = "/pay/get/{id}")
    public Pay getPay(@PathVariable("id") Integer id) {
        return payService.getById(id);
    }

    @GetMapping(value = "/pay/getAll")
    public String getAllPay() {
        return payService.getAll().toString();
    }



}
