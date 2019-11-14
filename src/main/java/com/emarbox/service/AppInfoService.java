package com.emarbox.service;

import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emarbox.dao.AdSenseDao;
import com.emarbox.dao.AppInfoDao;
import com.emarbox.domain.po.AppInfo;
import com.emarbox.domain.vo.qo.AppInfoQuery;

@Service
public class AppInfoService {
	@Autowired
	AppInfoDao appInfoDao;
	@Autowired
	AdSenseDao adSenseDao;

	public List<AppInfo> getPage(AppInfoQuery query) {
		return ListUtils.emptyIfNull(appInfoDao.getPage(query));
	}

	public AppInfo getAppInfo(Integer appId) {
		return appInfoDao.getAppInfo(appId);
	}

	public boolean appInfoAudit(AppInfo record) {
		return appInfoDao.appInfoAudit(record) > 0;
	}

	public boolean editing(AppInfo record) {
		return appInfoDao.editing(record) > 0;
	}

	public boolean inserting(AppInfo record) {
		return appInfoDao.inserting(record) > 0;
	}

	public boolean updateState(AppInfo record) {
		return appInfoDao.updateState(record)>0;
	}

}
