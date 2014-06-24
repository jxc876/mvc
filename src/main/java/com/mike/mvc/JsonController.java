package com.mike.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mike.model.User;

@Controller
public class JsonController {

	private Logger log = LoggerFactory.getLogger(JsonController.class);

	private User user = new User("john", "doe", "jdoe", "jdoe@gmail.com");

	@RequestMapping("/get/json")
	@ResponseBody
	public User getJson() {

		log.info("inside getJson()");

		return user;
	}

	@RequestMapping("/get/text")
	@ResponseBody
	public String getString(){
		return user.toString();
	}
}
