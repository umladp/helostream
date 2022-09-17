//package com.skysoft.mms.mq;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.messaging.Message;
//
///**
// * @Description 订单消息接收处理服务
// * @author: 姚广星
// * @time: 2020/11/29 16:03
// */
//@Slf4j
//@EnableBinding(OrderInputChannelProcessor.class)
//public class OrderMessageConsumer {
//
//	/**
//	 * 保存订单逻辑 通过OrderChannelProcessor.SAVE_ORDER接收消息 然后通过SendTo 将处理后的消息发送到
//	 * OrderChannelProcessor.ORDER
//	 *
//	 * @param message
//	 * @return
//	 */
//	@StreamListener(OrderInputChannelProcessor.SAVE_ORDER_INPUT)
//	// @SendTo(OrderOutputChannelProcessor.ORDER_OUTPUT)
//	public void saveOrderMessage(Message<String> message) {
//		System.out.println("保存订单的消息：" + message);
//		// 处理之后的订单消息
//		// return "【" + message.getPayload() + "】";
//	}
//}