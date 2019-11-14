package com.emarbox.domain.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ad_sense
 * 
 * @author hc.wang 2019-11-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ad_sense")
public class AdSense implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Integer id;

	/**
	 * ad_sense_name
	 */
	private String adSenseName;

	/**
	 * ad_sense_desc
	 */
	private String adSenseDesc;

	/**
	 * ad_type
	 */
	private String adType;

	/**
	 * cost_type
	 */
	private String costType;

	/**
	 * floor_price
	 */
	private Integer floorPrice;

	/**
	 * 0:正常，1:删除
	 */
	private Integer deleted;

	private Integer appId;

	/**
	 * create_time
	 */
	private Date createTime;

	/**
	 * update_time
	 */
	private Date updateTime;

	/**
	 * create_user
	 */
	private String createUser;

	/**
	 * update_user
	 */
	private String updateUser;

}