package com.qf.es.model.field;

import com.qf.es.model.FieldType;
import com.qf.es.model.MappingParameter;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 二进制域
 * <br>
 * File Name: BinaryField.java
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
public final class BinaryField extends FieldType {
	
	static {
		SUPPORTED_PARAMETER.add(MappingParameter.STORE);
	}

	@Override
	public String getPropertyName() {
		return "binary";
	}
	
	

}
