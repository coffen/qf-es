package com.qf.es.model.field;

import com.qf.es.model.Field;
import com.qf.es.model.MappingParameter;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 数字型域
 * <br>
 * File Name: NumbericField.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2017年12月4日 下午8:54:59 
 * @version: v1.0
 *
 */
public abstract class NumbericField extends Field {
	
	static {
		SUPPORTED_PARAMETER.add(MappingParameter.STORE);
		SUPPORTED_PARAMETER.add(MappingParameter.INDEX);
		SUPPORTED_PARAMETER.add(MappingParameter.BOOST);
		SUPPORTED_PARAMETER.add(MappingParameter.COERCE);
		SUPPORTED_PARAMETER.add(MappingParameter.DOC_VALUES);
		SUPPORTED_PARAMETER.add(MappingParameter.IGNORE_MALFORMED);
		SUPPORTED_PARAMETER.add(MappingParameter.INCLUDE_IN_ALL);
		SUPPORTED_PARAMETER.add(MappingParameter.NULL_VALUE);
	}
	
	public NumbericField(String name) {
		super(name);
	}
	
}
