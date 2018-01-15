package com.qf.es.model.field.meta;

import com.qf.es.model.MappingType;
import com.qf.es.model.MetaField;

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

}
