package com.qf.es.model.field;

import com.qf.es.model.Field;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: byte型字段
 * <br>
 * File Name: ByteField.java
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
public class ByteField extends Field {
	
	private Byte value;
	
	public Byte getValue() {
		return value;
	}
	
	public void setValue(Byte value) {
		this.value = value;
	}

}
