//package com.skysoft.mms.mq;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.Output;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.support.MessageBuilder;
//
///**
// * @Description 订单消息发送者
// * @author: 姚广星
// * @time: 2020/11/29 19:37
// */
//@Slf4j
//@EnableBinding(value = { OrderOutputChannelProcessor.class })
//public class OrderMessageProducer {
//	@Autowired
//	@Output(OrderOutputChannelProcessor.SAVE_ORDER_OUTPUT)
//	private MessageChannel channel;
//
//	/**
//	 * 发送消息
//	 *
//	 * @param msg
//	 */
//	public void sendMsg(String msg) {
//		channel.send(MessageBuilder.withPayload(msg).build());
//		System.out.println("消息发送成功：" + msg);
//	}
//}
