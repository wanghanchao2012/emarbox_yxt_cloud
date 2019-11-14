package com.emarbox.domain.po;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户基本信息
 * 
 * @author hc.wang 2019-11-12
 */
@Data
public class EmarboxUser implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	private Long userId;

	/**
	 * 用户类型: 管理员 admin ， 主帐号 user， 子帐号 sub_user
	 */
	private String userType;

	/**
	 * 父级用户id
	 */
	private Long parentUserId;

	/**
	 * 用户登录名
	 */
	private String loginName;

	/**
	 * 用户密码
	 */
	private String password;

	/**
	 * 用户显示名
	 */
	private String displayName;

	/**
	 * 是否已锁定
	 */
	private Integer locked;

	/**
	 * 是否已删除
	 */
	private Integer deleted;

	/**
	 * 最后登录时间
	 */
	private Date lastLoginTime;

	/**
	 * 最后登录ip
	 */
	private String lastLoginIp;

	/**
	 * 登录次数
	 */
	private Long loginTimes;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 创建者
	 */
	private String createUser;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 更新者
	 */
	private String updateUser;

	/**
	 * 结束日期
	 */
	private Date endDate;

	/**
	 * 开始日期
	 */
	private Date startDate;

	/**
	 * 是否是超管
	 */
	private Boolean isRoot;

	/**
	 * start_time
	 */
	private Date startTime;

	/**
	 * end_time
	 */
	private Date endTime;

	/**
	 * 是否是代理商用户：1 是 0 不是
	 */
	private Integer isAgent;

	/**
	 * 是否是saas用户 1是 0 不是
	 */
	private Integer isSaas;

	/**
	 * 客户行业类型
	 */
	private Integer industryType;

	/**
	 * 结算类型 1 保roi 0 不保roi
	 */
	private Integer settlementType;

	/**
	 * 0 测试用户 1 正式用户
	 */
	private Integer saasStatus;

	/**
	 * 密码最后修改时间
	 */
	private Date passUpdateTime;

	/**
	 * qq
	 */
	private String qq;

	/**
	 * 绑定渠道
	 */
	private Integer chooseSupplier;

	/**
	 * org_id
	 */
	private Integer orgId;

	/**
	 * 上级领导用户id
	 */
	private Long bossId;

	/**
	 * 用户的丁丁id
	 */
	private String ddAccount;

	/**
	 * 帐户类型：inner:内部，consumer:客户，supplier:渠道
	 */
	private String pigAccountType;

	public EmarboxUser() {
	}

}