package com.emarbox.config;

import org.springframework.stereotype.Component;

import com.emarbox.client.EurekaClientFeign;

@Component
public class HiHystrix implements EurekaClientFeign {
	@Override
	public String sayHiFromClientEureka(String name) {
		return " hi ," + name + ", sorry , error !";
	}
}