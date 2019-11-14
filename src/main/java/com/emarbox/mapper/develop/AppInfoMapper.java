package com.emarbox.mapper.develop;

import java.util.List;

import com.emarbox.domain.po.AppInfo;
import com.emarbox.domain.vo.qo.AppInfoQuery;
import com.emarbox.mapper.BaseMapper;

public interface AppInfoMapper extends BaseMapper<AppInfo> {

	public List<AppInfo> getAppInfoList(AppInfoQuery query);
	
	public List<AppInfo> getAppInfoOfNormal();
 	
	
}
