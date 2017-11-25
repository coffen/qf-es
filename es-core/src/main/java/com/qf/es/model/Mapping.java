package com.qf.es.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 索引类型映射表
 * <br>
 * File Name: Mapping.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2017-11-25
 * @version: v1.0
 *
 */
public class Mapping {
	
	private String indexType;
	private Map<String, Field> fieldMap = new HashMap<String, Field>();
	
	public String getIndexType() {
		return indexType;
	}
	
	public void setIndexType(String indexType) {
		this.indexType = indexType;
	}
	
	public boolean addField(Field field) {
		if (field == null || StringUtils.isBlank(field.getName())) {
			return false;
		}
		fieldMap.put(field.getName(), field);
		return true;
	}
	
	public Field getField(String field) {
		return fieldMap.get(field);
	}

}
