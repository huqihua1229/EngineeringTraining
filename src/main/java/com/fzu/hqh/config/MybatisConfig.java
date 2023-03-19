package com.fzu.hqh.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.commons.dbcp.BasicDataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;
import java.util.Properties;

@Configuration
@MapperScan("com.hqh.mapper")
@MapperScan("com.fzu.hqh.mapper")
public class MybatisConfig {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());

        PageInterceptor pageInterceptor = new PageInterceptor();

        //这段不删掉无法正常运行
        //Properties properties = new Properties();
        //properties.load(MybatisConfig.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        //pageInterceptor.setProperties(properties);

        factoryBean.setPlugins(pageInterceptor);

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
