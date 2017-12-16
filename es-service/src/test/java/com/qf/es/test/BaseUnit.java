package com.qf.es.test;

import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.alibaba.fastjson.JSON;
import com.qf.es.config.ESConfig;

@ContextConfiguration(classes = { ESConfig.class })
public class BaseUnit extends AbstractJUnit4SpringContextTests {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TransportClient transportClient;
	
    @Test
	public void buildIndex() throws InterruptedException, ExecutionException { 	
    	String indexName = "test";
    	
		IndicesAdminClient client = transportClient.admin().indices();
		
		IndicesExistsRequest existsRequest = new IndicesExistsRequest();
		existsRequest.indices(indexName);
		ActionFuture<IndicesExistsResponse> future = client.exists(existsRequest);
		IndicesExistsResponse res = future.get();
		if (!(res != null && res.isExists())) {
			Settings settings = Settings.builder()
					.put("index.number_of_shards", 3)
					.put("index.number_of_replicas", 2)
					.put("index.analysis.analyzer.ik.type", "ik_smart")
					.build();
			CreateIndexResponse response = client.prepareCreate(indexName).setSettings(settings).get();
			log.error(JSON.toJSONString(response));
		}
	}

}
