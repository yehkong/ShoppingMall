package com.taotao.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("rest/page")
public class PageController {
	@RequestMapping("{pageName}")
	public String goPage(@PathVariable("pageName") String page) {
		System.out.println("-----------" + page);
		return page;
	}
	
}
