package com.emarbox.mapper.develop;

import java.util.List;

import com.emarbox.domain.po.SdkManager;
import com.emarbox.domain.vo.qo.SdkManagerQuery;
import com.emarbox.mapper.BaseMapper;

public interface SdkManagerMapper extends BaseMapper<SdkManager> {

	public List<SdkManager> getSdkManagerList(SdkManagerQuery query);

}
