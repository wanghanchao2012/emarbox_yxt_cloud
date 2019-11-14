package com.emarbox.enums.condition;

import com.emarbox.enums.IPairsEnum;

/**
 * 查询数据源类型
 * 
 * @author hc.wang
 *
 */
public enum ConditSubdivisionDevEnum implements IPairsEnum<String, String, ConditSubdivisionDevEnum> {

	all("all","全部"),
	develop_combine("develop_combine","开发者名称和开发者ID"), 
	account("account","账号"), 
	business_people("business_people","归属商务"), 
	audits_state("audits_state","审核状态");

	private String code;

	private String desc;

	ConditSubdivisionDevEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public ConditSubdivisionDevEnum get() {
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
