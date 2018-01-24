package com.qf.es.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * <p>
 * Project Name: 淘客
 * <br>
 * Description: 映射类型
 * <br>
 * File Name: MappingTypeAnno.java
 * <br>
 * Copyright: Copyright (C) 2015 All Rights Reserved.
 * <br>
 * Company: 杭州偶尔科技有限公司
 * <br>
 * @author 穷奇
 * @create time：2018年1月22日 下午5:18:49 
 * @version: v1.0
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MappingTypeAnno {
	
	String name() default "";
	
	MetaFieldAnno[] value() default {};

}
