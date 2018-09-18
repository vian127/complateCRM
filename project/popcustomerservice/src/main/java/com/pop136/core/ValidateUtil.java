package com.pop136.core;

import org.hibernate.validator.HibernateValidator;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ValidateUtil {

	private static final Validator VALIDATOR = Validation.byProvider(
			HibernateValidator.class ).configure().buildValidatorFactory().getValidator();
	
	public static <T> BindingResult validate(T obj , Class<?> ... groups ){
		if( obj == null ) return null ;
		groups = groups == null || 
				groups.length == 0 ? new Class<?>[]{ Default.class } : groups ;
				
		Set<ConstraintViolation<T>> violations = VALIDATOR.validate( obj , groups ) ;
		if( violations == null || violations.isEmpty() ){
			return null ;
		}
		BindException bindExp = new BindException( obj , null  ) ;
		for( ConstraintViolation<T> violation : violations ){
			FieldError fieldError = new FieldError( obj.getClass().getName() ,
					violation.getPropertyPath().toString() , violation.getMessage() ) ;
			bindExp.addError( fieldError );
		}
		return bindExp ;
	}
	
	public static <T> Map<Integer , BindingResult> validate(List<T> objs , Class<?> ... groups ){
		if( objs == null || objs.isEmpty() ) return null ;
		Map< Integer , BindingResult> bindResults = new HashMap<Integer , BindingResult>() ;
		int index = 0;
		for( T obj : objs ){
			BindingResult bindResult = null ;
			if( ( bindResult = validate( obj , groups ) ) != null ){
				bindResults.put( index++ , bindResult ) ;
			}
		}
		return bindResults.isEmpty() ? null : bindResults ;
	}

}
