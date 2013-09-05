package org.eason.common.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


public class WebPathUtils {

	/** web项目根目录 */
	private static String webRoot = null;
	
	/** web项目class目录 */
	private static String classPath = null;

	static {
		classPath = Thread.currentThread().getContextClassLoader()
				.getResource("").getPath();
		try {
			classPath = URLDecoder.decode(classPath, "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		if (classPath.contains("WEB-INF")) {

			webRoot = Thread.currentThread().getContextClassLoader()
				.getResource("../../").getPath();
		} else {

			webRoot = System.getProperty("user.dir");
			webRoot = webRoot + "/";
		}
		try {
			webRoot = URLDecoder.decode(webRoot, "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @return the webRoot
	 */
	public static String getWebRoot() {
		return webRoot;
	}
	

	/**
	 * @return the currentPath
	 */
	public static String getPath() {
		return webRoot;
	}
	
	public static String getPath(String relativeFilePath) {
		return webRoot + relativeFilePath;
	}

	public static File getFile(String relativeFilePath) {
		return new File(webRoot + relativeFilePath);
	}

	/**
	 * @return the currentPath
	 */
	public static String getClassPath() {
		return classPath;
	}
	
	public static String getClassPath(String relativeFilePath) {
		return classPath + relativeFilePath;
	}

	public static File getClassPathFile(String relativeFilePath) {
		return new File(classPath + relativeFilePath);
	}
}
