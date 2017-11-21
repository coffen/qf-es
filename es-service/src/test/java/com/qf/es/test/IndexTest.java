package com.qf.es.test;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

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
	public void buildIndex() {
		IndicesAdminClient client = transportClient.admin().indices();
		CreateIndexResponse response = client.prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 2)).get();
		log.error(JSON.toJSONString(response));
	}

}
