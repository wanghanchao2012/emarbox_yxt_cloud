package com.emarbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emarbox.domain.po.AdSense;
import com.emarbox.domain.vo.ResponseResult;
import com.emarbox.domain.vo.ResponseResult.ResponseResultBuilder;
import com.emarbox.enums.MessageCodeType;
import com.emarbox.service.ServiceProdiver;

@RestController
@RequestMapping("/sdk/")
public class SdkManagerController {

	@Autowired
	ServiceProdiver serviceProdiver;

	@RequestMapping("/edit/do/floor_price")
	public ResponseResult<String> doEditFloorPrice(@RequestBody AdSense record) {
		ResponseResultBuilder<String> build = ResponseResult.<String>builder();
		boolean state = serviceProdiver.getAdSenseService().updateFloorPrice(record);
		return build.build().retIfFailed(state, MessageCodeType.failed);
	}

}
