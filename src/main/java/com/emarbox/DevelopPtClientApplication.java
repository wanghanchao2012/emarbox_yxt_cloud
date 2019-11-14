package com.emarbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.emarbox.config.DruidConfigAuthProperties;
import com.emarbox.config.DruidConfigDevelopPtProperties;
import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;

@EnableEurekaClient
@SpringBootApplication(exclude = PageHelperAutoConfiguration.class)
@EnableConfigurationProperties({ DruidConfigAuthProperties.class, DruidConfigDevelopPtProperties.class })
public class DevelopPtClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevelopPtClientApplication.class, args);
	}

}
