package org.eason.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * <p>Title: PathUtil</p>
 * <p>Description: 路径管理类</p>
 * @author   eason
 * @date     2013-1-25
 */
public class PathUtil {
	/**
	* <p>Title: getWebClassesPath</p>
	* <p>Description: 获取项目中classes文件夹路径</p>
	* @return 返回classes文件夹路径
	 * @throws UnsupportedEncodingException 
	*/
	public String getWebClassesPath() throws UnsupportedEncodingException {
		final String resourceFileName = "IcePQServer.cfg";
		
		String path = Thread.currentThread().getContextClassLoader()
				.getResource(resourceFileName).getPath();
		path = path.substring(1);

		path = URLDecoder.decode(path, "utf-8");			
		
		if (path.indexOf(resourceFileName) > 0) {
			path = path.substring(0, path.indexOf(resourceFileName));
		}
		
		return path;

	}
 
	/**
	 * <p>Title: getComtradePath</p>
	 * <p>Description: 获取comtrade文件下载路径</p>
	 * @return comtrade文件下载路径
	 * @throws UnsupportedEncodingException 
	 */
	public String getDataTypePath() throws UnsupportedEncodingException {   
		return getWebClassesPath() + "datatype/";   
    } 

	/**
	 * <p>Title: getComtradePath</p>
	 * <p>Description: 获取comtrade文件下载路径</p>
	 * @return comtrade文件下载路径
	 * @throws UnsupportedEncodingException 
	 */
	public String getComtradePath() throws UnsupportedEncodingException { 
		return getWebClassesPath() + "comtrade/";
    }

	/**
	 * <p>Title: getTempPath</p>
	 * <p>Description: 获取临时文件存放地址</p>
	 * @return 
	 */
	public String getTempPath() { 
		return getWebRoot() + "temp/";
    }

	/**
	 * <p>Title: getWebRoot</p>
	 * <p>Description: 获取WebRoot路径</p>
	 * @return WebRoot路径字符串
	 */
	public String getWebRoot() {
		String path = "";
		
		try {
			path = getWebClassesPath();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if (path.indexOf("WEB-INF") > 0) {
			path = path.substring(0, path.indexOf("WEB-INF"));
		}
		
		return path;
	}
}

