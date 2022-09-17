package com.skysoft.mms.stream.msg;

import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@RestController
public class Snippet {
	@Autowired
	private StreamBridge streamBridge;
	
	// 发送广播消息
	@GetMapping("/broadcast")
	public String sendBroadcastMessage(@RequestParam("body") String body) {

		MyMessage myMessage = new MyMessage();
		myMessage.setContent (body);
		System.out.println("想要发送:" + body);
		// 生产消息
		// 第一个参数是绑定名称，格式为：自定义的绑定名称-out-0，myBroadcast是自定义的绑定名称，out代表生产者，0是固定写法
		// 自定义的绑定名称必须与消费方法的方法名保持一致
		// 第二个参数是发送的消息实体
		streamBridge.send("mybroadcast-out-0", myMessage);
		return "SUCCESS";
	}

	static int count = 10;
	@GetMapping("/broad")
	public void sendMsg() {
		count++;
		Map<String, Object> headers = new HashMap<>();
		headers.put(MessageConst.PROPERTY_KEYS, "key1233");
		headers.put(MessageConst.PROPERTY_ORIGIN_MESSAGE_ID, count);
		// Set the delay level 1~10
		headers.put(MessageConst.PROPERTY_DELAY_TIME_LEVEL, 10);
		MyMessage msg = new MyMessage();
		msg.setContent("Delay RocketMQ " + count);
		msg.setAddress("洪湾12777号");
		msg.setName("guojing");
		msg.setTelephone("187345454");
		GenericMessage<MyMessage> gmsg =
				new GenericMessage<>(msg, headers);
		streamBridge.send("producer-out-0", gmsg);
	}
}

