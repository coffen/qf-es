package com.qf.es.model.field;

import java.util.Set;

import com.google.common.collect.Sets;
import com.qf.es.model.FieldValue;
import com.qf.es.model.MappingField;
import com.qf.es.model.MappingParameter;
import com.qf.es.model.MappingParameter.MappingParameterType;
import com.qf.es.model.MappingParameter.MappingParameterValue;
import com.qf.es.model.exception.FieldMappingException;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: Long域
 * <br>
 * File Name: LongField.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2017-11-25
 * @version: v1.0
 *
 */
public class LongField extends MappingField {
	
	private final static Set<MappingParameterType> SUPPORTED_PARAMETER = Sets.newHashSet(MappingParameter.STORE, MappingParameter.INDEX, MappingParameter.BOOST);
	private final static Set<Class<?>> SUPPORTED_TYPE = Sets.newHashSet(Long.class);
	
	public LongField(String name) {
		super(name);
	}
	
	public FieldValue buildValue(Object obj) throws FieldMappingException {
		if (obj instanceof Long) {
			return new FieldValue(fieldName, obj);		
		}
		else {
			throw new FieldMappingException(fieldName, "Unsupported value type!");
		}
	}

	public boolean supportType(Class<?> clazz) {
		return SUPPORTED_TYPE.contains(clazz);
	}

	public boolean supportParameter(MappingParameterValue parameterType) {
		if (parameterType == null) {
			return false;
		}
		return SUPPORTED_PARAMETER.contains(parameterType.getParameterType());
	}
	
	public String getFieldType() {
		return "long";
	}

}
