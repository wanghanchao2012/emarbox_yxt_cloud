package com.emarbox.domain.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * app_info
 * 
 * @author hc.wang 2019-11-13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "app_info")
public class AppInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 455306849249981918L;

	/**
	 * id
	 */
	private Integer id;

	/**
	 * app_name
	 */
	private String appName;

	/**
	 * 开发者Id
	 */
	private String devId;

	/**
	 * 应用类型
	 */
	private String appType;

	/**
	 * 系统类型
	 */
	private String systemType;

	/**
	 * 接入类型
	 */
	private String joinUpType;

	/**
	 * 结算方式
	 */
	private String costType;

	/**
	 * 归属商务
	 */
	private Integer businessPeopleId;

	/**
	 * 应用状态
	 */
	private String appState;

	/**
	 * 审核状态
	 */
	private String auditState;

	/**
	 * 1：开启，0：暂停
	 */
	private Integer state;

	/**
	 * 上架状态：1:上架：0：未上架
	 */
	private Integer onlineState;

	/**
	 * 应用下载地址
	 */
	private String downloadAddress;

	/**
	 * 应用介绍
	 */
	private String appDesc;

	private Integer deleted;

	private Integer locked;

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