package com.emarbox.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emarbox.domain.vo.OptionItemVo;
import com.emarbox.domain.vo.ResponseResult;
import com.emarbox.domain.vo.qo.ConditionStructQo;
import com.emarbox.service.ServiceProdiver;

@RestController
@RequestMapping("/criteria/data/source/")
public class QueryCriteriaDataSourceController {

	@Autowired
	ServiceProdiver serviceProdiver;

	@RequestMapping("query")
	public ResponseResult<Object> source(@RequestBody ConditionStructQo query) {
		Map<String, List<OptionItemVo>> criteriaDataSourceMap = serviceProdiver.getQueryCriteriaDataSourceService()
				.getCriteriaDataSourceMap(query.getSourceType());
		return ResponseResult.builder().data(criteriaDataSourceMap).build().forOk();
	}

}
