//package com.skysoft.mms.mq;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import lombok.extern.slf4j.Slf4j;
//
///**
// * @Description 订单控制器
// * @author: 姚广星
// * @time: 2020/11/29 12:03
// */
//@RestController()
//@Slf4j
//public class OrderController {
//
//	@Autowired
//	private OrderMessageProducer orderMessageProducer;
//
//	/**
//	 * 发送保存订单消息
//	 *
//	 * @param message
//	 */
//	@GetMapping(value = "/send")//SaveOrderMessage
//	public String sendSaveOrderMessage(@RequestParam("message") String message) {
//		// 发送消息
//		//String message="{\"name\":32}";
//		orderMessageProducer.sendMsg(message);
//		System.out.println("发送保存订单消息成功");
//		return "ss";
//	}
//}
