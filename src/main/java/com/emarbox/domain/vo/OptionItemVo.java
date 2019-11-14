package com.emarbox.domain.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OptionItemVo implements Serializable {
	private static final long serialVersionUID = -215250778461614813L;
	private Object text;
	private Object value;
	private Object realValue;
	private List<OptionItemVo> children;

	public OptionItemVo preAppendValue() {
		text = "(" + value + ")".concat(this.text.toString());
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		OptionItemVo category = (OptionItemVo) obj;
		return (this.text.equals(category.getText()) && this.getValue().equals(category.getValue()));
	}

	@Override
	public final int hashCode() {
		int hashCode = 17;
		hashCode = hashCode * 31 + 1;
		hashCode = hashCode * 31 + 1;
		return hashCode;
	}
}
