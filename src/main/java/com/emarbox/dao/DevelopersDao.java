package com.emarbox.dao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emarbox.domain.po.Developers;
import com.emarbox.domain.vo.qo.DeveloperQuery;
import com.emarbox.mapper.MapperProvider;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;

@Component
public class DevelopersDao {
	@Autowired
	MapperProvider mapperProvider;

	public List<Developers> getDevelopersOfNormal() {
		List<Developers> developList = mapperProvider.getDevelopPt().getDevelopersMapper().getDevelopersOfNormal();
		return ListUtils.emptyIfNull(developList);
	}

	public List<Developers> getPage(DeveloperQuery query) {
		PageInfo<Developers> doSelectPageInfo = PageHelper
				.<Developers>startPage(query.getPage().getCurrentPage(), query.getPage().getPageSize())
				.doSelectPageInfo(() -> mapperProvider.getDevelopPt().getDevelopersMapper().getDevelopersList(query));
		if (Objects.isNull(doSelectPageInfo) || CollectionUtils.isEmpty(doSelectPageInfo.getList())) {
			return Collections.emptyList();
		}
		query.getPage().setRecordCount((int) doSelectPageInfo.getTotal());
		return doSelectPageInfo.getList();
	}
	
	public Developers getDeveloper(Integer devId) {
		return mapperProvider.getDevelopPt().getDevelopersMapper().selectByPrimaryKey(devId);
	}

	public Integer inserting(Developers record) {
		record.setCreateTime(new Date());
		return mapperProvider.getDevelopPt().getDevelopersMapper().insert(record);
	}
	
	public Integer editing(Developers record) {
		record.setUpdateTime(new Date());
		return mapperProvider.getDevelopPt().getDevelopersMapper().updateByPrimaryKeySelective(record);
	}

	public Integer updateSelective(Developers record, Example example) {
		return mapperProvider.getDevelopPt().getDevelopersMapper().updateByExampleSelective(record, example);
	}

	public Integer updateBusinessPeopleId(Developers record) {
		Example example = new Example(Developers.class);
		example.createCriteria().andEqualTo("id", record.getId());
		return updateSelective(Developers.builder().businessPeopleId(record.getBusinessPeopleId())
				.updateUser(record.getUpdateUser()).updateTime(new Date()).build(), example);
	}

	public Integer developInfoAudit(Developers record) {
		Example example = new Example(Developers.class);
		example.createCriteria().andEqualTo("id", record.getId());
		return updateSelective(Developers.builder().auditsState(record.getAuditsState())
				.updateUser(record.getUpdateUser()).updateTime(new Date()).build(), example);
	}
}
