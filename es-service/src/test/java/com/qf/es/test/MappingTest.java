package com.qf.es.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsRequestBuilder;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequestBuilder;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.qf.es.model.MappingField;
import com.qf.es.model.MappingParameter;
import com.qf.es.model.field.TextField;

public class MappingTest extends BaseUnit {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TransportClient transportClient;
	
	@Test
	public void testPutMapping() throws IOException, InterruptedException, ExecutionException {
		IndicesAdminClient client = transportClient.admin().indices();		
		PutMappingRequestBuilder putBuilder = client.preparePutMapping("test");
		
		MappingField<TextField> mf = new MappingField<TextField>("testField", new TextField());
		mf	.addParameter(MappingParameter.STORE.TRUE)
 		 	.addParameter(MappingParameter.ANALYZER.IK_SMART)
 		 	.addParameter(MappingParameter.INDEX.TRUE)
 		 	.addParameter(MappingParameter.BOOST.value(2.0f));
		
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> properties = new HashMap<>();
		properties.put(mf.getPropertyName(), mf.buildJsonContext());
		map.put("properties", properties);
		
		putBuilder.setType("testType").setSource(map);
		ActionFuture<PutMappingResponse> putFuture = putBuilder.execute();
		
		PutMappingResponse putResponse = putFuture.get();
		log.error("Response: {}", putResponse.isAcknowledged());
	}
	
	@Test
	public void testGetMapping() throws IOException, InterruptedException, ExecutionException {
		IndicesAdminClient client = transportClient.admin().indices();		
		GetMappingsRequestBuilder getBuilder = client.prepareGetMappings("test");		
		ActionFuture<GetMappingsResponse> getFuture = getBuilder.execute();
		GetMappingsResponse getResponse = getFuture.get();
		ImmutableOpenMap<String, MappingMetaData> map = getResponse.getMappings().get("test");
		Iterator<String> it = map.keysIt();
		while (it.hasNext()) {
			MappingMetaData data = map.get(it.next());			
			Map<String, Object> source = data.getSourceAsMap();
			log.error("Response: {}", JSON.toJSONString(source));
		}
	}
	
}
