package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/bootme")
	public String index() {
		return "Hello There from Spring Boot!";
	}

}
