package com.atguigu.cloud.apis;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>Description: </p>
 * <p>Date: 2024/06/04 10:49</p>
 *
 * @author cuiyy
 * @version v1.0.0
 **/
@FeignClient(value = "cloud-payment-service")
public interface PayFeignApi {

    /**
     * 支付-新增支付记录
     * @param payDTO
     * @return
     */
    @PostMapping("/pay/add")
    ResultData addPay(@RequestBody PayDTO payDTO);

    /**
     * 支付-查询支付信息
     * @param id
     * @return
     */
    @GetMapping("/pay/get/{id}")
    ResultData getPayInfo(@PathVariable("id") Integer id);

    /**
     * 支付-查询配置信息
     * @return
     */
    @GetMapping("/pay/get/info")
    String mylb();

    /**
     * 支付-断路器测试
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/circuit/{id}")
    String myCircuit(@PathVariable("id") Integer id);

}
