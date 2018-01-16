package com.qf.es.model.field;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.qf.es.model.Field;
import com.qf.es.model.Value;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: Join Field
 * <br>
 * File Name: JoinField.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2018-01-08
 * @version: v1.0
 *
 */
public final class JoinField extends Field {
	
	private List<JoinRelation> relations;

	public JoinField(String name, List<JoinRelation> relations) {
		super(name);
		if (CollectionUtils.isEmpty(relations)) {
			throw new RuntimeException("Relation must not empty.");
		}
		for (JoinRelation relation : relations) {
			if (StringUtils.isBlank(relation.getParent()) || StringUtils.isBlank(relation.getChild())) {
				throw new RuntimeException("Relation parent field and child field must not empty.");
			}
		}
	}

	@Override
	public String getPropertyName() {
		return "join";
	}
	
	@Override
	public Map<String, Object> buildSetting(Value value) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", getPropertyName());
		Map<String, String> relationMap = new HashMap<String, String>();
		for (JoinRelation relation : relations) {
			relationMap.put(relation.getParent(), relation.getChild());
		}
		map.put("relations", relationMap);
		return map;
	}

}
