package com.qf.es.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qf.es.model.MappingParameter.MappingParameterType;
import com.qf.es.model.MappingParameter.MappingParameterValue;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 索引域映射
 * <br>
 * File Name: MappingField.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2017-11-30
 * @version: v1.0
 *
 */
public class MappingField<T extends FieldType> implements Setting {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private final Set<MappingParameterValue> parameterSet = new HashSet<MappingParameterValue>();
	
	private String fieldName;
	private T fieldType;
	
	public MappingField(String name, T type) {
		if (StringUtils.isBlank(name) || type == null) {
			throw new RuntimeException("MappingField constructor parameters must not empty.");
		}
		this.fieldName = name;
		this.fieldType = type;
	}
	
	public String getPropertyName() {
		return this.fieldName;
	}
	
	public MappingField<?> addParameter(MappingParameterValue parameter) {
		boolean enable = true;
		if (!fieldType.supportParameter(parameter)) {
			log.error("Unsupported mapping parameter {} for field {}", parameter, fieldName);
			enable = false;
		}
		else {
			for (MappingParameterValue mpv : parameterSet) {
				if (mpv.getParameterType() == parameter.getParameterType()) {
					log.error("Parameter {} must not be set more than once for field {}", parameter, fieldName);
					enable = false;
				}
			}
		}
		if (enable) {
			parameterSet.add(parameter);
		}
		return this;
	}
	
	public FieldValue buildFieldValue(Object value) {
		return new FieldValue(fieldName, value);
	}
	
	public Map<String, Object> buildJsonContext() {
		return parseMappingField(this);
	}
	
	private Map<String, Object> parseMappingField(MappingField<?> mappingField) {
		if (mappingField == null || mappingField.fieldType == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("type", mappingField.fieldType.getPropertyName());
		for (MappingParameterValue parameter : mappingField.parameterSet) {
			MappingParameterType type = parameter.getParameterType();
			Object obj = parameter.value();
			if (obj != null) {
				if (obj instanceof MappingField) {
					Map<String, Object> innerMap = parseMappingField((MappingField<?>)obj);
					if (innerMap != null) {
						map.put(type.getPropertyName(), innerMap);
					}
				}
				else {
					map.put(type.getPropertyName(), obj);
				}
			}
		}
		return map;
	}

}
