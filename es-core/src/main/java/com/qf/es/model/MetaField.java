package com.qf.es.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

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
public abstract class MetaField extends Field {
	
	public MetaField() {
		this("META");
	}

	private MetaField(String name) {
		super(name);
	}
	
	@Override
	public Map<String, Object> buildSetting(Value value) {
		if (StringUtils.isBlank(getPropertyName())) {
			throw new RuntimeException("Meta field property name must not empty.");
		}
		return new HashMap<String, Object>();
	}
	
	@Override
	public String getName() {
		return getPropertyName();
	}

}
