package com.lc.platform.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomePageController {
	@RequestMapping(value="/")
	public String index(){
		return "index";
	}
}
