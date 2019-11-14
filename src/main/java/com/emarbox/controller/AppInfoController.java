package com.emarbox.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emarbox.domain.po.AdSense;
import com.emarbox.domain.po.AppInfo;
import com.emarbox.domain.vo.ResponseResult;
import com.emarbox.domain.vo.ResponseResult.ResponseResultBuilder;
import com.emarbox.domain.vo.qo.AppInfoQuery;
import com.emarbox.enums.MessageCodeType;
import com.emarbox.service.ServiceProdiver;

@RestController
@RequestMapping("/app/")
public class AppInfoController {

	@Autowired
	ServiceProdiver serviceProdiver;

	@RequestMapping("/query/do/list")
	public ResponseResult<List<AppInfo>> getPage(@RequestBody AppInfoQuery query) {
		ResponseResultBuilder<List<AppInfo>> build = ResponseResult.<List<AppInfo>>builder();
		List<AppInfo> AppInfo = serviceProdiver.getAppInfoService().getPage(query);
		return build.data(AppInfo).page(query.getPage()).build().forOk();
	}

	@RequestMapping("/query/do/simple")
	public ResponseResult<Map<String, Object>> simple(@RequestParam(name = "app_id", required = true) Integer appId) {
		ResponseResultBuilder<Map<String, Object>> build = ResponseResult.<Map<String, Object>>builder();
		AppInfo appInfo = serviceProdiver.getAppInfoService().getAppInfo(appId);
		List<AdSense> adSenseList = serviceProdiver.getAdSenseService().getAdSenseByAppId(appId);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("app_info", appInfo);
		resultMap.put("ad_sense_list", adSenseList);
		return build.data(resultMap).build().forOk();
	}

	@RequestMapping("/edit/do/development_audit")
	public ResponseResult<String> developmentAudit(@RequestBody AppInfo record) {
		ResponseResultBuilder<String> build = ResponseResult.<String>builder();
		boolean state = serviceProdiver.getAppInfoService().appInfoAudit(record);
		return build.build().retIfFailed(state, MessageCodeType.failed);
	}

	@RequestMapping("/edit/do/simple")
	public ResponseResult<String> edit(@RequestBody AppInfo record) {
		ResponseResultBuilder<String> build = ResponseResult.<String>builder();
		boolean state = serviceProdiver.getAppInfoService().editing(record);
		return build.build().retIfFailed(state, MessageCodeType.failed);
	}

	@RequestMapping("/add/do/simple")
	public ResponseResult<String> add(@RequestBody AppInfo record) {
		ResponseResultBuilder<String> build = ResponseResult.<String>builder();
		boolean state = serviceProdiver.getAppInfoService().inserting(record);
		return build.build().retIfFailed(state, MessageCodeType.failed);
	}
}
