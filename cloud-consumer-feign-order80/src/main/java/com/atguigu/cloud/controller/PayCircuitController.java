package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * <p>Description: </p>
 * <p>Date: 2024/06/06 16:07</p>
 *
 * @author cuiyy
 * @version v1.0.0
 **/
@RestController
public class PayCircuitController {

    @Autowired
    private PayFeignApi payFeignApi;

    @GetMapping(value = "/pay/circuit/{id}")
    //服务熔断
    @CircuitBreaker(name = "cloud-payment-service", fallbackMethod = "myCircuitFallback")
    public String myCircuit(@PathVariable("id") Integer id) {
        return payFeignApi.myCircuit(id);
    }

    public String myCircuitFallback(Integer id, Throwable t) {
        // 这里是容错处理逻辑，返回备用结果
        return "myCircuitFallback，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }

    /**
     *(船的)舱壁,隔离
     * @param id
     * @return
     */
    @GetMapping(value = "/feign/pay/bulkhead/{id}")
    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "myBulkheadFallback",type = Bulkhead.Type.SEMAPHORE)
    public String myBulkhead(@PathVariable("id") Integer id)
    {
        return payFeignApi.myBulkhead(id);
    }
    public String myBulkheadFallback(Throwable t)
    {
        return "myBulkheadFallback，隔板超出最大数量限制，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }

    /**
     *(船的)舱壁,隔离 threadPool
     * @param id
     * @return
     */
    @GetMapping(value = "/feign/pay/bulkhead2/{id}")
    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "myBulkheadPoolFallback",type = Bulkhead.Type.THREADPOOL)
    public CompletableFuture<String> myBulkhead2(@PathVariable("id") Integer id)
    {
        System.out.println(Thread.currentThread().getName()+"\t"+"开始进入");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"\t"+"准备离开");
        return CompletableFuture.supplyAsync(()-> payFeignApi.myBulkhead(id)+"\t"+"Bulkhead.Type.THREADPOOL");
    }
    public CompletableFuture<String> myBulkheadPoolFallback(Integer id,Throwable t)
    {
        return CompletableFuture.supplyAsync(()->"Bulkhead.Type.THREADPOOL 系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~");
    }

}
