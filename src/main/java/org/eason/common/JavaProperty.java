package org.eason.common;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class JavaProperty {

	
	@Test
	public void printProperty() {
		
		//架构体系 查看jdk的版本是32位还是64位
		String arch = System.getProperty("sun.arch.data.model");
		System.out.println(arch);
		
		//查看系统库路径
		String[] paths = StringUtils.split(System.getProperty("java.library.path"), ";");
		for (String path : paths) {
			System.out.println(path);
		}
	}
	
}
