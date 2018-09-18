package com.pop136.customerservice.config.ds;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
@Configuration
//扫描 Mapper 接口并容器管理
@MapperScan(basePackages = MjkDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "mjkSqlSessionFactory")
public class MjkDataSourceConfig {
    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.pop136.customerservice.mapper.mjk";
    static final String MAPPER_LOCATION = "classpath:mapper/mjk/**/*.xml";
 
    @Value("${mjk.datasource.url}")
    private String url;
 
    @Value("${mjk.datasource.username}")
    private String user;
 
    @Value("${mjk.datasource.password}")
    private String password;
 
    @Value("${mjk.datasource.driverClassName}")
    private String driverClass;
 
    @Bean(name = "mjkDataSource")
    public DataSource mjkDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }
 
    @Bean(name = "mjkTransactionManager")
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(mjkDataSource());
    }
 
    @Bean(name = "mjkSqlSessionFactory")
    public SqlSessionFactory mjkSqlSessionFactory(@Qualifier("mjkDataSource") DataSource mjkDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(mjkDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MjkDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
