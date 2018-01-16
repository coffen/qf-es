package com.qf.es.model.field;

import java.util.Map;

import com.qf.es.model.Field;
import com.qf.es.model.MappingParameter;
import com.qf.es.model.MappingType;
import com.qf.es.model.Value;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: Object数组Field
 * <br>
 * File Name: NestedField.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2018年1月7日 下午3:55:55 
 * @version: v1.0
 *
 */
public final class NestedField extends Field {
	
	static {
		SUPPORTED_PARAMETER.add(MappingParameter.DYNAMIC);
		SUPPORTED_PARAMETER.add(MappingParameter.INCLUDE_IN_ALL);
	}
	
	private MappingType type;

	public NestedField(String name, MappingType type) {
		super(name);
		if (type == null) {
			throw new RuntimeException("MappingType must not empty.");
		}
		this.type = type;
	}
	
	public MappingType getType() {
		return type;
	}

	@Override
	public String getPropertyName() {
		return "nested";
	}
	
	@Override
	public Map<String, Object> buildSetting(Value value) {
		Map<String, Object> map = type.buildSetting(value);
		map.put("type", getPropertyName());
		return map;
	}

}
