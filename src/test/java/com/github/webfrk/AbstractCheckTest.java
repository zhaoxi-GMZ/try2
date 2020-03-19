/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.webfrk;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wuheng@iscas.ac.cn
 * @since  2020.2.11
 */
public abstract class AbstractCheckTest  {

	protected int violatedNum;
	
	public static String[] getComponentScanPackages() {
		try {
			return ApplicationServer.class.getAnnotation(ComponentScan.class).basePackages();
		} catch (Exception ex) {
			return null;
		}
	}
	
	public static String[] getMapperScanPackages() {
		try {
			return ApplicationServer.class.getAnnotation(MapperScan.class).basePackages();
		} catch (Exception ex) {
			return new String[] {};
		}
	}
	
	public static String[] getModelScanPackages() {
		try {
			List<String> pkgs = new ArrayList<String>();
			for (String value: ApplicationServer.class
					.getAnnotation(MapperScan.class).basePackages()) {
				int idx = value.lastIndexOf(".");
				pkgs.add(value.substring(0, idx) + ".models");
			}
			return pkgs.toArray(new String[] {});
		} catch (Exception ex) {
			return new String[] {};
		}
	}
	
}
