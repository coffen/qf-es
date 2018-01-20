package com.qf.es.test;

import java.io.Serializable;

public class MType4 implements Serializable {

	private static final long serialVersionUID = 2781628778952149715L;
	
	private String parentNo;
	private int count;
	
	public String getParentNo() {
		return parentNo;
	}
	
	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

}
