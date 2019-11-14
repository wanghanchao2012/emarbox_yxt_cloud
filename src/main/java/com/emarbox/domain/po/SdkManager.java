package com.emarbox.domain.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * sdk_manager
 * 
 * @author hc.wang 2019-11-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sdk_manager")
public class SdkManager implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Integer id;

	/**
	 * renew_time
	 */
	private Date renewTime;

	/**
	 * renew_version
	 */
	private String renewVersion;

	/**
	 * system_type
	 */
	private String systemType;

	/**
	 * 应用包大小 单位m
	 */
	private Double packageSize;

	/**
	 * 跟新日志
	 */
	private String renewDesc;

	/**
	 * package_url
	 */
	private String packageUrl;

	/**
	 * 应用id
	 */
	private Integer appId;

	/**
	 * 0:正常，1:删除
	 */
	private Integer deleted;

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