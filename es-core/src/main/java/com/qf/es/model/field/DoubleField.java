package com.qf.es.model.field;

import com.qf.es.model.Field;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 浮点数字段
 * <br>
 * File Name: DoubleField.java
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
public class DoubleField extends Field {
	
	private Double value;
	
	public Double getValue() {
		return value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}

}
