package com.codingdojo.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {

	@RequestMapping("/")
	public String hello(@RequestParam(value="name", required=false) String nameQuery, @RequestParam(value="last_name", required = false) String lastNameQuery) {
			if (nameQuery != null) {
				if (lastNameQuery != null) {
					return "Hello " + nameQuery + " " + lastNameQuery;
				}
				return "Hello " + nameQuery;
			}
		return "Hello Human";
	}
}
