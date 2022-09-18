package com.skysoft.mms.stream.msg;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;


import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

@ComponentScan(basePackages = {"com.skysoft.mms"})
@SpringBootApplication
@Slf4j
@EnableDubbo
public class HeloStreamApplication {
	@Autowired
	private StreamBridge streamBridge;
	public static void main(String[] args) {
		SpringApplication.run(HeloStreamApplication.class, args);
	}
	/*
	@Bean
	public Supplier<Date> supplier() {
		System.out.println("发送了");
		return () -> new Date();
	}

	@Bean
	public Consumer<Date> process() {
		System.out.println("收到了！");
		return input -> {
			System.out.println(input.toString());
		};
		//return System.out::println;
	}
	 */

	/*
	@Bean
	public ApplicationRunner producerDelay() {
		return args -> {
			for (int i = 0; i < 10; i++) {
				String key = "KEY" + i;
				Map<String, Object> headers = new HashMap<>();
				headers.put(MessageConst.PROPERTY_KEYS, key);
				headers.put(MessageConst.PROPERTY_ORIGIN_MESSAGE_ID, i);
				// Set the delay level 1~10
				headers.put(MessageConst.PROPERTY_DELAY_TIME_LEVEL, 2);
				MyMessage msg=new MyMessage();
				msg.setContent("Delay RocketMQ " + i);
				msg.setAddress("洪湾12号");
				msg.setName("guojing");
				msg.setTelephone("187345454");
				Message<MyMessage> gmsg = new GenericMessage(msg, headers);
				streamBridge.send("producer-out-0", gmsg);
			}
		};
	}
*/
	static int count=1000;

	@Bean
	public Supplier<Message<MyMessage>> producer32() {
		System.out.println("发送了");
		return () -> {
			count ++;
			Map<String, Object> headers = new HashMap<>();
			headers.put(MessageConst.PROPERTY_KEYS, "key1233");
			headers.put(MessageConst.PROPERTY_ORIGIN_MESSAGE_ID, count);
			// Set the delay level 1~10
			headers.put(MessageConst.PROPERTY_DELAY_TIME_LEVEL, 10);
			MyMessage msg=new MyMessage();
			msg.setContent("Delay RocketMQ " + count);
			msg.setAddress("洪湾12777号");
			msg.setName("guojing");
			msg.setTelephone("187345454");
			return new GenericMessage<>(msg, headers);
			//return qmsg;
		} ;
	}

	@Bean()
	public Consumer<Message<MyMessage>> consumer() {
		System.out.println("consumer 99  ");
		return msg ->
			log.info(Thread.currentThread().getName() + " Consumer 99 Receive New Messages: " + msg.getPayload());

	}

	@Bean()
	public Consumer<Message<MyMessage>> process() {
		System.out.println("process 66  ");
		return msg ->
			log.info(Thread.currentThread().getName() + " Consumer 66 Receive New Messages: " + msg.getPayload());

	}

}
