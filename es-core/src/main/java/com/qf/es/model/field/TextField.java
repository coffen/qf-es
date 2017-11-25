package com.qf.es.model.field;

import com.qf.es.model.Field;
import com.qf.es.model.analyzer.AnalyzerType;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 文本型字段
 * <br>
 * File Name: TextField.java
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
public class TextField extends Field {
	
	private String value;
	private AnalyzerType analyzer;
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public AnalyzerType getAnalyzer() {
		return analyzer;
	}
	
	public void setAnalyzer(AnalyzerType analyzer) {
		this.analyzer = analyzer;
	}

}
