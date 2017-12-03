package com.qf.es.model.exception;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 索引字段映射异常
 * <br>
 * File Name: FieldMappingException.java
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
public class FieldMappingException extends Exception {

	private static final long serialVersionUID = 2067413765724947698L;
	
	private String fieldName;
	private String errorMsg;
	
	public FieldMappingException(String fieldName, String errorMsg) {
		this.fieldName = fieldName;
		this.errorMsg = errorMsg;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

}
