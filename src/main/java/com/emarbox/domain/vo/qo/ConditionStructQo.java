package com.emarbox.domain.vo.qo;

import java.util.List;

import com.emarbox.enums.condition.ConditionSourceTypeEnum;

import lombok.Data;

@Data
public class ConditionStructQo {

	private List<ConditionSourceTypeEnum> customeSourceTypes;

	private List<ConditionSourceTypeEnum> authSourceTypes;

	private ConditionSourceTypeEnum sourceType;

}
