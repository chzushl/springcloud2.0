package com.mordo.spring.cloud.service.impl;

import cn.hutool.Hutool;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.mordo.spring.cloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

@EnableBinding(Source.class)  //该注解的意思是将该service表示为source，也就是消费者output的意思，用来发送消息的业务类
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; // 消息发送管道，通过该对象可以将消息发送出去

    @Override
    public String send() {
        String serial = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(serial).build());
        return "发送serial:\t"+serial+"成功";
    }
}
