package com.emarbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emarbox.domain.po.Developers;
import com.emarbox.domain.vo.ResponseResult;
import com.emarbox.domain.vo.ResponseResult.ResponseResultBuilder;
import com.emarbox.domain.vo.qo.DeveloperQuery;
import com.emarbox.enums.MessageCodeType;
import com.emarbox.service.ServiceProdiver;

@RestController
@RequestMapping("/developers/")
public class DevelopersController {

	@Autowired
	ServiceProdiver serviceProdiver;

	@RequestMapping("/query/do/list")
	public ResponseResult<List<Developers>> getPage(@RequestBody DeveloperQuery query) {
		ResponseResultBuilder<List<Developers>> build = ResponseResult.<List<Developers>>builder();
		List<Developers> developers = serviceProdiver.getDevelopersService().getPage(query);
		return build.data(developers).page(query.getPage()).build().forOk();
	}

	@RequestMapping("/query/do/simple")
	public ResponseResult<Developers> simple(@RequestParam(name = "dev_id", required = true) Integer devId) {
		ResponseResultBuilder<Developers> build = ResponseResult.<Developers>builder();
		Developers developer = serviceProdiver.getDevelopersService().getDeveloper(devId);
		return build.data(developer).build().forOk();
	}

	@RequestMapping("/edit/do/business_people")
	public ResponseResult<String> doEditBusinessPeople(@RequestBody Developers record) {
		ResponseResultBuilder<String> build = ResponseResult.<String>builder();
		boolean state = serviceProdiver.getDevelopersService().updateBusinessPeopleId(record);
		return build.build().retIfFailed(state, MessageCodeType.failed);
	}

	@RequestMapping("/edit/do/development_audit")
	public ResponseResult<String> developmentAudit(@RequestBody Developers record) {
		ResponseResultBuilder<String> build = ResponseResult.<String>builder();
		boolean state = serviceProdiver.getDevelopersService().developInfoAudit(record);
		return build.build().retIfFailed(state, MessageCodeType.failed);
	}

	@RequestMapping("/edit/do/simple")
	public ResponseResult<String> edit(@RequestBody Developers record) {
		ResponseResultBuilder<String> build = ResponseResult.<String>builder();
		boolean state = serviceProdiver.getDevelopersService().editing(record);
		return build.build().retIfFailed(state, MessageCodeType.failed);
	}

	@RequestMapping("/add/do/simple")
	public ResponseResult<String> add(@RequestBody Developers record) {
		ResponseResultBuilder<String> build = ResponseResult.<String>builder();
		boolean state = serviceProdiver.getDevelopersService().inserting(record);
		return build.build().retIfFailed(state, MessageCodeType.failed);
	}
}
