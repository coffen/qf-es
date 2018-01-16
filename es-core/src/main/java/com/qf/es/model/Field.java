package com.qf.es.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.qf.es.model.MappingParameter.MappingParameterType;
import com.qf.es.model.MappingParameter.MappingParameterValue;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 域设置
 * <br>
 * File Name: Field.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2017年12月4日 上午10:41:29 
 * @version: v1.0
 *
 */
public abstract class Field implements Setting {
	
	protected final static Set<MappingParameterType> SUPPORTED_PARAMETER = new HashSet<MappingParameterType>();
	
	private String fieldName;
	
	public Field(String name) {
		if (StringUtils.isBlank(name)) {
			throw new RuntimeException("Field name must not empty.");
		}
		this.fieldName = name;
	}
	
	public String getName() {
		return fieldName;
	}
	
	/**
	 * 是否支持指定的映射参数
	 * 
	 * @param parameterValue
	 * @return
	 */
	public final boolean supportParameter(MappingParameterValue parameterValue) {
		if (parameterValue == null) {
			return false;
		}
		return SUPPORTED_PARAMETER.contains(parameterValue.getParameterType());
	}
	
	@Override
	public Map<String, Object> buildSetting(Value value) {
		if (StringUtils.isBlank(getPropertyName())) {
			throw new RuntimeException("Field property name must not empty.");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", getPropertyName());
		return map;
	}

}
