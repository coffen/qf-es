package com.qf.es.model.field;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: Float字段
 * <br>
 * File Name: FloatField.java
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
public final class FloatField extends NumbericField {
	
	public FloatField(String name) {
		super(name);
	}

	@Override
	public String getPropertyName() {
		return "float";
	}

}
