package com.emarbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emarbox.dao.AdSenseDao;
import com.emarbox.domain.po.AdSense;

@Service
public class AdSenseService {
	@Autowired
	AdSenseDao adSenseDao;

	public List<AdSense> getAdSenseByAppId(Integer appId) {
		return adSenseDao.getAdSenseByAppId(appId);
	}

	public boolean updateFloorPrice(AdSense record) {
		return adSenseDao.updateFloorPrice(record) > 0;
	}
}
