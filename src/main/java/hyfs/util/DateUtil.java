package hyfs.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/**
 * 时间util
 * @author admin
 * 
 */
public class DateUtil {
	
	/**一天的秒数*/
	public static final int DAY_SEC = 60*60*24;
	/**一小时的秒数**/
	public static final int HOUR_SEC = 60*60;
	/**一分钟的秒数*/
	public static final int MINUTE_SEC = 60;
	/**一天的毫秒数*/
	public static final long DAY_MILL_SEC = 60*60*24 * 1000;
	
	/**
	 * 获得当前Util时间
	 *
	 * @return d
 	 */
	public static Date getCurrentUtilDate() {
		return new Date();
	}
	
	/**
	 * 返回时间的秒数
	 * @return
	 *　int
	 */
	public static int getDateSeconds(){
		return getDateSeconds(new Date());
	}
	/**
	 * 返回时间的秒数
	 * @param date
	 * @return
	 *　int
	 */
	public static int getDateSeconds(Date date){
		return (int)(date.getTime() / 1000);
	}

	/**
	 * 返回秒钟
	 * 
	 * @param date
	 * @return
	 */
	public static int getSecond(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}

	/**
	 * 返回分钟
	 * @param date
	 * @return
	 */
	public static int getMinute(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}
	
	/**
	 * 返回小时
	 * @param date
	 * @return
	 */
	public static int getHour(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * 返回天
	 * */
	public static int getDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_YEAR);
	}
	
	public static int getMonthDay(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int getMonth(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		return c.get(Calendar.MONTH) + 1;
	}
	
	public static int getYear(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}
	/**
	 * 获取一天的开始时间(yyyy-MM-dd 00:00:00)
	 * @param date
	 * @return d
	 */
	public static Date getDayOfStartTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 获取一天的结束时间(yyyy-MM-dd 23:59:59)
	 * @param date
	 * @return d
	 */
	public static Date getDayOfEndTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}
	
	/**
	 * 获取一个小时的开始时间(yyyy-MM-dd hh:00:00)
	 * @param date
	 * @return
	 */
	public static Date getHourOfStartTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 获取一个小时的结束时间(yyyy-MM-dd hh:59:59)
	 * @param date
	 * @return
	 */
	public static Date getHourOfEndTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}
	
	/**
	 * 根据类型修改时间(加时间)
	 * @param date
	 * @param type 秒，分，小时，天等等
	 * @param time 
	 * @return
	 */
	public static Date addDateByType(Date date, int type, int time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(type, time);
		
		return calendar.getTime();
	}
	
	/**
	 * 根据类型修改时间(减时间)
	 * @param date
	 * @param type 秒，分，小时，天等等
	 * @param time 
	 * @return
	 */
	public static Date subDateByType(Date date, int type, int time) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		long dateTime = calendar.getTimeInMillis();
		
		long mul = 1;
		
		switch (type) {
		case Calendar.DAY_OF_MONTH:
			mul = mul * 24 * 60 * 60 * 1000;
			break;
		case Calendar.HOUR:
		case Calendar.HOUR_OF_DAY:
			mul = mul * 60 * 60 * 1000;
			break;
		case Calendar.MINUTE:
			mul = mul * 60 * 1000;
			break;
		case Calendar.SECOND:
			mul = mul * 1000;
			break;
		}
		
		calendar.setTimeInMillis(dateTime - mul * time);
		
		return calendar.getTime();
	}
	
	/**
	 * 是否是当天
	 * @param date
	 * @return
	 */
	public static boolean isCurrentDay(Date date) {
		boolean result = false;
		
		Calendar today = Calendar.getInstance();
		
		Calendar dateDay = Calendar.getInstance();
		dateDay.setTime(date);
		
		if (today.get(Calendar.YEAR) == dateDay.get(Calendar.YEAR)
				&& today.get(Calendar.MONTH) == dateDay.get(Calendar.MONTH)
				&& today.get(Calendar.DAY_OF_MONTH) == dateDay.get(Calendar.DAY_OF_MONTH)) {
			result = true;
		}
		
		return result;
	}
	
	/**
	 * 当前时间是否在开始时间和结束时间之间
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static boolean isInTime(Date startTime, Date endTime) {
		boolean result = false;

		if (System.currentTimeMillis() > startTime.getTime()
				&& System.currentTimeMillis() < endTime.getTime()) {
			result = true;
		}

		return result;
	}
	
	/**
	 *	指定的时间是否在开始时间和结束时间之内
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static boolean isInTime(Date date, Date startTime, Date endTime) {
		boolean result = false;

		if (date.getTime() > startTime.getTime()
				&& date.getTime() < endTime.getTime()) {
			result = true;
		}

		return result;
	}
	
	/**
	 * 当前时间是否在开始时间和结束时间之间
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static boolean isInTime(long startTime, long endTime) {
		boolean result = false;

		if (System.currentTimeMillis() > startTime
				&& System.currentTimeMillis() < endTime) {
			result = true;
		}

		return result;
	}
	
	/**
	 * 验证时间是否在这周
	 * @param getGiftbagTime
	 * @return
	 */
	public static boolean checkIsInWeek(Date getGiftbagTime) {
		boolean result = false;
		
		if (getGiftbagTime != null) {
			
			Calendar calendar = Calendar.getInstance();
			int week = calendar.get(Calendar.DAY_OF_WEEK);
			
			// 本周第一天
			Calendar fistDay = Calendar.getInstance();
			fistDay.add(Calendar.DAY_OF_MONTH, 2 - week);
			fistDay.set(Calendar.HOUR_OF_DAY, 0);
			fistDay.set(Calendar.MINUTE, 0);
			fistDay.set(Calendar.SECOND, 0);
			
			// 本周最后一天
			Calendar lastDay = Calendar.getInstance();
			lastDay.add(Calendar.DAY_OF_MONTH, 8 - week);
			lastDay.set(Calendar.HOUR_OF_DAY, 23);
			lastDay.set(Calendar.MINUTE, 59);
			lastDay.set(Calendar.SECOND, 59);
			
			if (getGiftbagTime.getTime() > fistDay.getTime().getTime() && getGiftbagTime.getTime() < lastDay.getTime().getTime()) {
				result = true;
			}
		}
		
		return result;
	}
	
	/**
	 * 是否每周第一天
	 * @return
	 */
	public static boolean isFirstWeekDay() {
		boolean result = false;
		
		Calendar calendar = Calendar.getInstance();
		if (calendar.get(Calendar.DAY_OF_WEEK) == 2) {
			result = true;
		}
		
		return result;
	}
	
	/**
	 * 设置calendar时间
	 */
	public static Calendar setCalendarTime(int hour, int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, 0);
		return calendar;
	}
	
	/**
	 * 获取时间字符串(00:00:00)
	 */
	public static String getTimeStr(int hour, int minute) {
		String str = hour + ":";
		if (minute > 9) {
			str = str + minute + ":00";
		} else {
			str = str + "0" + minute + ":00";
		}
		return str;
	}
	
	/**
	 * 指定字符类时间转Date
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static Date getDateByString(String timeStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return dateFormat.parse(timeStr);
		} catch (Exception e) {
			return getDateString(timeStr);
		}
	}
	
	/**
	 * 指定字符类时间转Date
	 * yyyy-MM-dd
	 */
	private static Date getDateString(String timeStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dateFormat.parse(timeStr);
		} catch (Exception e) {
			//TODO tianjiayige logutil by xuzhishun
			//LogUtil.error("异常:",e);
		}
		
		return null; 
	}
	
	/**字符串转换成date 最好是把常用的格式定义成常量.. */
	public static Date parseDate(String strDate) throws ParseException{
		return parseDate(strDate,null);
	}
	
	/**字符串转换成date */
	public static Date parseDate(String strDate,String fmt) throws ParseException{
		
		if(fmt == null || fmt.trim().equals("")){
			fmt = "yyyy-MM-dd HH:mm:ss";
		}
		
		return new SimpleDateFormat(fmt).parse(strDate);
		
	}
	
	/** 时间格式化 让格式能够传入*/
	public static String dateFormt(Date date, String fmt){
		if(fmt == null || fmt.trim().equals("")){
			fmt = "yyyy-MM-dd HH:mm:ss";
		}
		
		return new SimpleDateFormat(fmt).format(date);
	}
	/** 时间格式化 */
	public static String dateFormat(Date date) {
		return dateFormt(date,"yyyy-MM-dd HH:mm:ss");
	}
	
	/** 时间格式化 */
	public static String dateFormatYMD(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	/** 相差天数*/
	public static int difDate(Date startTime, Date endTime){
		return (int) ((getYMDOfStartTime(endTime).getTime() / 1000 - getYMDOfStartTime(startTime).getTime() / 1000) / (24 * 60 * 60 ) + 1);
	}
	
	/** 获取一个小时的开始时间(yyyy-MM-dd 00:00:00)*/
	@SuppressWarnings("static-access")
    private static Date getYMDOfStartTime(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	
	/** 增减时间*/
	public static Date getDateAddTime(Date date, int addTime){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date.getTime() + addTime);
		
		return c.getTime();
	}
	
	
	/** 相差的时间*/
	public static int difTime(Date startTime){
		return (int)((System.currentTimeMillis() - startTime.getTime()) / 1000);
	}
	
	
	/** 获取指定月份 天数的时间*/
	public static Date getDateByMonthDay(int year, int month, int day){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH , month - 1);
		c.set(Calendar.DAY_OF_MONTH, day);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		return c.getTime();
	}
	
	
	
	/** 转换为数据库时间*/
	public static Timestamp getSqlDate(Date date){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		String nowTime = dateFormat(c.getTime());
		Timestamp time = java.sql.Timestamp.valueOf(nowTime);
		
		return time; 

	}
	
	/**获取当月最大的天*/
	public static int getMonthMaxDay(){
		Calendar instance = Calendar.getInstance();
		return instance.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	
}
