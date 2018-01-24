package com.qf.es.test;

import com.qf.es.anno.FieldAnno;
import com.qf.es.anno.MappingParameterAnno;
import com.qf.es.anno.MetaFieldAnno;

@MetaFieldAnno(type="_parent", refererType="parent")
@MetaFieldAnno(type="_source", parameters={@MappingParameterAnno(type="enabled", value = "true")})
public class AnnoTest {
	
	@FieldAnno
	private String name;
	
	@FieldAnno(type="long", parameters={@MappingParameterAnno(type="boost", value = "1.5")})
	private Long count;
	
	@MappingParameterAnno(type="include_in_all", value = "true")
	private MType1 type1;
	
	@MappingParameterAnno(type="dynamic", value = "true")
	private MType2[] type2;
	
	@FieldAnno(type="nested", parameters={@MappingParameterAnno(type="boost", value = "1.5")})
	private MType3[] type3;
	
	@MappingParameterAnno(type="doc_values", value = "true")
	@MappingParameterAnno(type="store", value = "false")
	private String[] properties;

}
