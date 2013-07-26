/**
 * <p>Title: TestBase.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * @author eason
 * @date 2013-5-21
 * @version 1.0
 */
package org.eason.common.collected.framework.test;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>Title: TestBase</p>
 * <p>Description: 所有测试类的基类，定义初始和结束时的操作</p>
 * <p>可以在这个测试环境中直接使用spring中定义的bean</p>
 * @author eason
 * @date 2013-5-21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml", "classpath:applicationContext-shiro.xml"})
public class WithSpringContextTest {
	
	private static Logger logger = LoggerFactory.getLogger(WithSpringContextTest.class);

	/**
	 * <p>Title: setUp</p>
	 * <p>Description: 每个测试函数前的初始化环境操作</p>
	 */
	@Before
	public void setUp() {
		logger.info("setUp");
	}

	/**
	 * <p>Title: tearDown</p>
	 * <p>Description: 每个测试函数结束后的收尾操作</p>
	 */
	@After
	public void tearDown() {
		logger.info("tearDown");
	}
	
}
