/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.webfrk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.apache.ibatis.annotations.Mapper;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.tools.annotations.api.FunctionDescriber;
import com.github.tools.utils.ClassUtils;


/**
 * @author wuheng@iscas.ac.cn
 * @since  2020.2.11
 */
public class MapperCheckTest extends AbstractCheckTest  {

	protected final Logger m_logger = Logger.getLogger(MapperCheckTest.class);

	@SuppressWarnings("unchecked")
	@Test
	public void checkMapper() throws Exception {
		for (String pkg : getMapperScanPackages()) {
			for (Class<?> clazz : ClassUtils.scan(pkg, Mapper.class)) {
				
				boolean failure = false;
				for (Method method : clazz.getDeclaredMethods()) {
					if (method.getAnnotation(FunctionDescriber.class) == null) {
						failure = true;
						violatedNum++;
						break;
					}
					
					boolean missing = true;
					for (Annotation ann : method.getAnnotations()) {
						if(ann.annotationType().getName()
								.contains("org.apache.ibatis.annotations")) {
							missing = false;
							break;
						}
					}
					
					if (missing) {
						failure = true;
						violatedNum++;
					}
				}
				
				String status = failure ? "fail" : "success"; 
				m_logger.info("Check Mapper " + clazz.getName() + " " + status);
			}
		}
		
		assertEquals(0, violatedNum);
	}
	
}
