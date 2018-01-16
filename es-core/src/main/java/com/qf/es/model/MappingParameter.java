package com.qf.es.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	// 索引分析
	public final static Analyzer ANALYZER = parameter.new Analyzer();
	// 查询分析
	public final static Analyzer SEARCH_ANALYZER = parameter.new Analyzer();
	// 是否动态索引
	public final static Dynamic DYNAMIC = parameter.new Dynamic();
	// 是否只存储不索引
	public final static Enabled ENABLED = parameter.new Enabled();
	// 是否存储
	public final static Store STORE = parameter.new Store();
	// 是否索引
	public final static Index INDEX = parameter.new Index();
	// 索引选项
	public final static IndexOptions INDEX_OPTIONS = parameter.new IndexOptions();
	// Norms设置选项
	public final static Norms NORMS = parameter.new Norms();
	// 索引加权
	public final static Boost BOOST = parameter.new Boost();
	// 复制指向自定义字段
	public final static CopyTo COPY_TO = parameter.new CopyTo();
	// 数据清洗
	public final static Coerce COERCE = parameter.new Coerce();
	// 格式（日期）
	public final static Format FORMAT = parameter.new Format();
	// 包含在所有中
	public final static IncludeInAll INCLUDE_IN_ALL = parameter.new IncludeInAll();
	// 正向索引存储
	public final static DocValues DOC_VALUES = parameter.new DocValues();
	// 正向索引预加载
	public final static FieldData FIELDDATA = parameter.new FieldData();
	// 正向索引预加载选项
	public final static FieldDataFrequencyFilter FIELDDATA_FREQUENCY_FILTER = parameter.new FieldDataFrequencyFilter();
	// 空文档默认值
	public final static NullValue NULL_VALUE = parameter.new NullValue();
	// 字符串忽略长度
	public final static IgnoreAbove IGNORE_ABOVE = parameter.new IgnoreAbove();
	// 忽略文档值错误
	public final static IgnoreMalformed IGNORE_MALFORMED = parameter.new IgnoreMalformed();
	// Term增量设置
	public final static PositionIncrementGap POSITION_INCREMENT_GAP = parameter.new PositionIncrementGap();
	// 相似性设置
	public final static Similarity SIMILARITY = parameter.new Similarity();
	// 向量设置
	public final static TermVector TERM_VECTOR = parameter.new TermVector();
	// 文档别名
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
	
	public class Dynamic extends MappingParameterType {
		
		private Dynamic() {};
		
		public String getPropertyName() {
			return "dynamic";
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
	
	public class IndexOptions extends MappingParameterType {
		
		private IndexOptions() {};
		
		public String getPropertyName() {
			return "index_options";
		}
		
		public MappingParameterValue DOCS = new MappingParameterValue(this, "docs");
		public MappingParameterValue FREQS = new MappingParameterValue(this, "freqs");
		public MappingParameterValue POSITIONS = new MappingParameterValue(this, "positions");
		public MappingParameterValue OFFSETS = new MappingParameterValue(this, "offsets");
		
	}
	
	public class Norms extends MappingParameterType {
		
		private Norms() {};
		
		public String getPropertyName() {
			return "norms";
		}
		
		public MappingParameterValue TRUE = new MappingParameterValue(this, "true");
		public MappingParameterValue FLASE = new MappingParameterValue(this, "false");
		
	}
	
	public class Boost extends MappingParameterType {

		private Boost() {};
		
		public String getPropertyName() {
			return "boost";
		}
		
		public MappingParameterValue value(float value) {
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
	
	public class FieldDataFrequencyFilter extends MappingParameterType {

		private FieldDataFrequencyFilter() {};
		
		public String getPropertyName() {
			return "fielddata_frequency_filter";
		}
		
		public MappingParameterValue value(float min, float max, int minSegment) {
			return new MappingParameterValue(this, min, max, minSegment) {
				public Object getValue() {
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("min", min);
					params.put("max", min);
					params.put("min_segment_size", minSegment);
					return params;
				}
			};
		}
		
	}
	
	public class NullValue extends MappingParameterType {

		private NullValue() {};
		
		public String getPropertyName() {
			return "null_value";
		}
		
		public MappingParameterValue value(String value) {
			return new MappingParameterValue(this, value);
		}
		
	}
	
	public class IgnoreAbove extends MappingParameterType {

		private IgnoreAbove() {};
		
		public String getPropertyName() {
			return "ignore_above";
		}
		
		public MappingParameterValue TRUE = new MappingParameterValue(this, "true");
		public MappingParameterValue FLASE = new MappingParameterValue(this, "false");
		
	}
	
	public class IgnoreMalformed extends MappingParameterType {

		private IgnoreMalformed() {};
		
		public String getPropertyName() {
			return "ignore_malformed";
		}
		
		public MappingParameterValue TRUE = new MappingParameterValue(this, "true");
		public MappingParameterValue FLASE = new MappingParameterValue(this, "false");
		
	}
	
	public class PositionIncrementGap extends MappingParameterType {

		private PositionIncrementGap() {};
		
		public String getPropertyName() {
			return "position_increment_gap";
		}
		
		public MappingParameterValue value(int gap) {
			return new MappingParameterValue(this, gap);
		}
		
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
	
	public class Similarity extends MappingParameterType {

		private Similarity() {};
		
		public String getPropertyName() {
			return "similarity";
		}
		
		public MappingParameterValue BM25 = new MappingParameterValue(this, "BM25");
		public MappingParameterValue CLASSIC = new MappingParameterValue(this, "classic");
		public MappingParameterValue BOOLEAN = new MappingParameterValue(this, "boolean");
		
	}
	
	public class TermVector extends MappingParameterType {

		private TermVector() {};
		
		public String getPropertyName() {
			return "term_vector";
		}
		
		public MappingParameterValue YES = new MappingParameterValue(this, "yes");
		public MappingParameterValue NO = new MappingParameterValue(this, "no");
		public MappingParameterValue WITH_POSITIONS = new MappingParameterValue(this, "with_positions");
		public MappingParameterValue WITH_OFFSETS = new MappingParameterValue(this, "with_offsets");
		public MappingParameterValue WITH_POSITIONS_OFFSETS = new MappingParameterValue(this, "with_positions_offsets");
		
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
		
		public Map<String, Object> buildSetting(Value object) {
			Map<String, Object> map = new HashMap<String, Object>();
			if (object != null) {
				map.put(getPropertyName(), object.getValue());
			}
			return map;
		}

	}
	
	public class MappingParameterValue implements Value {

		private MappingParameterType parameterType;
		private Object value;
		
		private MappingParameterValue(MappingParameterType parameter, Object ... value) {
			this.parameterType = parameter;
			if (value != null && value.length > 0) {
				this.value = value[0];
			}
		}
		
		public MappingParameterType getParameterType() {
			return parameterType;
		}
		
		public Object getValue() {
			return this.value;
		}

	}

}
