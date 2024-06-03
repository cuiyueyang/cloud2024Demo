package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Description: </p>
 * <p>Date: 2024/04/11 16:19</p>
 *
 * @author cuiyy
 * @version v1.0.0
 **/
@RestController
@Slf4j
@Tag(name = "支付微服务模块", description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增", description = "新增支付流水方法，json串做参数")
    public ResultData addPay(@RequestBody Pay pay) {
        log.info("add pay");
        Integer i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值:" + i);
    }

    @DeleteMapping(value = "/pay/del/{id}")
    public ResultData deletePay(@PathVariable("id") Integer id) {
        Integer i =payService.delete(id);
        return ResultData.success("成功删除记录，返回值:" + i);
    }

    @PutMapping(value = "/pay/update")
    public ResultData updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        Integer i = payService.update(pay);
        return ResultData.success("成功更新记录，返回值:" + i);
    }

    @GetMapping(value = "/pay/get/{id}")
    public ResultData getPay(@PathVariable("id") Integer id) {
        if (id == -1) {
            throw new RuntimeException("id不能为负数");
        }
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/getAll")
    public ResultData getAllPay() {
        List<Pay> payList = payService.getAll();
        return ResultData.success(payList);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    public String getInfoByConsul(@Value("${atguigu.info}") String atguiguInfo) {
        return "server.port:" + port + ",atguigu.info:" + atguiguInfo;
    }


}
