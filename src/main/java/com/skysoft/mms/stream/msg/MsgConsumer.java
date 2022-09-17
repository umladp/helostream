package com.skysoft.mms.stream.msg;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 消费者
 */
@Slf4j
@Component
public class MsgConsumer {
    // 消费广播消息

    @Bean
    public Consumer<Message<MyMessage>> mybroadcast() {  // 方法名必须与生产消息时自定义的绑定名称一致
        return message -> {
        	System.out.println("接收广播消息：{}"+message.getPayload());
            log.info("接收广播消息：{}", message.getPayload());
        };
    }
}