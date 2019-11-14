package com.emarbox.domain.vo;

import com.emarbox.domain.vo.qo.PageQueryInfo;
import com.emarbox.enums.MessageCodeType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResponseResult<T> extends ResponseDisputeResult {

	private T data;

	private PageQueryInfo page;

	private Object collect;

	public T dataContinuable() {
		return data;
	}

	public ResponseResult<T> retIfFailed(boolean state, MessageCodeType msgCodeType) {
		if (state == false) {
			this.code = msgCodeType.getCode();
			this.message = msgCodeType.getMessage();
		}
		return forOk();
	}

	public ResponseResult<T> forOk(int code, String message) {
		this.code = code;
		this.message = message;
		return this;
	}

	public ResponseResult<T> forOk() {
		this.code = 0;
		this.message = "ok";
		return this;
	}

	public ResponseResult<T> forFail(Integer code, String msg) {
		this.code = code;
		this.message = msg;
		return this;
	}

	public ResponseResult(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public ResponseResult(Integer code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
}
