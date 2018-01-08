package com.qf.es.model.field;

import com.qf.es.model.Field;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 过滤器Field
 * <br>
 * File Name: PercolatorField.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2018-01-08
 * @version: v1.0
 *
 */
public final class PercolatorField extends Field {

	public PercolatorField(String name) {
		super(name);
	}

	@Override
	public String getPropertyName() {
		return "percolator";
	}

}
