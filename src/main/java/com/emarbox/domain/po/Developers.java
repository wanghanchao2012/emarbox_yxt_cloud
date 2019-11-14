package com.emarbox.domain.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * developers
 * 
 * @author hc.wang 2019-11-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "developers")
public class Developers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1477522013159917289L;

	/**
	 * id
	 */
	private Long id;

	/**
	 * 前台注册成功的开发者账号
	 */
	private String accountNo;

	/**
	 * 开发者名称
	 */
	private String developName;

	/**
	 * 归属商务
	 */
	private Integer businessPeopleId;

	/**
	 * 身份类型，1：个人，2：公司
	 */
	private Integer identityType;

	/**
	 * 联系人
	 */
	private String linkMan;

	/**
	 * 电话号码
	 */
	private Integer linkPhoneNum;

	/**
	 * 联系地址
	 */
	private String linkAddress;

	/**
	 * qq
	 */
	private String qq;

	/**
	 * 财务信息：账户持有人
	 */
	private String accountHolder;

	/**
	 * 财务信息：账户持有人地址
	 */
	private String addressAccountHolder;

	/**
	 * 银行名称
	 */
	private String bankName;

	/**
	 * 银行地址
	 */
	private String bankAddress;

	/**
	 * 银行账号
	 */
	private String bankAccount;

	/**
	 * 审核状态：\r\npending(1， 待审核 ），\r\napprove（2， 审核通过 ），\r\nreject（3， 审核不通过
	 * ），\r\nunsubmit（4， 未提交 )
	 */
	private String auditsState;

	/**
	 * 审核备注信息
	 */
	private String auditsMessage;

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
	 * insert_user
	 */
	private String insertUser;

	/**
	 * update_user
	 */
	private String updateUser;

	@Transient
	private Integer appCount;
	@Transient
	private Integer adPositionCount;
	@Transient
	private Double costAll;

}