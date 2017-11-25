package com.qf.es.model.field;

import java.util.List;

import com.qf.es.model.Field;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 数组字段
 * <br>
 * File Name: Field.java
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
public class ArrayField<T extends Field> extends Field {
	
	private List<T> value;
	
	public List<T> getValue() {
		return value;
	}
	
	public void setValue(List<T> value) {
		this.value = value;
	}

}
