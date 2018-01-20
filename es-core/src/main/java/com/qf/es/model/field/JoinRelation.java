package com.qf.es.model.field;

import java.util.List;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 连接关系
 * <br>
 * File Name: JoinRelation.java
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
public class JoinRelation {
	
	private String parent;
	private List<String> children;
	
	public JoinRelation(String parent, List<String> child) {
		this.parent = parent;
		this.children = child;
	}
	
	public String getParent() {
		return parent;
	}
	
	public List<String> getChildren() {
		return children;
	}

}
