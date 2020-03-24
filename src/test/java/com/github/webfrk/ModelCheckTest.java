/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.webfrk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.github.tools.annotations.api.FieldDescriber;
import com.github.tools.annotations.mysql.JavaBean;
import com.github.tools.utils.ClassUtils;


/**
 * @author wuheng@iscas.ac.cn
 * @since  2020.2.11
 */
public class ModelCheckTest extends AbstractCheckTest  {

	protected final Logger m_logger = Logger.getLogger(ModelCheckTest.class);

	@SuppressWarnings("unchecked")
	@Test
	public void checkModel() throws Exception {
		
		for (String pkg : getModelScanPackages()) {
			
			for (Class<?> clazz : ClassUtils.scan(pkg, JavaBean.class)) {
				
				boolean failure = false;
				for (Field field : clazz.getDeclaredFields()) {
					if (field.getAnnotation(FieldDescriber.class) == null) {
						failure = true;
						violatedNum++;
						break;
					}
					
					boolean missing = true;
					for (Annotation ann : field.getAnnotations()) {
						if(ann.annotationType().getName()
								.contains("com.github.tools.annotations")) {
							missing = false;
							break;
						}
					}
					
					boolean notSupport = false;
					for (Annotation ann : field.getAnnotations()) {
						if(!ann.annotationType().getName().contains("com.github.tools.annotations")
								&& !ann.annotationType().getName().contains("javax.validation.constraints")) {
							notSupport = true;
							break;
						}
					}
					
					
					if (missing || notSupport) {
						failure = true;
						violatedNum++;
					}
				}
				
				String status = failure ? "fail" : "success"; 
				m_logger.info("Check Model " + clazz.getName() + " " + status);
			}
		}
		
		assertEquals(0, violatedNum);
	}
	
}
