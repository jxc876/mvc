package com.mike.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller(value="homeController")
public class HomeController {

    @Autowired
    private MessageSource messageSource;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private HomeController self;
	
	@Resource(name = "homeController")
	public void setSelf(HomeController self){
		this.self = self;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
        String homeGreeting = messageSource.getMessage("home.greeting", null, locale);
		logger.info(homeGreeting, locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		self.doSomething();
		
		return "home";
	}
	
	public void doSomething(){
		logger.info("doing something");
		self.greet("hello...");
	}
	
	public void greet(String greeting){
		logger.info(greeting);
	}
	
}
