package com.hqh.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@MapperScan("com.hqh.mapper")
@PropertySource("classpath:jdbc.properties")
public class MybatisConfig {
    @Value("$(jdbc.driverClassName")
    private String driverClassName;
    @Value("$(jdbc.url")
    private String url;
    @Value("$(jdbc.username")
    private String username;
    @Value("$(jdbc.password")
    private String password;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }

    BasicDataSource dataSource(){
        BasicDataSource result = new BasicDataSource();
        result.setDriverClassName(driverClassName);
        result.setUrl(url);
        result.setUsername(username);
        result.setPassword(password);
        return result;
    }
}
