package org.eason.common.demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunctionDemo {
	
	private static Logger logger = LoggerFactory.getLogger(FunctionDemo.class);
	
	@Test
	public void printCallerFunctionName(){
		Exception e = new Exception();
		StackTraceElement[] stacks = e.getStackTrace();
		StackTraceElement caller = stacks[1];
		logger.info("caller function name is : [{}] ", caller.getMethodName());
	}

}
