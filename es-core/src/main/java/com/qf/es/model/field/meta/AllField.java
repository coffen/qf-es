package com.qf.es.model.field.meta;

import com.qf.es.model.MappingParameter;
import com.qf.es.model.MetaField;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: Field组装
 * <br>
 * File Name: AllField.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2018年1月15日 上午11:27:08 
 * @version: v1.0
 *
 */
public final class AllField extends MetaField {
	
	static {
		SUPPORTED_PARAMETER.add(MappingParameter.ENABLED);
		SUPPORTED_PARAMETER.add(MappingParameter.STORE);
		SUPPORTED_PARAMETER.add(MappingParameter.TERM_VECTOR);
		SUPPORTED_PARAMETER.add(MappingParameter.INDEX_OPTIONS);
	}

	@Override
	public String getPropertyName() {
		return "_all";
	}

}
