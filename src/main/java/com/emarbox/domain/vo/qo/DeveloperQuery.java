package com.emarbox.domain.vo.qo;

import com.emarbox.enums.AuditsStateEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DeveloperQuery extends BaseQuery {

	@JsonProperty("dev_id")
	private Integer devId;

	private String developer;

	@JsonProperty("account_no")
	private String accountNo;

	@JsonProperty("business_people_id")
	private Integer businessPeopleId;

	@JsonProperty("audits_state_enum")
	private AuditsStateEnum auditsStateEnum;

}
