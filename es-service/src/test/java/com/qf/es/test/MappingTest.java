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
import com.qf.es.model.field.KeywordField;
import com.qf.es.model.field.NestedField;
import com.qf.es.model.field.ShortField;
import com.qf.es.model.field.TextField;
import com.qf.es.model.field.meta.AllField;
import com.qf.es.model.field.meta.ParentField;
import com.qf.es.model.field.meta.RoutingField;

public class MappingTest extends BaseUnit {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TransportClient transportClient;
	
	@Test
	public void testPutMapping() throws IOException, InterruptedException, ExecutionException {
		IndicesAdminClient client = transportClient.admin().indices();		
		PutMappingRequestBuilder putBuilder = client.preparePutMapping("test");
		
		MappingType mappingType1 = new MappingType("mappingType1");
		
		MappingField mf11 = new MappingField(new TextField("version"));
		mf11	.addParameter(MappingParameter.STORE.TRUE)
 		 	.addParameter(MappingParameter.ANALYZER.ENGLISH)
 		 	.addParameter(MappingParameter.INDEX.TRUE);
		mappingType1.addField(mf11);
		
		MappingField mf12 = new MappingField(new DateField("pub-date"));
		mf12	.addParameter(MappingParameter.STORE.TRUE)
		 	.addParameter(MappingParameter.INDEX.TRUE);
		mappingType1.addField(mf12);
		
		MappingType mappingType2 = new MappingType("mappingType2");
		
		MappingField mf21 = new MappingField(new TextField("domain"));
		mf21	.addParameter(MappingParameter.STORE.TRUE)
 		 	.addParameter(MappingParameter.ANALYZER.ENGLISH)
 		 	.addParameter(MappingParameter.INDEX.TRUE);
		mappingType2.addField(mf21);
		
		MappingType mappingType3 = new MappingType("mappingType3");
		
		MappingField mf30 = new MappingField(new KeywordField("officeId"));
		mf30	.addParameter(MappingParameter.STORE.TRUE)
 		 	.addParameter(MappingParameter.INDEX.TRUE);
		mappingType3.addField(mf30);
		
		MappingField mf31 = new MappingField(new TextField("name"));
		mf31	.addParameter(MappingParameter.STORE.TRUE)
 		 	.addParameter(MappingParameter.ANALYZER.ENGLISH)
 		 	.addParameter(MappingParameter.INDEX.TRUE)
 		 	.addParameter(MappingParameter.BOOST.value(2.0f));
		mappingType3.addField(mf31);
		
		MappingField mf32 = new MappingField(new DateField("birthday"));
		mf32	.addParameter(MappingParameter.STORE.TRUE)
 		 	.addParameter(MappingParameter.INDEX.TRUE)
 		 	.addParameter(MappingParameter.FORMAT.value("yyyy-MM-dd HH:mm:ss"));
		mappingType3.addField(mf32);
		
		MappingField mf33 = new MappingField(new ShortField("weight"));
		mf33	.addParameter(MappingParameter.STORE.TRUE)
 		 	.addParameter(MappingParameter.INDEX.TRUE);
		mappingType3.addField(mf33);
		
		MappingField mf34 = new MappingField(new AllField());
		mf34	.addParameter(MappingParameter.STORE.FLASE)
 		 	.addParameter(MappingParameter.ENABLED.TRUE);
		mappingType3.addField(mf34);
		
		MappingField mf35 = new MappingField(new NestedField("version", mappingType1));
		mappingType3.addField(mf35);
		
		MappingField mf36 = new MappingField(new ParentField(mappingType2));
		mappingType3.addField(mf36);
		
		MappingField mf37 = new MappingField(new RoutingField());
		mf37	.addParameter(MappingParameter.REQUIRED.FLASE);
		mappingType3.addField(mf37);
		
//		putBuilder.setType("mType1").setSource(mappingType1.buildSetting(null));
		putBuilder.setType("mType2").setSource(mappingType2.buildSetting(null));
		
		ActionFuture<PutMappingResponse> putFuture = putBuilder.execute();
		
		PutMappingResponse putResponse = putFuture.get();
		log.error("Response: {}", putResponse.isAcknowledged());
		
		Map<String, Object> map = mappingType3.buildSetting(null);
		log.error(JSON.toJSONString(map));
		
		putBuilder.setType("mType3").setSource(map);
		putFuture = putBuilder.execute();
		
		putResponse = putFuture.get();
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
			String key = it.next();
			MappingMetaData m = map.get(key);
			log.error("key: {}, data: {}", key, JSON.toJSONString(m));
		}
	}
	
}
