package com.qf.es.test;

import java.io.Serializable;
import java.util.List;

public class MType3 implements Serializable {
	
	private static final long serialVersionUID = 1303054608929076833L;
	
	private String birthday;
	private String officeId;
	private String name;
	private short weight;
	
	private MType1 version;
	
	private List<MType4> list;
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getOfficeId() {
		return officeId;
	}
	
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public short getWeight() {
		return weight;
	}
	
	public void setWeight(short weight) {
		this.weight = weight;
	}
	
	public MType1 getVersion() {
		return version;
	}
	
	public void setVersion(MType1 version) {
		this.version = version;
	}
	
	public List<MType4> getList() {
		return list;
	}
	
	public void setList(List<MType4> list) {
		this.list = list;
	}
	
}
