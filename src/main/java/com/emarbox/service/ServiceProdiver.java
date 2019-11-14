package com.emarbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emarbox.mapper.develop.AdSenseMapper;

import lombok.Data;

@Data
@Service
public class ServiceProdiver {

	@Autowired
	QueryCriteriaDataSourceService queryCriteriaDataSourceService;
	@Autowired
	DevelopersService developersService;
	@Autowired
	AppInfoService appInfoService;
	@Autowired
	AdSenseService adSenseService;

}
