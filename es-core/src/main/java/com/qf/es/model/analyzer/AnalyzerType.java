package com.qf.es.model.analyzer;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 分析器类型枚举
 * <br>
 * File Name: AnalyzerType.java
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
public enum AnalyzerType {
	
	STANDARD("standard"),
	SIMPLE("simple"),
	WHITESPACE("whitespace"),
	STOP("stop"),
	KEYWORD("keyword"),
	PATTERN("pattern"),
	ENGLISH("english"),
	IK_SMART("ik_smart"),
	IK_MAX_WORD("ik_max_word"),
	FINGERPRINT("fingerprint");
	
	private String code;
	
	private AnalyzerType(String code) {
		this.code = code;
	}
	
	public String code() {
		return code;
	}

}
