package com.emarbox.domain.vo.qo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SdkManagerQuery extends BaseQuery {

	@JsonProperty("dev_id")
	private Integer devId;

	@JsonProperty("app_id")
	private Integer appId;

	@JsonProperty("system_type")
	private Integer systemType;

	@JsonProperty("account_no")
	private String accountNo;

	@JsonProperty("renew_version")
	private String renewVersion;

}
