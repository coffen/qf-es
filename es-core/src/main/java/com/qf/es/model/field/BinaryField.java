package com.qf.es.model.field;

import java.io.UnsupportedEncodingException;
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
 * Description: 二进制域
 * <br>
 * File Name: BinaryField.java
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
public class BinaryField extends MappingField {
	
	private final static Set<MappingParameterType> SUPPORTED_PARAMETER = Sets.newHashSet(MappingParameter.STORE);
	private final static Set<Class<?>> SUPPORTED_TYPE = Sets.newHashSet(String.class, byte[].class);
	
	public BinaryField(String name) {
		super(name);
	}
	
	public FieldValue buildValue(Object obj) throws FieldMappingException {
		String binary = null;
		if (obj instanceof byte[]) {
			byte[] byteArr = (byte[])obj;
			try {
				binary = new String(byteArr, "UTF-8");
			}
			catch (UnsupportedEncodingException e) {
				throw new FieldMappingException(fieldName, "Transfer byte[] 2 String error!");
			}			
		}
		else if (obj instanceof String) {
			binary = (String)obj;
		}
		else {
			throw new FieldMappingException(fieldName, "Unsupported value type!");
		}
		if (binary.indexOf('\n') >= 0) {
			throw new FieldMappingException(fieldName, "String value must not have embedded newlines!");
		}
		return new FieldValue(fieldName, binary);
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
		return "binary";
	}

}
