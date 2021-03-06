package com.qf.es.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 映射类型
 * <br>
 * File Name: MappingType.java
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
public class MappingType implements Setting {
	
	private String typeName;
	
	private Map<String, MappingField> fieldMap = new HashMap<String, MappingField>();
	
	public MappingType(String typeName) {
		if (StringUtils.isBlank(typeName)) {
			throw new RuntimeException("Mapping constructor parameters must not empty.");
		}
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public boolean addField(MappingField field) {
		if (field == null || StringUtils.isBlank(field.getFieldName())) {
			return false;
		}
		String fieldName = field.getFieldName();
		boolean contains = fieldMap.containsKey(fieldName);
		if (!contains) {
			fieldMap.put(fieldName, field);
		}
		return !contains;
	}
	
	public MappingField getField(String propertyName) {
		return fieldMap.get(propertyName);
	}
	
	public Map<String, Object> buildSetting(Value value) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> properties = new HashMap<String, Object>();
		map.put("properties", properties);
		for (MappingField field : fieldMap.values()) {
			Map<String, Object> fieldSetting = field.buildSetting(value);
			if (fieldSetting != null) {
				if (field.isMeta()) {
					map.put(field.getPropertyName(), fieldSetting);
				}
				else {
					properties.put(field.getPropertyName(), fieldSetting);
				}
			}
		}
		return map;
	}
	
	@Override
	public String getPropertyName() {
		return typeName;
	}

}
