package com.qf.es.model.field;

import com.qf.es.model.Field;
import com.qf.es.model.MappingType;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 对象Field
 * <br>
 * File Name: ObjectField.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2018年1月7日 下午3:54:13 
 * @version: v1.0
 *
 */
public final class ObjectField extends Field {

	private MappingType type;

	public ObjectField(String name, MappingType type) {
		super(name);
		if (type == null) {
			throw new RuntimeException("MappingType must not empty.");
		}
		this.type = type;
	}
	
	public MappingType getType() {
		return type;
	}

	@Override
	public String getPropertyName() {
		return getName();
	}

}
