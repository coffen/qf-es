package com.qf.es.model;

import com.qf.es.model.field.StringField;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 映射参数
 * <br>
 * File Name: MappingParameter.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2017-11-30
 * @version: v1.0
 *
 */
public class MappingParameter {
	
	private static MappingParameter parameter = new MappingParameter();
	
	public final static AnalyzerType ANALYZER_TYPE = parameter.new AnalyzerType();
	public final static Store STORE = parameter.new Store();
	public final static Index INDEX = parameter.new Index();
	public final static Boost BOOST = parameter.new Boost();
	public final static Format FORMAT = parameter.new Format();
	public final static Fields FIELDS = parameter.new Fields();
	
	private MappingParameter() {};
	
	public class AnalyzerType extends MappingParameterType {
		
		private AnalyzerType() {};
		
		public MappingParameterValue STANDARD = new MappingParameterValue(this, "standard");
		public MappingParameterValue SIMPLE = new MappingParameterValue(this, "simple");
		public MappingParameterValue WHITESPACE = new MappingParameterValue(this, "whitespace");
		public MappingParameterValue STOP = new MappingParameterValue(this, "stop");
		public MappingParameterValue KEYWORD = new MappingParameterValue(this, "keyword");
		public MappingParameterValue PATTERN = new MappingParameterValue(this, "pattern");
		public MappingParameterValue ENGLISH = new MappingParameterValue(this, "english");
		public MappingParameterValue IK_SMART = new MappingParameterValue(this, "ik_smart");
		public MappingParameterValue IK_MAX_WORD = new MappingParameterValue(this, "ik_max_word");
		public MappingParameterValue FINGERPRINT = new MappingParameterValue(this, "fingerprint");

	}
	
	public class Store extends MappingParameterType {
		
		private Store() {};
		
		public MappingParameterValue TRUE = new MappingParameterValue(this, "true");
		public MappingParameterValue FLASE = new MappingParameterValue(this, "false");
		
	}
	
	public class Index extends MappingParameterType {
		
		private Index() {};
		
		public MappingParameterValue TRUE = new MappingParameterValue(this, "true");
		public MappingParameterValue FLASE = new MappingParameterValue(this, "false");
		
	}
	
	public class Boost extends MappingParameterType {

		private Boost() {};
		
		public MappingParameterValue value(Float value) {
			return new MappingParameterValue(this, value);
		}
		
	}
	
	public class Format extends MappingParameterType {

		private Format() {};
		
		public MappingParameterValue value(String value) {
			return new MappingParameterValue(this, value);
		}
		
	}
	
	public class Fields extends MappingParameterType {

		private Fields() {};
		
		public MappingParameterValue value(StringField value) {
			return new MappingParameterValue(this, value);
		}
		
	}
	
	public class MappingParameterType {
		
		private MappingParameterType() {};

	}
	
	public class MappingParameterValue {
		
		private MappingParameterType parameterType;
		private Object value;
		
		private MappingParameterValue(MappingParameterType parameter, Object value) {
			this.parameterType = parameter;
			this.value = value;
		}
		
		public MappingParameterType getParameterType() {
			return parameterType;
		}
		
		public Object value() {
			return this.value;
		}

	}

}
