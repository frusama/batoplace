package com.kapava.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homePage")
public class HomePageController {

	@RequestMapping(value = "/welcome.htm")
	public String homePage() {
		return "welcome.page";
	}

	@RequestMapping(value = "/contact.htm")
	public String contact() {
		return "contact.page";
	}

	@RequestMapping(value = "/faq.htm")
	public String frequentlyAskedQuestions() {
		return "faq.page";
	}
}