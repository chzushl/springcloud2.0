package com.mordo.springcloud.controller;

import com.mordo.springcloud.domain.CommonResult;
import com.mordo.springcloud.domain.Order;
import com.mordo.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController{
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    @GlobalTransactional(name = "test_global",rollbackFor = Exception.class)
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}

