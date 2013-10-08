package org.eason.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private final static String timeFormat = "HH:mm:ss"; // hh时(大写为24进制,小写为12进制)
	private final static String dateFormat = "yyyy-MM-dd";
	private final static String dateAndTimeFormat = "yyyy-MM-dd HH:mm:ss";
	
	private DateUtils() {
		
	}

	/**
	 * 根据默认格式的时间字符串获取时间对象
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimeStr(Date date) {
		if(date == null){
			return "00:00:00";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(timeFormat); // hh时(大写为24进制,小写为12进制)
		return sdf.format(date);
	}

	/**
	 * 获取默认格式的时间字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getTimeStr(Date date, String format) {
		if(date == null || format == null){
			return "00:00:00";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 根据默认格式的时间字符串获取时间对象
	 * 
	 * @param str 时间字符串
	 * @param format 时间格式
	 * @return Date 时间对象
	 */
	public static Date getDate(String str, String format) {
		if(str == null || format == null){
			return null;
		}
		
		Date date = null;
		SimpleDateFormat tmpSimpleDateFormat = new SimpleDateFormat(format);

		try {  
			date = tmpSimpleDateFormat.parse(str);  
		}  
		catch (Exception ex) { 
			ex.printStackTrace();
			System.out.println(ex.getMessage());  
		} 
		return date;
	}

	/**
	 * 根据字符串格式的("HH:mm:ss")获得时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getTime(String timeStr) {
		if(timeStr == null){
			return null;
		}
		Date date = null;
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timeFormat);
		
		try {  
			date = simpleDateFormat.parse(timeStr); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
		} 
		return date;
	}

	/**
	 * 根据自定义格式的字符串格式的获得时间
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date getTime(String timeStr, String format) {
		if(timeStr == null){
			return null;
		}
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		
		try {  
			date = simpleDateFormat.parse(timeStr); 
		}
		catch (Exception ex) {  
			ex.printStackTrace();
			System.out.println(ex.getMessage()); 
		} 
		return date;
	}

	/**
	 * 根据字符串格式的("yyyy-MM-dd")获得日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDate(String dateStr) {
		if(dateStr == null){
			return null;
		}
		
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		
		try {  
			date = simpleDateFormat.parse(dateStr); 
		}  
		catch (Exception ex) {  
			ex.printStackTrace();
			System.out.println(ex.getMessage());  
		} 
		return date;
	}
	

	/**
	 * @return
	 */
	public static String getDateStr(Date date) {
		if(date == null || dateFormat == null){
			return "2012-01-01";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}
	
	/**
	 * @return
	 */
	public static String getDateStr(Date date, String format) {
		if(date == null || format == null){
			return "20120101";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 根据字符串格式的("yyyy-MM-dd HH:mm:ss")获得日期
	 * 
	 * @param dateAndTime
	 * @return
	 */
	public static Date getDateAndTime(String dateAndTime) {
		if(dateAndTime == null){
			return null;
		}
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateAndTimeFormat);
		
		try {  
			date = simpleDateFormat.parse(dateAndTime); 
		}  
		catch (Exception ex) {  
			ex.printStackTrace();
			System.out.println(ex.getMessage());  
		}
		return date;
	}
	
	/**
	 * 根据自定义日期格式获得日期
	 * 
	 * @param dateAndTime
	 * @return
	 */
	public static Date getDateAndTime(String dateAndTime, String dateAndTimeFormat) {
		if(dateAndTime == null){
			return null;
		}
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateAndTimeFormat);
		
		try {  
			date = simpleDateFormat.parse(dateAndTime); 
		}  
		catch (Exception ex) {  
			ex.printStackTrace();
			System.out.println(ex.getMessage());  
		}
		return date;
	}
	
	/**
	 * 
	 * @param date
	 * @param time
	 * @return
	 */
	public static String getDateAndTimeStr(Date date, Date time) {
		
		SimpleDateFormat sdf = null;
		
		if(dateFormat == null || timeFormat == null){
			sdf = new SimpleDateFormat(dateAndTimeFormat);
			return sdf.format(new Date());
		}
		
		sdf = new SimpleDateFormat(dateFormat);
		String dateStr = null;
		if (date != null) {
			dateStr = sdf.format(date);
		}else{
			dateStr = sdf.format(new Date());
		}
		
		sdf = new SimpleDateFormat(timeFormat);
		String timeStr = null;
		if (date != null) {
			timeStr = sdf.format(time);
		}else{
			timeStr = sdf.format(new Date());
		}
		
		String dateAndTimeStr = dateStr + " " + timeStr;
		
		return dateAndTimeStr;
	}

	/**
	 * 获取时间和日期字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getDateAndTimeStr(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 获取时间和日期字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateAndTimeStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateAndTimeFormat);
		return sdf.format(date);
	}
	
	
}
