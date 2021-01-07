package com.mordo.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class FlowLimitService {
    @SentinelResource(value = "service")
    public String test() {
        return "testC";
    }
}
