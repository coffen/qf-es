package com.qf.es.model.field.meta;

import com.qf.es.model.MappingParameter;
import com.qf.es.model.MetaField;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 路由Field
 * <br>
 * File Name: RoutingField.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2018-01-16
 * @version: v1.0
 *
 */
public class RoutingField extends MetaField {
	
	static {
		SUPPORTED_PARAMETER.add(MappingParameter.REQUIRED);
	}

	@Override
	public String getPropertyName() {
		return "_routing";
	}

}
