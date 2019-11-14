package com.emarbox.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.emarbox.mapper.auth.EmarboxUserMapper;

import lombok.Data;

@Data
@Component
public class MapperAuthProvider {

	@Autowired
	EmarboxUserMapper emarboxUserMapper;

}
