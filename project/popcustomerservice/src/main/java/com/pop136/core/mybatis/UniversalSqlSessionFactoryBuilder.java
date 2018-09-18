package com.pop136.core.mybatis;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UniversalSqlSessionFactoryBuilder extends SqlSessionFactoryBuilder {

	public SqlSessionFactory build(Configuration config) {

	  return new UniversalSqlSessionFactory(config);
	}
	
}
