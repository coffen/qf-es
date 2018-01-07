package com.qf.es.model.field;

import com.qf.es.model.Field;
import com.qf.es.model.MappingType;

public class ObjectField extends Field {
	
	private MappingType type;

	public ObjectField(String name, MappingType type) {
		super(name);
		if (type == null) {
			throw new RuntimeException("MappingType must not empty.");
		}
		this.type = type;
	}

	@Override
	public String getPropertyName() {
		return getName();
	}

}
