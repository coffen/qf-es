package com.qf.es.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 映射
 * <br>
 * File Name: Mapping.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2017年12月5日 下午5:55:55 
 * @version: v1.0
 *
 */
public class Mapping {
	
	private String typeName;
	private Map<String, MappingField> fieldMap = new HashMap<String, MappingField>();
	
	public Mapping(String typeName) {
		if (StringUtils.isBlank(typeName)) {
			throw new RuntimeException("Mapping constructor parameters must not empty.");
		}
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public boolean addField(MappingField field) {
		if (field == null || StringUtils.isBlank(field.getPropertyName())) {
			return false;
		}
		String propertyName = field.getPropertyName();
		boolean contains = fieldMap.containsKey(propertyName);
		if (!contains) {
			fieldMap.put(propertyName, field);
		}
		return !contains;
	}
	
	public MappingField getField(String propertyName) {
		return fieldMap.get(propertyName);
	}

}
