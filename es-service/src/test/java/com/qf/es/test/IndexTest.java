package com.qf.es.test;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.joda.time.DateTime;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * <p>
 * Project Name: C2C商城
 * <br>
 * Description: 索引测试
 * <br>
 * File Name: IndexTest.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2017年11月21日 上午9:55:27 
 * @version: v1.0
 *
 */
public class IndexTest extends BaseUnit {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TransportClient transportClient;
	
	@Test
	public void indexDataByMapping() {
		MType1 mType1 = new MType1();
		mType1.setVersion("0.0.1");
		mType1.setPubDate(new DateTime().toDate());
		
		IndexRequestBuilder builder = transportClient.prepareIndex("test", "mType2", "1");
		MType2 mcyt = new MType2();
		mcyt.setDomain("mcyt");
		JSONObject obj21 = (JSONObject)JSON.toJSON(mcyt);
		builder.setSource(obj21);
		IndexResponse response21 = builder.execute().actionGet();
		log.error(JSON.toJSONString(response21.getResult()));
		
		builder = transportClient.prepareIndex("test", "mType2", "2");
		MType2 mdscj = new MType2();
		mdscj.setDomain("mdscj");
		JSONObject obj22 = (JSONObject)JSON.toJSON(mdscj);
		builder.setSource(obj22);
		IndexResponse response22 = builder.execute().actionGet();
		log.error(JSON.toJSONString(response22.getResult()));
		
		MType3 mType3 = new MType3();
		mType3.setName("测试");
		mType3.setOfficeId("11");
		mType3.setWeight((short)168);
		mType3.setBirthday("1979-05-24 12:00:00");
		
		mType3.setVersion(mType1);
		
		List<MType4> list = new ArrayList<MType4>(); 
		MType4 t41 = new MType4();
		t41.setParentNo("sdfsdfs");
		t41.setCount(1);
		list.add(t41);
		MType4 t42 = new MType4();
		t42.setParentNo("dsgdsf");
		t42.setCount(3);
		list.add(t42);
		mType3.setList(list);
		
		JSONObject obj3 = (JSONObject)JSON.toJSON(mType3);
		builder = transportClient.prepareIndex("test", "mType3", "1");
		builder.setSource(obj3);
		builder.setParent("1");
		IndexResponse response3 = builder.execute().actionGet();
		log.error(JSON.toJSONString(response3.getResult()));
		
		MType5 mType5 = new MType5();
		mType5.setOfficeId("222");
		
		JSONObject obj5 = (JSONObject)JSON.toJSON(mType5);
		builder = transportClient.prepareIndex("test", "mType5", "1");
		builder.setSource(obj5);
		IndexResponse response5 = builder.execute().actionGet();
		log.error(JSON.toJSONString(response5.getResult()));		
	}

}
