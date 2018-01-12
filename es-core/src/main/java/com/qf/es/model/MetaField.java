package com.qf.es.model;

import java.util.HashSet;
import java.util.Set;

import com.qf.es.model.MappingParameter.MappingParameterType;
import com.qf.es.model.MappingParameter.MappingParameterValue;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 元属性
 * <br>
 * File Name: MetaField.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2018年1月12日 下午5:05:47 
 * @version: v1.0
 *
 */
public abstract class MetaField implements Setting {
	
	protected final static Set<MappingParameterType> SUPPORTED_PARAMETER = new HashSet<MappingParameterType>();
	
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

}
