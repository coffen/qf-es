package com.qf.es.model.field.meta;

import com.qf.es.model.MappingParameter;
import com.qf.es.model.MetaField;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: Source Field
 * <br>
 * File Name: SourceField.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2018年1月15日 上午11:44:30 
 * @version: v1.0
 *
 */
public class SourceField extends MetaField {
	
	static {
		SUPPORTED_PARAMETER.add(MappingParameter.ENABLED);
	}

	@Override
	public String getPropertyName() {
		return "_source";
	}

}
