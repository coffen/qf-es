package com.qf.es.model.field;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: Short域
 * <br>
 * File Name: ShortField.java
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
public final class ShortField extends NumbericField {
	
	static {
		SUPPORTED_PARAMETER.addAll(NumbericField.SUPPORTED_PARAMETER);
	}
	
	public ShortField(String name) {
		super(name);
	}
	
	@Override
	public String getPropertyName() {
		return "short";
	}

}
