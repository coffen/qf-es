package com.qf.es.test;

import java.io.Serializable;
import java.util.Date;

public class MType1 implements Serializable {

	private static final long serialVersionUID = 1693086278410873686L;
	
	private String version;
	private Date pubDate;
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public Date getPubDate() {
		return pubDate;
	}
	
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

}
