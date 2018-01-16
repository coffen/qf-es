package com.qf.es.model.field.meta;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.qf.es.model.MappingType;
import com.qf.es.model.MetaField;
import com.qf.es.model.Value;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 父Field
 * <br>
 * File Name: ParentField.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2018年1月15日 上午11:29:59 
 * @version: v1.0
 *
 */
public class ParentField extends MetaField {
	
	private MappingType type;

	public ParentField(MappingType type) {
		if (type == null) {
			throw new RuntimeException("Parent type must not empty.");
		}
		this.type = type;
	}
	
	public MappingType getType() {
		return type;
	}

	@Override
	public String getPropertyName() {
		return "_parent";
	}
	
	@Override
	public Map<String, Object> buildSetting(Value value) {
		if (StringUtils.isBlank(getPropertyName())) {
			throw new RuntimeException("Parent field property name must not empty.");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type.getTypeName());
		return map;
	}

}
