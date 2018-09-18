package com.pop136.core.mybatis;

import com.pop136.core.BeanUtil;
import com.pop136.core.StringLang;
import com.pop136.core.mybatis.criteria.Condition;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import com.pop136.core.mybatis.criteria.UpdateValue;
import com.pop136.core.mybatis.criteria.SearchCriteria;
import com.pop136.core.exception.DataAccessException;
import com.pop136.core.mybatis.annotation.Table;
import com.pop136.core.mybatis.criteria.UpdateCriteria;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AbstractConditionHandler {
	private Map<String,ConditionMapping> conditionMappings = new HashMap<String,ConditionMapping>() ;
	protected final static String DEF_MAPPING_KEY = "default.mapping.key" ;
	private Condition[]  unityFlterCondition ;
	protected void putMapping( String mappingName , ConditionMapping mapping ){
		conditionMappings.put( mappingName , mapping ) ;
	}
	protected ConditionMapping getMapping( String mappingName ){
		return conditionMappings.get( mappingName ) ;
	}
	protected SearchCriteria resolveSearchCriteria(
			Map<String , Object> params , String mappingName , String ... properties ){
		if( StringUtils.isEmpty( mappingName ) ) {
			mappingName = DEF_MAPPING_KEY ;
		}
		Table table = AnnotationUtils.getAnnotation( this.getClass() , Table.class ) ;
		if( table == null ){
			throw new DataAccessException("查询失败，未发现Table注解.") ;
		}
		SearchCriteria criteria = new SearchCriteria( table.value() ) ;
		ConditionMapping mapping = conditionMappings.get( mappingName ) ;
		if( mapping != null && params != null && !params.isEmpty() ){
			for( Map.Entry<String, Object> param : params.entrySet() ){
				if( !mapping.containsKey( param.getKey() ) ){
					continue ;
				}
				Condition condition = BeanUtil.deepCopy( mapping.get( param.getKey() ) ) ;
				condition.setValue( param.getValue() );
				criteria.addConditions( condition );
			}
		}
		if( properties != null &&  properties.length != 0  ){
			for( String property : properties ){
				if( StringUtils.isEmpty(  property ) ){
					continue ;
				}
				criteria.addColumns( StringLang.toColumnWithHump( property ) );
			}
		}
		if( unityFlterCondition != null && unityFlterCondition.length != 0 ){
			criteria.addConditions( unityFlterCondition  );
		}
		return criteria ;
	}
	
	protected SearchCriteria resolveSearchCriteria(
			String by , Object value , String ... properties ){
		if( StringUtils.isEmpty( by ) ){
			throw new DataAccessException("构建查询参数失败,查询字段不能为空!") ;
		}
		Table table = AnnotationUtils.getAnnotation( this.getClass() , Table.class ) ;
		if( table == null ){
			throw new DataAccessException("查询失败，未发现Table注解.") ;
		}
		SearchCriteria criteria = new SearchCriteria( table.value() ) ;
		criteria.addConditions( new Condition( StringLang.toColumnWithHump( by ) , value , Condition.SYMBOL.EQ ) ) ;
		if( properties != null &&  properties.length != 0  ){
			for( String property : properties ){
				if( StringUtils.isEmpty(  property ) ){
					continue ;
				}
				criteria.addColumns( StringLang.toColumnWithHump( property ) );
			}
		}
		if( unityFlterCondition != null && unityFlterCondition.length != 0 ){
			criteria.addConditions( unityFlterCondition  );
		}
		return criteria ;
	}
	
	protected UpdateCriteria resolveUpdateCriteria(Map<String,Object> params , Condition ... conditions  ){
		if( params == null || params.isEmpty() ){
			throw new DataAccessException("记录创建失败，参数为空 .") ;
		}
		Table table = AnnotationUtils.getAnnotation( this.getClass() , Table.class ) ;
		if( table == null ){
			throw new DataAccessException("记录创建失败，DAO未发现Table注解 .") ;
		}
		UpdateCriteria criteria = new UpdateCriteria( table.value() ) ;
		for( Map.Entry<String, Object> param : params.entrySet() ){
			UpdateValue value = new UpdateValue() ;
			value.setColumn( StringLang.toColumnWithHump( param.getKey() ) );
			value.setValue( param.getValue() );
			criteria.addUpdateValue( value );
		}
		if( conditions != null && conditions.length != 0 ){
			criteria.setConditions( Arrays.asList( conditions ) );
		}
		if( unityFlterCondition != null && unityFlterCondition.length != 0 ){
			criteria.setConditions( Arrays.asList( unityFlterCondition )  );
		}
		return criteria ;
	}
	public Condition[] getUnityFlterCondition() {
		return unityFlterCondition;
	}
	public void setUnityFlterCondition(Condition[] unityFlterCondition) {
		this.unityFlterCondition = unityFlterCondition;
	}
}
