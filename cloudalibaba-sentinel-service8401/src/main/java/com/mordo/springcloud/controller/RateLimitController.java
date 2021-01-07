package com.mordo.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.mordo.springcloud.entities.CommonResult;
import com.mordo.springcloud.entities.Payment;
import com.mordo.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException")
    public CommonResult customerBlockHandler() {
        return new CommonResult(4444, "按客戶自定义", new Payment(2020L, "serial003"));
    }


}
