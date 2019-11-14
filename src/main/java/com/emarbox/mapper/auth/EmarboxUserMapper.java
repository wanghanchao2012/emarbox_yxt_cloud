package com.emarbox.mapper.auth;

import java.util.List;

import com.emarbox.domain.po.EmarboxUser;
import com.emarbox.mapper.BaseMapper;

public interface EmarboxUserMapper extends BaseMapper<EmarboxUser> {

	public List<EmarboxUser> getBusinessPeopleList();

}
