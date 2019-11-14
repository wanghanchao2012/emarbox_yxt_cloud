package com.emarbox.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emarbox.mapper.develop.AdSenseMapper;
import com.emarbox.mapper.develop.AppInfoMapper;
import com.emarbox.mapper.develop.DevelopersMapper;
import com.emarbox.mapper.develop.SdkManagerMapper;

import lombok.Data;

@Data
@Component
public class MapperDevelopPtProvider {

	@Autowired DevelopersMapper developersMapper;
	@Autowired AppInfoMapper appInfoMapper;
	@Autowired AdSenseMapper adSenseMapper;
	@Autowired SdkManagerMapper sdkManagerMapper;

}
