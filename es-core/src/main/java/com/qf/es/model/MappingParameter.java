package com.qf.es.model;

import java.util.List;

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
	
	public final static Analyzer ANALYZER = parameter.new Analyzer();
	public final static Enabled ENABLED = parameter.new Enabled();
	public final static Store STORE = parameter.new Store();
	public final static Index INDEX = parameter.new Index();
	public final static Boost BOOST = parameter.new Boost();
	public final static CopyTo COPY_TO = parameter.new CopyTo();
	public final static Coerce COERCE = parameter.new Coerce();
	public final static Format FORMAT = parameter.new Format();
	public final static IncludeInAll INCLUDE_IN_ALL = parameter.new IncludeInAll();
	public final static DocValues DOC_VALUES = parameter.new DocValues();
	public final static FieldData FIELDDATA = parameter.new FieldData();
	public final static Fields FIELDS = parameter.new Fields();
	
	private MappingParameter() {};
	
	public class Analyzer extends MappingParameterType {
		
		private Analyzer() {};
		
		public String getPropertyName() {
			return "analyzer";
		}
		
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
	
	public class Enabled extends MappingParameterType {
		
		private Enabled() {};
		
		public String getPropertyName() {
			return "enabled";
		}
		
		public MappingParameterValue TRUE = new MappingParameterValue(this, "true");
		public MappingParameterValue FLASE = new MappingParameterValue(this, "false");
		
	}
	
	public class Store extends MappingParameterType {
		
		private Store() {};
		
		public String getPropertyName() {
			return "store";
		}
		
		public MappingParameterValue TRUE = new MappingParameterValue(this, "true");
		public MappingParameterValue FLASE = new MappingParameterValue(this, "false");
		
	}
	
	public class Index extends MappingParameterType {
		
		private Index() {};
		
		public String getPropertyName() {
			return "index";
		}
		
		public MappingParameterValue TRUE = new MappingParameterValue(this, "true");
		public MappingParameterValue FLASE = new MappingParameterValue(this, "false");
		
	}
	
	public class Boost extends MappingParameterType {

		private Boost() {};
		
		public String getPropertyName() {
			return "boost";
		}
		
		public MappingParameterValue value(Float value) {
			return new MappingParameterValue(this, value);
		}
		
	}
	
	public class IncludeInAll extends MappingParameterType {

		private IncludeInAll() {};
		
		public String getPropertyName() {
			return "include_in_all";
		}
		
		public MappingParameterValue TRUE = new MappingParameterValue(this, "true");
		public MappingParameterValue FLASE = new MappingParameterValue(this, "false");
		
	}
	
	public class DocValues extends MappingParameterType {

		private DocValues() {};
		
		public String getPropertyName() {
			return "doc_values";
		}
		
		public MappingParameterValue TRUE = new MappingParameterValue(this, "true");
		public MappingParameterValue FLASE = new MappingParameterValue(this, "false");
		
	}
	
	public class FieldData extends MappingParameterType {

		private FieldData() {};
		
		public String getPropertyName() {
			return "fielddata";
		}
		
		public MappingParameterValue TRUE = new MappingParameterValue(this, "true");
		public MappingParameterValue FLASE = new MappingParameterValue(this, "false");
		
	}
	
	public class CopyTo extends MappingParameterType {

		private CopyTo() {};
		
		public String getPropertyName() {
			return "copy_to";
		}
		
		public MappingParameterValue value(List<String> value) {
			return new MappingParameterValue(this, value);
		}
		
	}
	
	public class Coerce extends MappingParameterType {

		private Coerce() {};
		
		public String getPropertyName() {
			return "coerce";
		}
		
		public MappingParameterValue TRUE = new MappingParameterValue(this, "true");
		public MappingParameterValue FLASE = new MappingParameterValue(this, "false");
		
	}
	
	public class Format extends MappingParameterType {

		private Format() {};
		
		public String getPropertyName() {
			return "format";
		}
		
		public MappingParameterValue value(String value) {
			return new MappingParameterValue(this, value);
		}
		
	}
	
	public class Fields extends MappingParameterType {

		private Fields() {};
		
		public String getPropertyName() {
			return "fields";
		}
		
		public MappingParameterValue value(MappingField value) {
			return new MappingParameterValue(this, value);
		}
		
	}
	
	public abstract class MappingParameterType implements Setting {
				
		private MappingParameterType() {}

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
