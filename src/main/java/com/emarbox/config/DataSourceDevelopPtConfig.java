package com.emarbox.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = {  "com.emarbox.mapper.develop"}, sqlSessionTemplateRef = "dspSqlSessionTemplate")
public class DataSourceDevelopPtConfig {

	@Autowired
	private DruidConfigDevelopPtProperties druidConfigPrimaryProperties;

	@Bean(name = "dspDataSource", initMethod = "init", destroyMethod = "close")
	@Primary
	public DataSource testDataSource() throws SQLException {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(druidConfigPrimaryProperties.getDriverClassName());
		druidDataSource.setUrl(druidConfigPrimaryProperties.getJdbcUrl());
		druidDataSource.setUsername(druidConfigPrimaryProperties.getUsername());
		druidDataSource.setPassword(druidConfigPrimaryProperties.getPassword());
		druidDataSource.setInitialSize(druidConfigPrimaryProperties.getMinIdle());
		druidDataSource.setMinIdle(druidConfigPrimaryProperties.getMinIdle());
		druidDataSource.setMaxActive(druidConfigPrimaryProperties.getMaxActive());
		druidDataSource.setMaxWait(druidConfigPrimaryProperties.getMaxWait());
		druidDataSource.setTimeBetweenEvictionRunsMillis(druidConfigPrimaryProperties.getTimeBetweenEvictionRunsMillis());
		druidDataSource.setMinEvictableIdleTimeMillis(druidConfigPrimaryProperties.getMinEvictableIdleTimeMillis());
		druidDataSource.setValidationQuery(druidConfigPrimaryProperties.getValidationQuery());
		druidDataSource.setTestWhileIdle(druidConfigPrimaryProperties.getTestWhileIdle());
		druidDataSource.setTestOnBorrow(druidConfigPrimaryProperties.getTestOnBorrow());
		druidDataSource.setTestOnReturn(druidConfigPrimaryProperties.getTestOnReturn());
		druidDataSource.setPoolPreparedStatements(druidConfigPrimaryProperties.getPoolPreparedStatements());
		druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(druidConfigPrimaryProperties.getMaxPoolPreparedStatementPerConnectionSize());
		druidDataSource.setFilters(druidConfigPrimaryProperties.getFilters());
		return druidDataSource;
	}

	@Bean(name = "dspSqlSessionFactory")
	@Primary
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("dspDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
        Interceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "false");
        interceptor.setProperties(properties);
        bean.setPlugins(new Interceptor[] {interceptor});
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/develop/*.xml"));
		bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		bean.getObject().getConfiguration().setCallSettersOnNulls(true);
		return bean.getObject();
	}

	@Bean(name = "dspTransactionManager")
	@Primary
	public DataSourceTransactionManager testTransactionManager(@Qualifier("dspDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "dspSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("dspSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean(name = "namedParameterDspJdbcTemplate")
	public NamedParameterJdbcTemplate namedParameterParimaryJdbcTemplate(@Qualifier("dspDataSource") DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}

	@Bean(name = "dspJdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(@Qualifier("dspDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
}
