package com.emarbox.domain.vo.qo;

import com.emarbox.enums.AuditsStateEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AppInfoQuery extends BaseQuery {

	@JsonProperty("app_id")
	private Integer appId;

	@JsonProperty("dev_id")
	private Integer devId;

	@JsonProperty("business_people_id")
	private Integer businessPeopleId;

	@JsonProperty("app_state")
	private Integer appState;

	@JsonProperty("audits_state_enum")
	private AuditsStateEnum auditsStateEnum;

	@JsonProperty("system_type")
	private Integer systemType;

	@JsonProperty("join_up_type")
	private Integer joinUpType;
}
