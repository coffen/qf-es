package com.qf.es.test;

import java.sql.SQLException;

import org.junit.Before;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qf.es.config.ESConfig;

@ContextConfiguration(classes = { ESConfig.class })
public class BaseUnit extends AbstractJUnit4SpringContextTests {
	
    @Before
    public void before() throws SQLException {}

}
