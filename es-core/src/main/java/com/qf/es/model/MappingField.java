package com.qf.es.model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
public class MappingField implements Setting {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private final Set<MappingParameterValue> parameterSet = new HashSet<MappingParameterValue>();
	
	private final Field field;
	
	public MappingField(Field field) {
		if (field == null) {
			throw new RuntimeException("Field must not empty.");
		}
		this.field = field;
	}
	
	public String getFieldName() {
		return field.getName();
	}
	
	public boolean isMeta() {
		return field instanceof MetaField;
	}
	
	public MappingField addParameter(MappingParameterValue parameter) {
		if (!field.supportParameter(parameter)) {
			log.error("Unsupported mapping parameter {} for field {}", parameter, field.getName());
			throw new RuntimeException("Unsupported mapping parameter");
		}
		else {
			for (MappingParameterValue mpv : parameterSet) {
				if (mpv.getParameterType() == parameter.getParameterType()) {
					log.error("Parameter {} must not be set more than once for field {}", parameter, field.getName());
					throw new RuntimeException("Duplicate parameter setting");
				}
			}
		}
		parameterSet.add(parameter);
		return this;
	}
	
	public FieldValue buildFieldValue(Object value) {
		return new FieldValue(field.getName(), value);
	}
	
	public Map<String, Object> buildSetting(Value value) {
		Map<String, Object> map = field.buildSetting(value);
		for (MappingParameterValue parameter : parameterSet) {
			MappingParameterType type = parameter.getParameterType();
			Map<String, Object> m = type.buildSetting(parameter);
			if (m != null && m.size() > 0) {
				map.putAll(m);
			}
		}
		if (map == null || map.size() == 0) {
			throw new RuntimeException("Field setting can not be empty");
		}
		return map;
	}
	
	@Override
	public String getPropertyName() {
		return field.getName();
	}

}
