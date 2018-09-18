package com.pop136.customerservice.utils;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.StringMemberValue;

import java.lang.reflect.Field;

import java.util.Arrays;

public class ClassUtil {

	public static Class<?> newClass(String className) {
		try {
			ClassPool classPool = ClassPool.getDefault();
			CtClass ctClass = classPool.makeClass(className);
			return ctClass.toClass();
		} catch (Exception e) {
		}
		return null;
	}

	public static Class<?> annotate(String className, Class<?> annotation , String property ) {
		ClassPool pool = ClassPool.getDefault();
		Class<?> clazz = null;
		try {
			CtClass cc = pool.makeClass(className);
			ClassFile ccFile = cc.getClassFile();
			ConstPool constPool = ccFile.getConstPool();
			AnnotationsAttribute annoAttr = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
			Annotation annoBody = new Annotation(annotation.getName(), constPool) ;
			annoBody.addMemberValue("value", new StringMemberValue( property , constPool ) );
			annoAttr.addAnnotation( annoBody );
			ccFile.addAttribute(annoAttr);
			clazz = cc.toClass();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clazz ;
	}

	public static String compareObject(Class<?> oldInstance, Class<?> newInstance)
	{
		Field[] oldFields = oldInstance.getDeclaredFields();
		Field[] newFields = newInstance.getDeclaredFields();
		StringBuilder changes = new StringBuilder();

/*		Arrays.sort(oldFields);
		Arrays.sort(newFields);*/

		int i = 0;
		for(Field f : oldFields)
		{
			if(!f.equals(newFields[i]))
			{
				changes.append(f.getName()).append(" has changed.\n");
			}
			i++;
		}
		return changes.toString();
	}


}
