package com.emarbox.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emarbox.domain.po.AdSense;
import com.emarbox.mapper.MapperProvider;

import tk.mybatis.mapper.entity.Example;

@Component
public class AdSenseDao {
	@Autowired
	MapperProvider mapperProvider;

	public List<AdSense> getAdSenseByAppId(Integer appId) {
		Example example = new Example(AdSense.class);
		example.createCriteria().andEqualTo("appId", appId);
		List<AdSense> adList = mapperProvider.getDevelopPt().getAdSenseMapper().selectByExample(example);
		return ListUtils.emptyIfNull(adList);
	}
	

	public Integer updateFloorPrice(AdSense record) {
		Example example = new Example(AdSense.class);
		example.createCriteria().andEqualTo("id", record.getId());
		AdSense adSense = AdSense.builder().floorPrice(record.getFloorPrice()).updateUser(record.getUpdateUser())
				.updateTime(new Date()).build();
		return mapperProvider.getDevelopPt().getAdSenseMapper().updateByExampleSelective(adSense, example);
	}
}
