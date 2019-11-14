package com.emarbox.mapper.develop;

import java.util.List;

import com.emarbox.domain.po.Developers;
import com.emarbox.domain.vo.qo.DeveloperQuery;
import com.emarbox.mapper.BaseMapper;

public interface DevelopersMapper extends BaseMapper<Developers> {

	public List<Developers> getDevelopersList(DeveloperQuery query);
	
	public List<Developers> getDevelopersOfNormal();

}
