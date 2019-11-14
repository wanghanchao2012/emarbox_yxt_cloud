package com.emarbox.enums;

/**
 * 身份類型
 * @author hc.wang
 *
 */
public enum IdentityTypeType {
	personal(1,"个人"), 
	company(2,"公司");

	private String desc;

	IdentityTypeType(Integer type,String desc) {
		desc = this.desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
