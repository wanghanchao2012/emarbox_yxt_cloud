package com.emarbox.enums.condition;

import com.emarbox.enums.IPairsEnum;

/**
 * 查询数据源类型
 * 
 * @author hc.wang
 *
 */
public enum ConditSubdivisionAppEnum implements IPairsEnum<String, String, ConditSubdivisionAppEnum> {

	all("all","全部"),
	app_name("app_name","应用名称"), 
	app_state("app_state","应用状态"), 
	system_type("system_type","系统类型"), 
	join_up_type("join_up_type","接入类型");

	private String code;

	private String desc;

	ConditSubdivisionAppEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public ConditSubdivisionAppEnum get() {
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
