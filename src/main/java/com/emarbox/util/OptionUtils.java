package com.emarbox.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.emarbox.domain.vo.OptionItemVo;

public class OptionUtils {

	public static List<OptionItemVo> defPreAppend(List<OptionItemVo> options, String tips) {
		List<OptionItemVo> currentOptions = Optional.ofNullable(options).orElse(new ArrayList<OptionItemVo>());
		currentOptions.add(0, OptionItemVo.builder().value("").text(tips).build());
		return currentOptions;
	}

	public static List<OptionItemVo> defPreAppend(List<OptionItemVo> options) {
		return defPreAppend(options, "全部");
	}
}
