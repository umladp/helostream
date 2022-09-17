package com.skysoft.mms.stream.msg;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()

public class HeloController {

	@RequestMapping(path = "/helo",method = RequestMethod.GET)
	public String helo1(@RequestParam("who") String who)
	{
		return  who;
	}
}
