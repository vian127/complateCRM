package com.pop136.core.mybatis;

import com.pop136.core.AnnotationUtils;
import com.pop136.core.mybatis.annotation.Id;
import com.pop136.core.mybatis.annotation.Table;
import com.pop136.core.mybatis.annotation.Transient;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.exceptions.ExceptionFactory;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.lang.reflect.Field;
import java.util.*;

public class UniversalSqlSession extends DefaultSqlSession implements IUniversalSqlSession {
	private Configuration configuration;
	private Executor executor;
	private boolean autoCommit;
	private TypeHandlerRegistry typeHandlerRegistory = new TypeHandlerRegistry() ;
	private static final Map<String,MappedStatement> CACHE_MAPPED_STMT = new HashMap< String , MappedStatement>() ;
	
	public UniversalSqlSession(Configuration configuration, Executor executor, boolean autoCommit) {
		super(configuration, executor, autoCommit);
		this.configuration = configuration;
		this.executor = executor;
		this.autoCommit = autoCommit;
	}

	public UniversalSqlSession(Configuration configuration, Executor executor) {
		super(configuration, executor);
		this.configuration = configuration;
		this.executor = executor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> E findById(Class<E> clazz, Object p) {
		try {
			MappedStatement ms = CACHE_MAPPED_STMT.get( getMappedKey( clazz , "findById" ) ) ;
			if( ms == null ){
				CACHE_MAPPED_STMT.put( getMappedKey( clazz , "findById" ) , 
						buildStatement( buildSelectSqlSource( clazz , p ) ,  SqlCommandType.SELECT ,
								Arrays.asList( buildResultMap( clazz , "findById") ) ) ) ;
				ms = CACHE_MAPPED_STMT.get( getMappedKey( clazz , "findById" ) ) ;
			}
			List<Object> result =  executor.query( ms, p , RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER );
			if( result == null || result.isEmpty() ){
				return null ;
			}
			return (E) result.get(0) ;
		} catch (Exception e) {
			throw ExceptionFactory.wrapException("Error querying database.  Cause: " + e, e);
		} finally {
			ErrorContext.instance().reset();
		}
	}
	
	private <E> String getMappedKey( Class<E> clazz , String extra ){
		return clazz.getName()+"."+extra ;
	}
	
	private <T> ResultMap buildResultMap(Class<T> clazz , String id ){
		Field [] fields = clazz.getDeclaredFields() ;
		List<ResultMapping> resultMappings = new ArrayList<ResultMapping>() ;
		for( Field field : fields ){
			if( AnnotationUtils.getAnnotation( field , Transient.class ) != null ){
				continue ;
			}
			ResultMapping.Builder rmpBuilder = new ResultMapping.Builder( configuration, field.getName() );
			rmpBuilder.typeHandler( typeHandlerRegistory.getTypeHandler( field.getType() ) ) ;
			rmpBuilder.column( getColumn( field.getName()  ) ) ;
			rmpBuilder.javaType( field.getType() ) ;
			resultMappings.add( rmpBuilder.build() ) ;
		}
		return new ResultMap.Builder(configuration, id, clazz , resultMappings , true ).build() ;
	}
	
	private <E> SqlSource buildSelectSqlSource(Class<E> clazz , Object id ) throws Exception {
		Table table = AnnotationUtils.getAnnotation( clazz , Table.class ) ;
		if( table == null ){
			throw new IllegalArgumentException("No Table annotation found on " + clazz ) ;
		}
		Field [] fields = clazz.getDeclaredFields() ;
		Field idField = null ;
		for( Field field : fields ){
			if( AnnotationUtils.getAnnotation( field , Id.class ) != null ){
				idField = field ;
			}
		}
		if( idField == null ){
			throw new IllegalArgumentException("No primary key on " + clazz +" found !") ;
		}
		StringBuffer sql = new StringBuffer(
				String.format("SELECT * FROM %s WHERE %s = ?", 
						table.value().toUpperCase() , getColumn( idField.getName() ).toUpperCase() ) ) ;
		List<ParameterMapping> paramMappings = new ArrayList<ParameterMapping>() ;
		paramMappings.add( buildParameter( null , idField ) ) ;
		return new StaticSqlSource( configuration , sql.toString() , paramMappings ) ;
	}
	
	
	private String getColumn( String fieldName ){
		String column = "" ;
		for( int i = 0 ; i < fieldName.length() ; i ++ ){
			char c = fieldName.charAt( i ) ;
			if( Character.isUpperCase( c ) ){
				column += "_" ;
			}
			column += (c+"").toUpperCase() ;
		}
		return column ;
	}

	@Override
	public <E> int update(Class<E> clazz, E e) {
		int result = 0 ;
		try {
			MappedStatement ms = CACHE_MAPPED_STMT.get( getMappedKey( clazz , "update" ) ) ;
			if( ms == null ){
				CACHE_MAPPED_STMT.put( getMappedKey( clazz , "update" ) , 
						buildStatement(  buildUpdateSqlSource( clazz , e ) , SqlCommandType.UPDATE , null ) ) ;
				ms = CACHE_MAPPED_STMT.get( getMappedKey( clazz , "update" ) ) ;
			}
			result = executor.update( ms , e ) ;
		} catch (Exception exp ) {
			throw ExceptionFactory.wrapException("Error querying database.  Cause: " + exp , exp);
		} finally {
			ErrorContext.instance().reset();
		}
		return result;
	}

	@Override
	public <E> int insert(Class<E> clazz, E e) {
		int result = 0 ;
		try {
			MappedStatement ms = CACHE_MAPPED_STMT.get( getMappedKey( clazz , "insert" ) ) ;
			if( ms == null ){
				CACHE_MAPPED_STMT.put( getMappedKey( clazz , "insert" ) , 
						 buildStatement( buildInsertSqlSource( clazz , e ) , SqlCommandType.INSERT , null )  ) ;
				ms = CACHE_MAPPED_STMT.get( getMappedKey( clazz , "insert" ) ) ;
			}
			result = executor.update( ms ,  e ) ;
		} catch (Exception exp ) {
			throw ExceptionFactory.wrapException("Error querying database.  Cause: " + exp , exp);
		} finally {
			ErrorContext.instance().reset();
		}
		return result;
	}
	
	private <E> List<Field> getNotNullField( Class<E> clazz , E e ){
		Field [] fields = clazz.getDeclaredFields() ;
		List<Field> notNullFields = new ArrayList<Field>() ;
		for( Field field : fields ){
			String value = null ;
			try{
				value = BeanUtils.getProperty( e , field.getName() ) ;
			}catch(Exception exp ){
				// Ignore .
			}
			if( value == null ){
				continue ;
			}
			notNullFields.add( field ) ;
		}
		return notNullFields ;
	}
	
	private <E> SqlSource buildUpdateSqlSource(Class<E> clazz , E e ) throws Exception {
		Table table = AnnotationUtils.getAnnotation( clazz , Table.class ) ;
		if( table == null ){
			throw new IllegalArgumentException("Table annotation not found in " + clazz ) ;
		}
		List<Field> fields = getNotNullField( clazz , e ) ;
		if( fields == null || fields.isEmpty() ){
			throw new IllegalArgumentException("Not updated field found !") ;
		}
		StringBuffer sql = new StringBuffer( String.format("UPDATE %s SET ", table.value().toUpperCase() ) ) ;
		List<ParameterMapping> paramMappings = new ArrayList<ParameterMapping>() ;
		Field idField = null ;
		for( Field field : fields ){
			if( AnnotationUtils.getAnnotation( field , Id.class ) != null ){
				idField = field ;
				continue ;
			}
			sql.append( String.format("%s=? ,", getColumn(field.getName()).toUpperCase() ) ) ;
			paramMappings.add( buildParameter( e , field) ) ;
		}
		String strSql = sql.toString().trim() ;
		if( strSql.lastIndexOf(",") != -1 ){
			strSql = strSql.substring(0 , strSql.length() - 1 ) ;
		}
		sql = new StringBuffer( strSql ) ;
		if( idField != null ){
			sql.append( String.format(" WHERE %s = ? ",  getColumn( idField.getName() ).toUpperCase() ) ) ;
			paramMappings.add( buildParameter( e , idField ) ) ;
		}
		System.out.println( sql.toString() );
		return new StaticSqlSource( configuration , sql.toString() , paramMappings ) ;
	}
	
	private <E> MappedStatement buildStatement(
      SqlSource sqlSource , SqlCommandType commandType , List<ResultMap> resultMaps ) throws Exception{
		MappedStatement.Builder msBuilder = new MappedStatement.Builder( configuration, "id", sqlSource , commandType ) ;
		if( resultMaps != null && !resultMaps.isEmpty() ){
			msBuilder.resultMaps( resultMaps ) ;
		}
		return msBuilder.build() ;
	}
	
	private <E> SqlSource buildDeleteSqlSource(Class<E> clazz , Object p ) throws Exception{
		Table table = AnnotationUtils.getAnnotation(clazz, Table.class ) ;
		if( table == null ){
			throw new IllegalArgumentException("Entity is not annotation in " + clazz ) ;
		}
		if( p == null ){
			throw new IllegalArgumentException("Build delete sql source error , no condition found !") ;
		}
		Field [] fields = clazz.getDeclaredFields() ;
		Field idField = null ;
		for( Field field : fields ){
			if( AnnotationUtils.getAnnotation( field, Id.class ) != null ) {
				idField = field ;
			}
		}
		if( idField == null ){
			throw new IllegalArgumentException("Build delete sql source error , no id condition found !") ;
		}
		StringBuffer sql = new StringBuffer(String.format(
				"DELETE FROM %s WHERE %s = ?" , table.value().toUpperCase() , getColumn( idField.getName() ).toUpperCase() ) ) ;
		List<ParameterMapping> paramMappings = new ArrayList<ParameterMapping>() ;
		paramMappings.add( buildParameter( null , idField ) ) ;
		return new StaticSqlSource( configuration , sql.toString() , paramMappings ) ;
	}
	
	
	private <E> ParameterMapping buildParameter(E e , Field field ) throws Exception {
		if( e != null && ( BeanUtils.getProperty( e , field.getName() ) == null ) ){
			return null ;
		}
		ParameterMapping.Builder mappingBuilder = new ParameterMapping.Builder(
				configuration , field.getName() , typeHandlerRegistory.getTypeHandler( field.getType() ) ) ;
		mappingBuilder.javaType( field.getType() ) ;
		return mappingBuilder.build() ;
	}
	
	private <E> SqlSource buildInsertSqlSource(Class<E> clazz , E e ) throws Exception{
		Table table = AnnotationUtils.getAnnotation(clazz, Table.class ) ;
		if( table == null ){
			throw new IllegalArgumentException("Entity is not annotation in " + clazz ) ;
		}
		StringBuilder sql = new StringBuilder(String.format("INSERT INTO %s (", table.value().toUpperCase() ) ) ;
		List<ParameterMapping> paramMappings = new ArrayList<ParameterMapping>() ;
		
		List<Field> fields = getNotNullField( clazz , e) ;
		for( Field field : fields ){
			sql.append( getColumn( field.getName() ).toUpperCase() + " , " ) ;
		}
		String strSql = sql.toString().trim() ;
		if( strSql.lastIndexOf(",") != -1 ){
			strSql = strSql.substring( 0 , strSql.length() - 1 ) ;
		}
		sql = new StringBuilder( strSql ) ;
		
		sql.append( " ) VALUES(  " ) ;
		for( Field field : fields ){
			sql.append(" ? ,") ;
			paramMappings.add( buildParameter( e , field ) ) ;
		}
		strSql = sql.toString().trim() ;
		if( strSql.lastIndexOf(",") != -1 ){
			strSql = strSql.substring( 0 , strSql.length() - 1 ) ;
		}
		sql = new StringBuilder( strSql ) ;
		sql.append(" ) ") ;
		
		System.out.println(sql.toString());
		return new StaticSqlSource( configuration , sql.toString() , paramMappings ) ;
	}

	
	@Override
	public <E> int delete( Class<E> clazz , Object p ) {
		int result = 0 ;
		try {
			MappedStatement ms = CACHE_MAPPED_STMT.get( getMappedKey( clazz , "delete" ) ) ;
			if( ms == null ){
				CACHE_MAPPED_STMT.put( getMappedKey( clazz , "delete" ) , 
						buildStatement( buildDeleteSqlSource( clazz , p ) , SqlCommandType.DELETE , null )  ) ;
				ms = CACHE_MAPPED_STMT.get( getMappedKey( clazz , "delete" ) ) ;
			}
			result = executor.update( ms ,  p ) ;
		} catch (Exception exp ) {
			throw ExceptionFactory.wrapException("Error querying database.  Cause: " + exp , exp);
		} finally {
			ErrorContext.instance().reset();
		}
		return result;
	}
	
}
