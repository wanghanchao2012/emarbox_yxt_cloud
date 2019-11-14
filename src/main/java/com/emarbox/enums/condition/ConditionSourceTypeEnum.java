package com.emarbox.enums.condition;

import java.util.List;

import com.emarbox.enums.IPairsEnum;
import com.google.common.collect.Lists;

public enum ConditionSourceTypeEnum {
	
	developer_module("developer_module", developer_module()),
	app_module("app_module", app_info_module());
	
	
	private String type;
	private List<? extends IPairsEnum<?,?,?>> sourceTypeList;
	ConditionSourceTypeEnum(String type, List<? extends IPairsEnum<?,?,?>> sourceTypeList) {
		this.type = type;
		this.sourceTypeList = sourceTypeList;
	}

	private static List<? extends IPairsEnum<?,?,?>> developer_module() {
		return Lists.newArrayList(
				ConditSubdivisionDevEnum.account, 
				ConditSubdivisionDevEnum.audits_state,
				ConditSubdivisionDevEnum.business_people, 
				ConditSubdivisionDevEnum.develop_combine);
	}
	
	private static List<? extends IPairsEnum<?,?,?>> app_info_module() {
		return Lists.newArrayList(
				ConditSubdivisionDevEnum.develop_combine,
				ConditSubdivisionDevEnum.account, 
				ConditSubdivisionDevEnum.audits_state,
				ConditSubdivisionDevEnum.business_people,
				ConditSubdivisionAppEnum.app_name,
				ConditSubdivisionAppEnum.app_state,
				ConditSubdivisionAppEnum.join_up_type,
				ConditSubdivisionAppEnum.system_type
			);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<? extends IPairsEnum<?, ?, ?>> getSourceTypeList() {
		return sourceTypeList;
	}

	public void setSourceTypeList(List<? extends IPairsEnum<?, ?, ?>> sourceTypeList) {
		this.sourceTypeList = sourceTypeList;
	}

 
}
