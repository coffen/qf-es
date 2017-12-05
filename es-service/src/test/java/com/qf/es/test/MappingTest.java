package com.qf.es.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequestBuilder;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.qf.es.model.MappingField;
import com.qf.es.model.MappingParameter;
import com.qf.es.model.field.TextField;

public class MappingTest extends BaseUnit {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TransportClient transportClient;
	
	@Test
	public void testMapping() throws IOException, InterruptedException, ExecutionException {
		IndicesAdminClient client = transportClient.admin().indices();		
		PutMappingRequestBuilder builder = client.preparePutMapping("test");
		
		MappingField<TextField> mf = new MappingField<TextField>("testField", new TextField());
		mf	.addParameter(MappingParameter.STORE.TRUE)
 		 	.addParameter(MappingParameter.ANALYZER.IK_SMART)
 		 	.addParameter(MappingParameter.INDEX.TRUE)
 		 	.addParameter(MappingParameter.BOOST.value(2.0f));
		
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> properties = new HashMap<>();
		properties.put(mf.getPropertyName(), mf.buildJsonContext());
		map.put("properties", properties);
		
		builder.setType("testType").setSource(map);
		ActionFuture<PutMappingResponse> future = builder.execute();
		
		PutMappingResponse response = future.get();
		log.error("Response: {}", response.isAcknowledged());
	}
	
}
