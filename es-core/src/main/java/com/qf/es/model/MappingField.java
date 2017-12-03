package com.qf.es.model;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.qf.es.model.MappingParameter.MappingParameterValue;
import com.qf.es.model.exception.FieldMappingException;

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
public abstract class MappingField implements Field {
	
	private final Set<MappingParameterValue> parameterSet = new HashSet<MappingParameterValue>();
	
	protected String fieldName;
	
	public MappingField(String name) {
		if (StringUtils.isBlank(name)) {
			throw new RuntimeException("Field name must not empty.");
		}
		this.fieldName = name;
	}
		
	/**
	 * 添加映射参数
	 * 
	 * @param parameter
	 * @return
	 * @throws FieldMappingException
	 */
	public final MappingField addMappingParameter(MappingParameterValue parameter) throws FieldMappingException {
		if (!supportParameter(parameter)) {
			throw new FieldMappingException(getName(), "Unsupported mapping parameter!");
		}
		for (MappingParameterValue mpv : parameterSet) {
			if (mpv.getParameterType() == parameter.getParameterType()) {
				throw new FieldMappingException(fieldName, "Each parameter type must not be set more than once!");
			}
		}		
		parameterSet.add(parameter);
		return this;
	}
	
	public String getName() {
		return this.fieldName;
	}
	
	/**
	 * 创建域值
	 * 
	 * @param obj
	 * @return
	 */
	public abstract FieldValue buildValue(Object obj) throws FieldMappingException;
	
	/**
	 * 是否支持指定的域值类型
	 * 
	 * @param clazz
	 * @return
	 */
	public abstract boolean supportType(Class<?> clazz);
	
	/**
	 * 是否支持指定的映射参数
	 * 
	 * @param parameterValue
	 * @return
	 */
	public abstract boolean supportParameter(MappingParameterValue parameterValue);

	/**
	 * 返回域类型名称
	 * 
	 * @return
	 */
	public abstract String getFieldType();

}
