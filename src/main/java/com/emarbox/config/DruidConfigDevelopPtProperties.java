package com.emarbox.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "spring.datasource.devpt")
public class DruidConfigDevelopPtProperties {
	
	private String driverClassName;

	private String jdbcUrl;

	private String username;

	private String password;

	private Integer minIdle;

	private Integer maxActive;

	private Integer maxWait;

	private Long timeBetweenEvictionRunsMillis;

	private Long minEvictableIdleTimeMillis;

	private String validationQuery;

	private Boolean testWhileIdle;

	private Boolean testOnBorrow;

	private Boolean testOnReturn;

	private Boolean poolPreparedStatements;

	private Integer maxPoolPreparedStatementPerConnectionSize;

	private String filters;
	
}
