package com.qf.es.model.field;

import java.util.Date;

import com.qf.es.model.Field;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 日期字段
 * <br>
 * File Name: DateField.java
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
public class DateField extends Field {
	
	private Date value;
	private String format;
	
	public Date getValue() {
		return value;
	}
	
	public void setValue(Date value) {
		this.value = value;
	}
	
	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}

}
