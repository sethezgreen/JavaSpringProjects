package com.codingdojo.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "Hello World";
	}
	
	@RequestMapping("/new_route")
	public String new_route() {
		return "This is my new route!";
	}
}
