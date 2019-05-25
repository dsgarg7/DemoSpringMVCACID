package com.temp.controller;

import java.util.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.temp.model.User;

@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	public static AtomicInteger number = new AtomicInteger(0);
	static boolean init=true;
	public HomeController() {
		
		if(init) {
			init=false;
			ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
			exec.scheduleAtFixedRate(new Runnable() {
			  @Override
			  public void run() {
			    // do stuff
				  User user = new User();
					user.update(number.get());
			  }
			}, 0, 3, TimeUnit.SECONDS);
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		//System.out.println("request Count " + number.incrementAndGet() +" : time : "+formattedDate);

		return number.incrementAndGet()+"";
	}
	
	@RequestMapping(value = "/clear", method = RequestMethod.GET)
    @ResponseBody
	public String clear(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		number.set(0);;
		//System.out.println("request Count " + number +" : time : "+formattedDate);

		return number+"";
	}
	
	
	@RequestMapping(value = "/connect", method = RequestMethod.GET)
	public String connect(Locale locale, Model model) {
		
//		User user = new User();
//		user.update(5);
		return "test";
	}
}
