package com.mordo.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mordo.springcloud.service.FlowLimitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {
    @Resource
    private FlowLimitService flowLimitService;

    @GetMapping("/testA")
    public String testA() {
        //QPS指的是每秒客户能访问的次数，而线程数指的是同一时间内客户访问服务器的该请求，该请求使用的线程的数量（高并发）。
//        try {
//            TimeUnit.MILLISECONDS.sleep(1000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }
    @GetMapping("/testC")
    public String testC(){
        String test = flowLimitService.test();
        return test;
    }
    @GetMapping("/testD")
    public String testD(){
        String test = flowLimitService.test();
        return test;
    }


    @GetMapping("/testE")
    public String testE()
    {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");
        return "------testE";
    }
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_hotKey")
    public String testHotkey(@RequestParam(value = "p1",required = false)String p1,@RequestParam(value = "p2",required = false)String p2) {
        return "------testHotKey";
    }
    public String deal_hotKey(String p1, String p2, BlockException exception)
    {
        return "------o(╥﹏╥)o";
    }
}
