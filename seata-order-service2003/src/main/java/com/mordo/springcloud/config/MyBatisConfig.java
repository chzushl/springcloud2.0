package com.mordo.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.mordo.springcloud.dao"})
public class MyBatisConfig {

}
