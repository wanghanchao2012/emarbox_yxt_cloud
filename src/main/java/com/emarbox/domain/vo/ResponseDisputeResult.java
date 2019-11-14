package com.emarbox.domain.vo;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDisputeResult {

	public Integer code;

	public String message;

	public static ResponseDisputeResult forFail() {
		return new ResponseDisputeResult(-1, "exception");
	}

	@JsonIgnore
	public boolean isFail() {
		return Objects.nonNull(code) && code != 0;
	}

	@JsonIgnore
	public boolean isOk() {
		return Objects.nonNull(code) && code == 0;
	}
}
