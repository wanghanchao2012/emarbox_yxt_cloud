package com.emarbox.dao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emarbox.domain.po.AdSense;
import com.emarbox.domain.po.AppInfo;
import com.emarbox.domain.vo.qo.AppInfoQuery;
import com.emarbox.mapper.MapperProvider;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;

@Component
public class AppInfoDao {
	@Autowired
	MapperProvider mapperProvider;

	public List<AppInfo> getAppInfoOfNormal() {
		List<AppInfo> list = mapperProvider.getDevelopPt().getAppInfoMapper().getAppInfoOfNormal();
		return ListUtils.emptyIfNull(list);
	}

	public List<AppInfo> getPage(AppInfoQuery query) {
		PageInfo<AppInfo> doSelectPageInfo = PageHelper
				.<AppInfo>startPage(query.getPage().getCurrentPage(), query.getPage().getPageSize())
				.doSelectPageInfo(() -> mapperProvider.getDevelopPt().getAppInfoMapper().getAppInfoList(query));
		if (Objects.isNull(doSelectPageInfo) || CollectionUtils.isEmpty(doSelectPageInfo.getList())) {
			return Collections.emptyList();
		}
		query.getPage().setRecordCount((int) doSelectPageInfo.getTotal());
		return doSelectPageInfo.getList();
	}

	public AppInfo getAppInfo(Integer appId) {
		return mapperProvider.getDevelopPt().getAppInfoMapper().selectByPrimaryKey(appId);
	}

	public Integer inserting(AppInfo record) {
		record.setCreateTime(new Date());
		return mapperProvider.getDevelopPt().getAppInfoMapper().insert(record);
	}

	public Integer editing(AppInfo record) {
		record.setUpdateTime(new Date());
		return mapperProvider.getDevelopPt().getAppInfoMapper().updateByPrimaryKeySelective(record);
	}

	public Integer updateSelective(AppInfo record, Example example) {
		return mapperProvider.getDevelopPt().getAppInfoMapper().updateByExampleSelective(record, example);
	}

	public Integer updateState(AppInfo record) {
		Example example = new Example(AppInfo.class);
		example.createCriteria().andEqualTo("id", record.getId());
		return updateSelective(AppInfo.builder().state(record.getState()).updateUser(record.getUpdateUser())
				.updateTime(new Date()).build(), example);
	}

	public Integer appInfoAudit(AppInfo record) {
		Example example = new Example(AppInfo.class);
		example.createCriteria().andEqualTo("id", record.getId());
		return updateSelective(AppInfo.builder().auditState(record.getAuditState()).updateUser(record.getUpdateUser())
				.updateTime(new Date()).build(), example);
	}

}