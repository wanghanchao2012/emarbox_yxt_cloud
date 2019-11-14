package com.emarbox.service;

import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emarbox.dao.DevelopersDao;
import com.emarbox.domain.po.Developers;
import com.emarbox.domain.vo.qo.DeveloperQuery;

@Service
public class DevelopersService {
	@Autowired
	DevelopersDao developersDao;

	public List<Developers> getPage(DeveloperQuery query) {
		return ListUtils.emptyIfNull(developersDao.getPage(query));
	}

	public Developers getDeveloper(Integer devId) {
		return developersDao.getDeveloper(devId);
	}

	public boolean updateBusinessPeopleId(Developers record) {
		return developersDao.updateBusinessPeopleId(record) > 0;
	}

	public boolean developInfoAudit(Developers record) {
		return developersDao.developInfoAudit(record) > 0;
	}

	public boolean editing(Developers record) {
		return developersDao.editing(record) > 0;
	}

	public boolean inserting(Developers record) {
		return developersDao.inserting(record) > 0;
	}
}
