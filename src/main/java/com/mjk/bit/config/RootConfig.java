package com.mjk.bit.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"com.mjk.bit.service"})
@MapperScan(basePackages = {"com.mjk.bit.mapper"})
public class RootConfig {
	 @Bean
	 public DataSource dataSource() {	   

//	    hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
//	    hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/sample");	   
//	    hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
//	    hikariConfig.setJdbcUrl("jdbc:log4jdbc:mysql://localhost:3306/sample");
//	    hikariConfig.setUsername("root");
//	    hikariConfig.setPassword("1234");
	 
		 
		HikariConfig hikariConfig = new HikariConfig("/config/jdbc.properties");
	    HikariDataSource dataSource = new HikariDataSource(hikariConfig);

	    return dataSource;
	 }
	 
	 @Bean
	 public SqlSessionFactory sqlSessionFactory() throws Exception {
	    SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
	    sqlSessionFactory.setDataSource(dataSource());
	    return (SqlSessionFactory) sqlSessionFactory.getObject();
	 }
	 
	
}
