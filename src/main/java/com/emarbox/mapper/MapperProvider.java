package com.emarbox.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MapperProvider {
	@Autowired
	MapperAuthProvider auth;
	@Autowired
	MapperDevelopPtProvider developPt;
}
