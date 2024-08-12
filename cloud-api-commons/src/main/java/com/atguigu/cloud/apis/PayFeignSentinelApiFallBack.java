package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi{

    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),
                "getPayByOrderNo服务不可用，PayFeignSentinelApiFallBack.class"+"\t"+"o(╥﹏╥)o");
    }

}