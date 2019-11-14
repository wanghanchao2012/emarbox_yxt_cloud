package com.emarbox.enums.condition;

import com.emarbox.enums.IPairsEnum;

/**
 * 查询数据源类型
 * 
 * @author hc.wang
 *
 */
public enum ConditSubdivisionCommonEnum implements IPairsEnum<String, String, ConditSubdivisionCommonEnum> {

	all("all","全部");

	private String code;

	private String desc;

	ConditSubdivisionCommonEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public ConditSubdivisionCommonEnum get() {
		return this;
	}

	@Override
	public String key() {
		return this.code;
	}

	@Override
	public String value() {
		return this.desc;
	}

}
