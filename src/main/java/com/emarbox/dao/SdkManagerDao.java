package com.emarbox.dao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emarbox.domain.po.SdkManager;
import com.emarbox.domain.vo.qo.SdkManagerQuery;
import com.emarbox.mapper.MapperProvider;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Component
public class SdkManagerDao {
	@Autowired
	MapperProvider mapperProvider;

	public List<SdkManager> getPage(SdkManagerQuery query) {
		PageInfo<SdkManager> doSelectPageInfo = PageHelper
				.<SdkManager>startPage(query.getPage().getCurrentPage(), query.getPage().getPageSize())
				.doSelectPageInfo(() -> mapperProvider.getDevelopPt().getSdkManagerMapper().getSdkManagerList(query));
		if (Objects.isNull(doSelectPageInfo) || CollectionUtils.isEmpty(doSelectPageInfo.getList())) {
			return Collections.emptyList();
		}
		query.getPage().setRecordCount((int) doSelectPageInfo.getTotal());
		return doSelectPageInfo.getList();
	}

	public Integer inserting(SdkManager record) {
		record.setCreateTime(new Date());
		return mapperProvider.getDevelopPt().getSdkManagerMapper().insert(record);
	}

}
