package com.qf.es.test;

import java.io.IOException;
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
import com.qf.es.model.MappingType;
import com.qf.es.model.field.DateField;
import com.qf.es.model.field.ShortField;
import com.qf.es.model.field.TextField;

public class MappingTest extends BaseUnit {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TransportClient transportClient;
	
	@Test
	public void testPutMapping() throws IOException, InterruptedException, ExecutionException {
		IndicesAdminClient client = transportClient.admin().indices();		
		PutMappingRequestBuilder putBuilder = client.preparePutMapping("test");
		
		MappingType testType = new MappingType("testType");
		
		MappingField mf1 = new MappingField(new TextField("name"));
		mf1	.addParameter(MappingParameter.STORE.TRUE)
 		 	.addParameter(MappingParameter.ANALYZER.ENGLISH)
 		 	.addParameter(MappingParameter.INDEX.TRUE)
 		 	.addParameter(MappingParameter.BOOST.value(2.0f));
		testType.addField(mf1);
		
		MappingField mf2 = new MappingField(new DateField("birthday"));
		mf2	.addParameter(MappingParameter.STORE.TRUE)
 		 	.addParameter(MappingParameter.INDEX.TRUE)
 		 	.addParameter(MappingParameter.FORMAT.value("yyyy-MM-dd HH:mm:ss"));
		testType.addField(mf2);
		
		MappingField mf3 = new MappingField(new ShortField("weight"));
		mf3	.addParameter(MappingParameter.STORE.TRUE)
 		 	.addParameter(MappingParameter.INDEX.TRUE);
		testType.addField(mf3);
		
		putBuilder.setType("testType11").setSource(testType.buildSetting());
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
