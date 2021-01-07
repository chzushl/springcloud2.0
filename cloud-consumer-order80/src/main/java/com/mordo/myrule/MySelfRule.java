package com.mordo.myrule;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {
    @Bean
    public RandomRule getRandomRule(){
        return  new RandomRule();//将restTemplate的轮训规则修改为随机
    }
}
