package com.qf.es.model;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 索引映射字段
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
public class Field {
	
	private String name;
	private boolean index;
	private boolean boost;
	private boolean stored;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isIndex() {
		return index;
	}
	
	public void setIndex(boolean index) {
		this.index = index;
	}
	
	public boolean isBoost() {
		return boost;
	}
	
	public void setBoost(boolean boost) {
		this.boost = boost;
	}
	
	public boolean isStored() {
		return stored;
	}
	
	public void setStored(boolean stored) {
		this.stored = stored;
	}

}
