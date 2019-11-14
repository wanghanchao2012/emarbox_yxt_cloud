package com.emarbox.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

	@RequestMapping
	public String sayHi() {
		return this.sayHi(null);
	}

	@RequestMapping("hi")
	public String sayHi(String name) {
		return "welcome to " + Optional.ofNullable(name).orElse(" development flatform ~");
	}

}
