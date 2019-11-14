package com.emarbox.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emarbox.config.FeignConfig;
import com.emarbox.config.HiHystrix;

@FeignClient(value = "develop-pt-client", configuration = FeignConfig.class, fallback = HiHystrix.class)
public interface EurekaClientFeign {
	@GetMapping(value = "/hi")
	String sayHiFromClientEureka(@RequestParam(value = "name") String name);
}