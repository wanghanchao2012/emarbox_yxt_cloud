package com.emarbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emarbox.client.EurekaClientFeign;

@Service
public class HiService {

	@Autowired
	EurekaClientFeign eurekaClientFeign;

	public String sayHi(String name) {
		return eurekaClientFeign.sayHiFromClientEureka(name);
	}
}