package org.eason.common.collected.framework.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.StrutsSpringTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.opensymphony.xwork2.ActionProxy;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({})
public class Struts2ActionTest1  extends StrutsSpringTestCase{
	
	private static Logger logger = LoggerFactory.getLogger(Struts2ActionTest1.class);
	
	protected ActionProxy proxy;

    protected String[] getContextLocations() {
    	String locationStr = "classpath:applicationContext.xml";
    	String[] locations = StringUtils.split(locationStr, ",");
        return locations;
    }
    
	/**
	 * <p>Title: setUp</p>
	 * <p>Description: 每个测试方法前的初始化环境操作</p>
	 */
	@Before
	public void setUp() throws Exception {
		
		super.setUp();
		
		//do something
		logger.info("setUp");
	}

	/**
	 * <p>Title: tearDown</p>
	 * <p>Description: 每个测试方法结束后的收尾操作</p>
	 */
	@After
	public void tearDown() throws Exception {
		
		logger.info("tearDown");
		//do something
		super.tearDown();
	}
}
