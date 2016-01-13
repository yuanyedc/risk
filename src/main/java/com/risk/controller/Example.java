package com.risk.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.risk.bean.Risk;

@RestController
@EnableAutoConfiguration
public class Example {

	@RequestMapping("/")
	public String home() {
		return "Spring Boot";
	}

	@RequestMapping("/risk")
	public Risk getRisk() {
		Risk risk = new Risk();
		risk.setHigh("A");
		risk.setLow("C");
		risk.setLevel(1);
		return risk;
	}

	public static void main(String[] args) {
		SpringApplication.run(Example.class, args);
	}
}
