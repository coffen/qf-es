package com.qf.es.model;

import java.io.Serializable;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 索引值
 * <br>
 * File Name: FieldValue.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2017年12月4日 下午5:17:31 
 * @version: v1.0
 *
 */
public class FieldValue implements Serializable {

	private static final long serialVersionUID = -7423025529564490758L;
	
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
