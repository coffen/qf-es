package com.qf.es.model.field;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;
import com.qf.es.model.FieldValue;
import com.qf.es.model.MappingField;
import com.qf.es.model.MappingParameter;
import com.qf.es.model.MappingParameter.MappingParameterType;
import com.qf.es.model.MappingParameter.MappingParameterValue;
import com.qf.es.model.exception.FieldMappingException;

public abstract class StringField extends MappingField {
	
	private final static Set<MappingParameterType> SUPPORTED_PARAMETER = Sets.newHashSet(MappingParameter.STORE, MappingParameter.INDEX, MappingParameter.BOOST);
	private final static Set<Class<?>> SUPPORTED_TYPE = Sets.newHashSet(String.class);
	
	private Map<String, StringField> fields = new HashMap<String, StringField>();
	
	public StringField(String name) {
		super(name);
	}

	public FieldValue buildValue(Object obj) throws FieldMappingException {
		if (obj instanceof String) {
			return new FieldValue(fieldName, obj);		
		}
		else {
			throw new FieldMappingException(fieldName, "Unsupported value type!");
		}
	}

	public boolean supportType(Class<?> clazz) {
		return SUPPORTED_TYPE.contains(clazz);
	}

	public boolean supportParameter(MappingParameterValue parameterValue) {
		if (parameterValue == null) {
			return false;
		}
		return SUPPORTED_PARAMETER.contains(parameterValue.getParameterType());
	}

}
