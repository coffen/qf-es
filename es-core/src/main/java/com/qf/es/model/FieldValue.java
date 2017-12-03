package com.qf.es.model;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 索引域值
 * <br>
 * File Name: FieldValue.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2017-12-01
 * @version: v1.0
 *
 */
public class FieldValue {
	
	private String name;
	private Object value;
	
	public FieldValue(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}

}
