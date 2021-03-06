package com.qf.es.model.field;

import com.qf.es.model.MappingParameter;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 文本域
 * <br>
 * File Name: TextField.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2017年12月4日 上午10:22:30 
 * @version: v1.0
 *
 */
public final class TextField extends StringField {
	
	static {
		SUPPORTED_PARAMETER.addAll(StringField.SUPPORTED_PARAMETER);
		
		SUPPORTED_PARAMETER.add(MappingParameter.ANALYZER);
		SUPPORTED_PARAMETER.add(MappingParameter.SEARCH_ANALYZER);
		SUPPORTED_PARAMETER.add(MappingParameter.FIELDDATA);
		SUPPORTED_PARAMETER.add(MappingParameter.FIELDDATA_FREQUENCY_FILTER);
		SUPPORTED_PARAMETER.add(MappingParameter.POSITION_INCREMENT_GAP);
		SUPPORTED_PARAMETER.add(MappingParameter.TERM_VECTOR);
		SUPPORTED_PARAMETER.add(MappingParameter.SIMILARITY);
	}
	
	public TextField(String name) {
		super(name);
	}

	@Override
	public String getPropertyName() {
		return "text";
	}

}
