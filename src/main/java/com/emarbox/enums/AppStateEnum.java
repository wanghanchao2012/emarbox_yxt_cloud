package com.emarbox.enums;

/**
 * 5.审核状态：待审核、审核通过、审核未通过、未提交
 * 
 * @author hc.wang
 *
 */
public enum AppStateEnum {
	pending(1,"待审核"),
	approve(2,"审核通过"),
	reject(3,"审核不通过"),
	unsubmit(4,"未提交");
	
	private Integer type;
	private String desc;
	AppStateEnum(Integer type,String desc) {
		type = this.type;
		desc = this.desc;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
