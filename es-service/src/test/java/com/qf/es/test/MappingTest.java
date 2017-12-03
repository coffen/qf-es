package com.qf.es.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qf.es.model.MappingField;
import com.qf.es.model.MappingParameter;
import com.qf.es.model.exception.FieldMappingException;
import com.qf.es.model.field.BooleanField;

public class MappingTest extends BaseUnit {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void testMapping() {
		MappingField mf = new BooleanField("testField");
		try {
			mf.addMappingParameter(MappingParameter.STORE.TRUE)
			  .addMappingParameter(MappingParameter.ANALYZER_TYPE.IK_SMART)
			  .addMappingParameter(MappingParameter.INDEX.TRUE)
			  .addMappingParameter(MappingParameter.BOOST.value("2.0"));
		}
		catch (FieldMappingException e) {
			log.error(e.getFieldName() + ": " + e.getErrorMsg());
		}
		
	}
	
}
