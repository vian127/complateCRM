package com.pop136.customerservice.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

public class DateUtil {
	/**
	 *
	 *
	 *
	 * Calendar now = Calendar.getInstance(); System.out.println("年: " +
	 * now.get(Calendar.YEAR)); System.out.println("月: " + (now.get(Calendar.MONTH)
	 * + 1) + ""); System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));
	 * System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY));
	 * System.out.println("分: " + now.get(Calendar.MINUTE)); System.out.println("秒:
	 * " + now.get(Calendar.SECOND)); System.out.println("当前时间毫秒数：" +
	 * now.getTimeInMillis()); System.out.println(now.getTime());
	 *
	 * Date d = new Date(); System.out.println(d); SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String dateNowStr = sdf.format(d);
	 * System.out.println("格式化后的日期：" + dateNowStr);
	 *
	 * dateSubhour(String Date1, String Date2) 日期相减得到小时 daySub("2005-09-29 21:00:00
	 * ","2005-09-29 22:00:00") d1-d2 1 dateComp(String Date1, String Date2) 日期比较函数
	 * d1比d2小 dateComp("2006-3-1", "2006-4-1")---> -1 dateComp(String date1, String
	 * dateBegin,String dateEnd) 日期比较函数 d1是否在dateBegin和dateEnd区间内 dateMove(String
	 * sCurDate, int iDays) 日期增减函数 dateMove("2006-5-1", 78) 往后 -->2006-07-18
	 * weekMove(String sCurDate, int iDays) 周增减函数 dateTimeMove(String sCurDate, int
	 * iDays) 日期时间增减函数 输入时间 加减日期 daySub(String Date1, String Date2) 日期相减函数
	 * daySub("2006-3-1", "2006-4-1") d1-d2 -31 hourSub(Timestamp Date1, Timestamp
	 * Date2) 小时相减函数 daySubMoreOne(String Date1, String Date2) 日期相减函数 getCurDate()
	 * 获得当前日期 getDayTimeCurDate() 获得当前日期时间 getCurDay() 获得当前日 getCurLongDate()
	 * 获得当前长日期格式 2007-08-23 16:22:24 getCurMonth() 获得当前月(字符) getIntCurMonth()
	 * 获得当前月(整型) getCurTime() 获得当前时间 getCurWeekDay() 获得当前日对应的星期几 星期四---->4
	 * getCurYear() 获得当前年 2007 getDay(String sdate) 根据传入的日期，获得对应日
	 * getDay("2007-03-24") --->24 getDayFromString(String sdate) 根据传入的字符，获得对应日期
	 * getDayFromString getDayTimeFromString(String sDateTime) 根据传入的字符，获得对应日期/时间
	 * getBeginDateOfMonth(String strDate) 获得传入日期的月头日
	 * getBeginDateOfMonth("2007-03-24") ---->2007-03-01 getEndDateOfMonth(String
	 * strDate) 获得传入日期的月末日 getEndDateOfMonth("2007-03-24") ---->2007-03-31
	 * getLocalCurDate() 获得本地当前日期 2007年08月23日 getLocalCurWeekDay() 获得本地当前日对应的星期几 星期四
	 * getLocalDate(String sDate) 根据输入的日期串生成标准日期格式 getLocalDate("2007-02-25") -->
	 * 2007年02月25日 getLocalWeekDay(String sDate) 根据传入的日期获得日的星期
	 * getLocalWeekDay("2007-02-25")---->星期日 getPrivateLocalWeekDay(String
	 * inputFlag, int iDate) 根据传入的日期获得日的星期 getLocalWeekDay(0)---->星期日
	 * getLocalWeekDay(int iDate) 根据传入的日期获得日的星期 getLongLocalWeekDay(int iDate)
	 * 根据传入的日期获得日的星期 getStrMonth(String sdate) 获得传入日期的月 getMonth(String sdate)
	 * 获得传入日期的月 getMonth("2007-02-25");---->02 getNumOfMonth(String sDate, String
	 * sMonth) 获得？年？月的天数 getNumOfMonth("2007","3")---->31 getWeekDay(String sDate)
	 * 得到传入日期的星期几 getWeekDay("2007-08-23");--->4 getYear(String sdate) 得到传入日期的年份
	 * getYear("2007-08-23");---->2007 isDate(String strDate) 判断传入的日期是否为正确的日期格式
	 * isDate("2007-13-09");----false 传入的格式为"年-月-日" isRenYear(String strDate)
	 * 判断年是否为润年 isRenYear("2001-02-05");---false isRenYear("2000-02-05");---true
	 * monthRange(String sCurDate, String sEndDate) 传入开始日期，结束日期，获得日期中的月份 LinkedList
	 * ll = monthRange("2007-02-04","2007-08-19"); 2007-02 2007-03 2007-04 2007-05
	 * 2007-06 2007-07 2007-08 monthRange(String year) 传入传入年份获得日期中的月份
	 * monthRangeList(LinkedList mlist, String sCurDate) 传入mlist，结束日期，获得日期中的月份
	 * monthRangeCaption(String sCurDate, String sEndDate) 传入开始日期，结束日期，获得日期中的月份
	 * LinkedList li = monthRangeCaption("2007-02-04","2007-08-19"); 2007年02月
	 * 2007年03月 2007年04月 2007年05月 2007年06月 2007年07月 2007年08月 YearMove(String sDate,
	 * int iYear) 年的增加减少 YearMove("2007-08-23", -3); ---->2004-8-23
	 * isSameWeekDates(Date date1, Date date2) 关于星期的函数 判断两个日期是否在同一周
	 * getSeqWeekCaption(Date date) 产生周名字 getSeqWeek(Date date) 产生周名字 String s27 =
	 * getSeqWeek(dt); System.out.println((s27)); 34 getSunday(Date date)
	 * 获得日期所在得周日的日期 2007-08-19 按照西方的习惯，一周以周日开始，哈哈，那一般应该是前面，注意 getMonday(Date date)
	 * 获得周一的日期 2007-08-25 getTuesday(Date date) 获得周二的日期 2007-08-25 getWednesday(Date
	 * date) 获得周三的日期 2007-08-25 getThursday(Date date) 获得周四的日期 2007-08-25
	 * getFriday(Date date) 获得周五的日期 2007-08-25 getSaturday(Date date) 获得周六的日期
	 * 2007-08-25 weekRangeList(String sCurDate, String sEndDate)
	 * 带入开始日期和结束日期，得到所在的周的星期数，包括星期日的日期，星期六的日期，和caption 2007-08-19 2007-08-25
	 * dayRange(String sCurDate, String sEndDate) 两个日期间隔的天数
	 * dayRange("2007-08-01","2007-08-13");--->13 dayAfterNum(String sCurDate, int
	 * i) 返回若干天以后的日期 dayAfterNum("2007-08-01", 13);---2007年8月14日 getBeginDate(String
	 * range) 按照select取得时间范围 getEndDate(String range) 按照select取得时间范围
	 * getSFAEndDate(String inputDate, String range) 按照select取得时间范围
	 * dateToString(Date date) 根据时间变量返回时间字符串 yyyy-MM-dd dateToString(java.sql.Date
	 * date) 根据时间变量返回时间字符串 yyyy-MM-dd dateToString(java.sql.Timestamp date)
	 * 根据时间变量返回时间字符串 yyyy-MM-dd dateToStringDDMMYYYY(java.sql.Timestamp date)
	 * 根据时间变量返回时间字符串 dd.MM.yyyy datetoString(java.sql.Timestamp date) 根据时间变量返回时间字符串
	 * yyyy-MM-dd HH:mm:ss datetostring(java.sql.Timestamp date) 根据时间变量返回时间字符串
	 * yyyy-MM-dd HH:mm dateToString(java.sql.Timestamp date, boolean time)
	 * 根据时间变量返回时间字符串 yyyy-MM-dd HH:mm:ss / yyyy-MM-dd stringToDate(String
	 * dateString) 字符串转换为日期java.util.Date stringToDate(String dateText, String
	 * format,boolean lenient) 字符串转换为日期java.util.Date dateToString(Date date, String
	 * pattern) 根据时间变量返回时间字符串 dateNoGMTToString(Date date, String pattern) 日期范围函数组
	 * getBeginOfThisWeek(Date today) 取得本周的开始时间 getEndOfThisWeek(Date today)
	 * 取得本周的结束时间 getBeginOfLastWeek(Date today) 取得上周的开始时间 getEndOfLastWeek(Date
	 * today) 取得上周的结束时间 getBeginOfNextWeek(Date today) 取得下周的开始时间
	 * getEndOfNextWeek(Date today) 取得下周的结束时间 getBeginOfThisMonth(Date today)
	 * 取得本月的开始时间 getEndOfThisMonth(Date today) 取得本月的结束时间 getBeginOfLastMonth(Date
	 * today) 取得上月的开始时间 getEndOfLastMonth(Date today) 取得上月的结束时间
	 * getBeginOfNextMonth(Date today) 取得下月的开始时间 getEndOfNextMonth(Date today)
	 * 取得下月的结束时间 getBeginOfThisYear() 取得今年的开始时间 getEndOfThisYear() 取得今年的结束时间
	 * getBeginOfLastYear() 取得去年的开始时间 getEndOfLastYear() 取得去年的结束时间
	 * getBeginOfNextYear() 取得明年的开始时间 getEndOfNextYear() 取得明年的结束时间
	 * getBeginOfYesterday() 取得昨天的开始时间 getEndOfYesterday() 取得昨天的结束时间
	 * getBeginOfTomorrow() 取得明天的开始时间 getEndOfTomorrow() 取得明天的结束时间
	 * getCurrentDateString(String pattern) 返回当前日期字符串 getCurrentDateTime() 返回当前时间
	 * getHASPDateString(String haspDate) Hasp专用去时间 getDelayHour(String sCurDate,
	 * String range) 小时增加函数 minuteMove(String sCurDate, int iMinute) 分钟增减函数
	 * hourMove(String sCurDate, int iHour) 小时增减函数 hourEquals(String sCurDate, int
	 * iHour) 小时等于 daysRange(String sCurDate, String sEndDate) 传入开始日期，结束日期，获得日期所得日期
	 * validateDate(String sDate) 返回验证后的日期的值 validateDateTime(String sDateTime)
	 * 返回验证后的日期时间的值 isValidateDate(String sDate) 验证是否是日期 isValidateDateTime(String
	 * sDateTime) 验证是否是日期时间 isValidateLongDate(String sDate) 验证是否是日期时间
	 * getBeginDateOfWeek(String strDate) 取得带入日期所在周的第一天 getEndDateOfWeek(String
	 * strDate) 取得带入日期所在周的最后一天 getBeginDateOfYear(String strDate) 取得带入日期所在年的第一天
	 * getEndDateOfYear(String strDate) 取得带入日期所在年的最后一天 dateIncreaseByMonth(Date
	 * date, int mnt) 日期增加-按月增加 MonthMove(String startDate, int monthNum)
	 * 按照输入日期，取得增减月的日期 QuarterMove(String startDate, int quarterNum)
	 * 按照输入日期，取得增减季度的日期 getQuarterBegin(String startDate) 取得季度开始时间
	 * getQuarterEnd(String startDate) 取得季度结束时间 HalfYearMove(String startDate, int
	 * halfYearNum) 按照输入日期，取得增减半年的日期 getHalfYearEnd(String startDate) 获取半年底日期
	 * getDayOfDateTime(String strDate) 按照输入的日期时间，取得日期 getHourOfDateTime(String
	 * strDate) 按照输入的日期时间，取得小时 getMinOfDateTime(String strDate) 按照输入的日期时间，取得分钟
	 * getDistance(Date startTime, Date endTime) 取得两个时间间隔的分钟 getDate(String
	 * strDateTime) 输入String 获得时间 getInterval(String date1, String date2)
	 * 取得两个时间间隔的分钟 addTime(java.util.Date date, int amount,int field) 针对一个日期时间，加减时间
	 * getPassDateTime(String strDateTime, int iAmount,int field)针对一个日期时间，加减时间，返回字符
	 * getBeginDateTimeFromDate(String strDate) 带入日期，返回00:00:00日期+时间
	 * getEndDateTimeFromDate(String strDate) 带入日期，返回23:59:59日期+时间
	 * getBeginDateTimeSQLFromDate(String strDate) 带入日期，返回'00:00:00日期+时间'
	 * getEndDateTimeSQLFromDate(String strDate) 带入日期，返回'23:59:59日期+时间'
	 * isDateBefore(String date1, String date2) 判断时间date1是否在时间date2之前
	 * isDateBefore(String date2) 判断时间date1是否在当前时间之前 beginOfYear(int iYear)
	 * 取得该年的一月一日 endOfYear(int iYear) 取得该年的12月31日 getDateTime(int iYear, int iMonth,
	 * int iDay,int iHour, int iMinute, int iSecond) 取得日期时间
	 * getDateFormDateTime(String strDateTime) 根据传入的datetime取得date
	 * getTimeFormDateTime(String strDateTime) 根据传入的datetime取得Time
	 * convterSqlData(java.util.Date date) 转化不同时间类型 getCurLongDateTimestamp() 获得时间
	 * getTimestamp(java.sql.Timestamp timestamp) 获得时间
	 * getCreateTime(java.sql.Timestamp timestamp) 获得时间
	 * haveTimestamp(java.sql.Timestamp timestamp) 获得时间
	 * convterUtilData(java.sql.Date date) 转化不同时间类型 getDataAryValue(java.sql.Date[]
	 * date, int index) 从date数组中取值 getDataAryValue(java.sql.Timestamp[] date,int
	 * index) 从date数组中取值 getYear(java.util.Date date) 从当前日期中获得年份
	 * getTwoDigitYear(java.util.Date date) 从当前日期中获得双位年份 getMonth(java.util.Date
	 * date) 从当前日期中获得月份 dateCompare(java.sql.Timestamp timestamp1,java.sql.Timestamp
	 * timestamp2) 日期比较 isValidateYear(String sYear) 验证年 isValidateMonth(String
	 * sMonth) 验证月 getDateByYearAndMonth(String sYear, String sMonth) 一年一个月的时间
	 * stringToTimestamp(String timestampStr) 将字符串转为Timestamp getListByYear(String
	 * year) 通过年份获得整年的月首和月末日期 getAllListByYear(String year) 一年中的所有列表
	 * getCurDateTime() 获得当前的日期时间 getTimeMillis()取当前的毫秒 getTimeMillis(int
	 * length)取当前的毫秒返回固定长度
	 */

	public static final String TIMEZONE_GMT = "GMT+8";
	// public static final String TIMEZONE_GMT = "GMT";

	public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";

	public static final String ISO_EXPANDED_DATE_FORMAT_DDMMYYYY = "dd.MM.yyyy";

	public static final String ISO_EXPANDED_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String ISO_EXPANDED_DATETIME = "yyyy-MM-dd HH:mm";

	public static final String ISO_EXPANDED_HHmmDATETIME = "HH:mm";

	public static final String ISO_EXPANDED_HHmmssDATETIME = "HH:mm:ss";

	private static boolean LENIENT_DATE = false;

	public static String[] TIME_RANGE_VALUES = { "all", "today", "yesterday", "tomorrow", "thisweek", "lastweek",
			"nextweek", "thismonth", "lastmonth", "nextmonth", "thisyear", "lastyear", "nextyear", "was", "will" };

	private static final String SFA_DATE_VALUES[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };

	public static String[] HOUR_RANGE_VALUES = { "none", "halfhour", "onehour", "threehour", "fivehour", "oneday",
			"oneweek", "onemonth" };

	// @SuppressWarnings("unchecked")
	// private static ThreadLocal datetimeThreadLocal = new ThreadLocal() {
	// protected synchronized Object initialValue() {
	// SimpleDateFormat sdf = new SimpleDateFormat(
	// ISO_EXPANDED_DATETIME_FORMAT);
	// sdf.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
	// return sdf;
	// }
	// };
	// @SuppressWarnings("unchecked")
	// private static ThreadLocal dateThreadLocal = new ThreadLocal() {
	// protected synchronized Object initialValue() {
	// SimpleDateFormat sdf = new SimpleDateFormat(
	// ISO_EXPANDED_DATE_FORMAT);
	// sdf.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
	// return sdf;
	// }
	// };

	// /**
	// * 获得DateFormat对象，由于创建该对象实例开销比较大 线程不安全 所以采用线程安全静态变量
	// *
	// * @return
	// */
	// public static DateFormat getDateTimeFormat() {
	// return (DateFormat) datetimeThreadLocal.get();
	// }
	//
	// public static DateFormat getDateFormat() {
	// return (DateFormat) dateThreadLocal.get();
	// }
	//
	// public static Date parse(String textDate) throws ParseException {
	// return getDateTimeFormat().parse(textDate);
	// }
	/**
	 * 根据时间变量返回时间字符串 YY年MM月dd日 12:00
	 *
	 * @param date
	 * @return
	 */

	public static String dateToStringYYMMDDHHMM(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		SimpleDateFormat sdf = new SimpleDateFormat(ISO_EXPANDED_HHmmDATETIME);
		return (c.get(Calendar.YEAR)) + "年" + (c.get(Calendar.MONTH) + 1) + "月" + (c.get(Calendar.DAY_OF_MONTH)) + "日 "
				+ sdf.format(date);
	}

	/**
	 * 根据时间变量返回时间字符串 YY年MM月dd日 12:00
	 *
	 * @param date
	 * @return
	 */

	public static String dateToStringYYMMDDHHMMSS(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		SimpleDateFormat sdf = new SimpleDateFormat(ISO_EXPANDED_HHmmssDATETIME);
		return (c.get(Calendar.YEAR)) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + (c.get(Calendar.DAY_OF_MONTH)) + " "
				+ sdf.format(date);
	}
	/**
	 * 根据时间变量返回时间字符串 YYYY年MM月dd日 12:00
	 *
	 * @param date
	 * @return
	 */

	public static String dateToStringYYYYMMDDHHMMSS(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		SimpleDateFormat sdf = new SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);
		return (c.get(Calendar.YEAR)) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + (c.get(Calendar.DAY_OF_MONTH)) + " "
				+ sdf.format(date);
	}	

	/**
	 * 根据时间变量返回时间字符串 YY年MM月dd日
	 *
	 * @param date
	 * @return
	 */

	public static String dateToStringYYMMDD(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return (c.get(Calendar.YEAR)) + "年" + (c.get(Calendar.MONTH) + 1) + "月" + (c.get(Calendar.DAY_OF_MONTH)) + "日";
	}

	/**
	 * 根据时间变量返回时间字符串 YY年MM月dd日 12:00
	 *
	 * @param date
	 * @return
	 */
	public static String dateToStringMMDD(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return (c.get(Calendar.MONTH) + 1) + "月" + (c.get(Calendar.DAY_OF_MONTH)) + "日 ";
	}

	/**
	 * 根据时间变量返回时间字符串 MM月dd日 27/5
	 *
	 * @param date
	 * @return
	 */
	public static String dateToStringMMdd(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		return (c.get(Calendar.DAY_OF_MONTH)) + "/" + (c.get(Calendar.MONTH) + 1) + "月";
	}

	/**
	 * 根据时间变量返回时间字符串HH:mm:ss
	 *
	 * @param date
	 * @return
	 */
	public static String datetoHHmmssstring(Timestamp date) {
		if (date == null) {
			return "";
		}
		Date udate = new Date(date.getTime());
		return dateNoGMTToString(udate, ISO_EXPANDED_HHmmssDATETIME);
	}

	/**
	 * 根据时间变量返回时间字符串HH:mm:
	 *
	 * @param date
	 * @return
	 */
	public static String datetoHHmmstring(Timestamp date) {
		if (date == null) {
			return "";
		}
		Date udate = new Date(date.getTime());
		return dateNoGMTToString(udate, ISO_EXPANDED_HHmmDATETIME);
	}

	/**
	 * 字符串转换为日期java.util.Date
	 *
	 * @param dateText
	 *            字符串
	 */
	public static Date stringTodate(String dateString) {

		return stringToDate(dateString, ISO_EXPANDED_DATETIME_FORMAT, LENIENT_DATE);
	}

	public static String getTwoDateSubHh(String date) {
		String str = "";
		Date value = getCurLongDateTimestamp();

		Date two_value = stringTodate(date);
		long sub = value.getTime() - two_value.getTime();
		// System.out.println(sub);

		long temp = sub / (60 * 60 * 1000);
		// System.out.println(temp);

		if (temp == 0) {
			sub = sub / (60 * 1000);// 分钟
			// if(sub>=0&&sub<=30){
			// str = "小于30分钟";
			// }else if(sub>30&&sub<=60){
			// str = "大于于30分钟";
			// }
			str = "1个小时内";
		} else {
			sub = temp;
			str = temp + "个小时前";
			if (sub > 24) {
				long days = sub / 24;
				str = days + "天前";
			}
		}
		return str;
	}

	/**
	 * 测试
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {

		String s2 = dateTimeMove("2016-11-03 15:14:00", 2);
		System.out.println((s2));
		System.out.println(
				DateUtil.string2Time(DateUtil.dateMove(DateUtil.datetoString(DateUtil.getCurLongDateTimestamp()), 7)));
		// System.out.println(DateUtil.dateMove(DateUtil
		// .datetoHHmmssstring(DateUtil.getCurLongDateTimestamp()), 2));
		// System.out.println(DateUtil.stringToTimestamp(DateUtil.dateMove(
		// DateUtil.datetoHHmmssstring(DateUtil
		// .getCurLongDateTimestamp()), 2)));

		System.out.println("年" + getYear(dateToString(new Date())));
		System.out.println("月" + getMonth(dateToString(new Date())));
		System.out.println("日" + getDay(dateToString(new Date())));

		System.out.println(dateToStringToYYMMDD(getCurLongDateTimestamp()));

		try {
			System.out.println(getTwoDateSubHh("2016-05-24 11:50:00"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(datetoHHmmstring(getCurLongDateTimestamp()));
		System.out.println(getTimeMillis());
		System.out.println(getTimeMillis(10));

		System.out.println(daySubMoreOne("2015-10-10", "2015-11-30"));

		String s1 = getCurMonth();
		System.out.println((s1));
		System.out.println(getCurDate());
		System.out.println(getCurTime());
		String s3 = weekMove("2012-10-10", 1);
		System.out.println((s3));
		String s18 = getIntMonth("2015-11-27");
		System.out.println((s18));

		List<String[]> list = getListByYear("2012");
		for (String[] s : list) {
			System.out.println(s[0] + "____" + s[1]);
		}

		// System.out.println("====" + DateUtil.hourSub("2011-03-01"));
		// System.out.println("====");
		// System.out.println(getTwoDigitYear(new java.util.Date()));
		// System.out.println("====");
		// System.out.println("====" + DateUtil.getDay("2011-03-01"));
		// System.out.println("====" + getWeekDay("2011-03-01"));
		// System.out.println(getCurDate());
		// System.out.println(getDayTimeCurDate());
		// System.out.println(getCurLongDate());
		// System.out.println(getCurrentDateTime());
		// System.out.println(getCurrentDateString(ISO_EXPANDED_DATETIME_FORMAT));
		// System.out.println(Integer.parseInt("09"));

		// System.out.println(DateUtil.MonthMove(DateUtil.getCurDate(), 3));

		// Calendar nowDay=Calendar.getInstance();
		// nowDay.setTime(databaseTime);
		// boolean flag = isDateBefore("2004-09-09 12:12:12",
		// "2005-09-09 16:00:00");
		// System.out.println(flag);
		// flag = isDateBefore("2006-09-09 01:01:01", "2005-09-09 16:00:00");
		// System.out.println(flag);
		//
		// System.out.println(dateToString(addTime(
		// getDayTimeFromString("2008-12-12 01:01:01"), 10,
		// Calendar.MINUTE), ISO_EXPANDED_DATETIME_FORMAT));
		//
		// String xxxx = "2006-09-09 01:01:01";
		// System.out.println("--->getDateFormDateTime-->"+getDateFormDateTime(xxxx)+"---<");
		// System.out.println("--->getTimeFormDateTime-->"+getTimeFormDateTime(xxxx)+"---<");

		// System.out.println(getInterval("2009-01-02 11:01:02",
		// "2009-01-02 16:12:02"));

		// System.out.println(getHASPDateString("1234567890"));

		// String month = SystemDate.MonthMove(SystemDate
		// .getCurDate(), 1);
		// System.out.println(month);
		// String beginDate = SystemDate.getBeginDateOfMonth((month)) + "
		// 00:00:00";
		// String endDate = SystemDate.getEndDateOfMonth((month)) + " 23:59:59
		// ";
		//
		// System.out.println(beginDate+"---"+endDate);
		// String day = "2009-02-28";
		// int moveDateNum = SystemDate.getNumOfMonth(SystemDate.MonthMove(day,
		// -1), SystemDate.getMonth(SystemDate.MonthMove(day, 0)));

		// System.out.println(moveDateNum+"---"+moveDateNum);

		// System.out.println(MonthMove("2009-02-12", -7));
		// System.out.println(getDayTimeFromString("2007-08-01 09:01:01"));

		// "all", "today", "yesterday", "tomorrow", "thisweek", "lastweek",
		// "nextweek", "thismonth", "lastmonth", "nextmonth", "thisyear",
		// "lastyear", "nextyear"

		// LinkedList list = daysRange("2011-02-26", "2011-03-22");
		// for (int i = 0; i < list.size(); i++) {
		// String s = (String) list.get(i);
		// System.out.println(s);
		// }

		// System.out.println(getBeginDate("all") + "------------"
		// + getEndDate("all"));
		// System.out.println(getBeginDate("today") + "------------"
		// + getEndDate("today"));
		// System.out.println(getBeginDate("yesterday") + "------------"
		// + getEndDate("yesterday"));
		// System.out.println(getBeginDate("tomorrow") + "------------"
		// + getEndDate("tomorrow"));
		// System.out.println(getBeginDate("thisweek") + "------------"
		// + getEndDate("thisweek"));
		// System.out.println(getBeginDate("lastweek") + "------------"
		// + getEndDate("lastweek"));
		// System.out.println(getBeginDate("nextweek") + "------------"
		// + getEndDate("nextweek"));
		// System.out.println(getBeginDate("thismonth") + "------------"
		// + getEndDate("thismonth"));
		// System.out.println(getBeginDate("lastmonth") + "------------"
		// + getEndDate("lastmonth"));
		// System.out.println(getBeginDate("nextmonth") + "------------"
		// + getEndDate("nextmonth"));
		// System.out.println(getBeginDate("thisyear") + "------------"
		// + getEndDate("thisyear"));
		// System.out.println(getBeginDate("lastyear") + "------------"
		// + getEndDate("lastyear"));
		// System.out.println(getBeginDate("nextyear") + "------------"
		// + getEndDate("nextyear"));
		//
		// System.out.println(dayRange("2007-10-01", SystemDate.getCurDate()));
		//
		// System.out.println(SystemDate.getCurTime());
		// System.out.println(getDayOfDateTime(SystemDate.getCurLongDate()));
		// System.out.println(getHourOfDateTime(SystemDate.getCurLongDate()));
		// System.out.println(getMinOfDateTime(SystemDate.getCurLongDate()));

		// SystemDate st = new SystemDate();
		// System.out.println(MonthMove("2002-3-31", 1));

		// LinkedList list = weekRangeList("2006-3-1", "2006-4-1");
		// System.out.println(dayAfterNum("2006-3-1",11));

		// System.out.println("xxxxxxxxxxxxxxxxxxxx");
		// System.out.println(getBeginDate("all"));
		// System.out.println(getEndDate("all"));
		// System.out.println("xxxxxxxxxxxxxxxxxxxx");
		// int s1 = dateComp("2006-5-1", "2006-4-1");
		// System.out.println((s1));
		//
		// String s2 = dateMove("2006-5-1", 78);
		// System.out.println((s2));
		//
		// long s3 = daySub("2006-3-1", "2006-4-1");
		// System.out.println((s3));
		//
		// String s4 = getCurDate();
		// System.out.println((s4));
		//
		// String s5 = getCurDay();
		// System.out.println((s5));
		//
		// String s6 = getCurLongDate();
		// System.out.println((s6));
		//
		// String s7 = getCurMonth();
		// System.out.println((s7));
		//
		// String s8 = getCurTime();
		// System.out.println((s8));
		//
		// int s9 = getCurWeekDay();
		// System.out.println((s9));
		//
		// String s10 = getCurYear();
		// System.out.println((s10));
		//
		// String s11 = getDay("2007-03-24");
		// System.out.println((s11));
		//
		// String s12 = getEndDateOfMonth("2007-03-24");
		// System.out.println((s12));
		//
		// String s13 = getLocalCurDate();
		// System.out.println((s13));
		//
		// String s14 = getLocalCurWeekDay();
		// System.out.println((s14));
		//
		// String s15 = getLocalDate("2007-02-25");
		// System.out.println((s15));
		//
		// String s16 = getLocalWeekDay("2007-02-25");
		// System.out.println((s16));
		//
		// String s17 = getMonth("2007-02-25");
		// System.out.println((s17));
		//
		// int s18 = getNumOfMonth("2007", "3");
		// System.out.println((s18));
		//
		// int s19 = getWeekDay("2007-08-23");
		// System.out.println((s19));
		//
		// String s20 = getYear("2007-08-23");
		// System.out.println((s20));
		//
		// boolean s21 = isDate("2007-13-09");
		// System.out.println((s21));
		//
		// boolean s22 = isRenYear("2001-02-05");
		// System.out.println((s22));
		//
		// LinkedList ll = monthRange("2007-02-04", "2007-08-19");
		// for (int i = 0; i < ll.size(); i++) {
		// String s = (String) ll.get(i);
		// System.out.println(s);
		// }
		//
		// LinkedList li = monthRangeCaption("2007-02-04", "2007-08-19");
		// for (int i = 0; i < li.size(); i++) {
		// String s = (String) li.get(i);
		// System.out.println(s);
		// }
		//
		// String s23 = MonthMove("2007-08-23", -3);
		// System.out.println((s23));
		//
		// String s24 = YearMove("2007-08-23", 3);
		// System.out.println((s24));
		//
		// boolean s25 = isSameWeekDates(new Date(2007, 01, 01), new Date(2006,
		// 12, 28));
		// System.out.println((s25));
		//
		// java.util.Date dd = new java.util.Date();
		// Date dt = new Date(dd.getTime());
		// String s26 = getSeqWeekCaption(dt);
		// System.out.println((s26));
		// String s27 = getSeqWeek(dt);
		// System.out.println((s27));
		// String s28 = getSunday(dt);
		// System.out.println((s28));
		// String s29 = getSaturday(dt);
		// System.out.println((s29));
		//
		// LinkedList l2 = weekRangeList("2007-02-04", "2007-08-19");
		// for (int i = 0; i < l2.size(); i++) {
		// weekValue sss = (weekValue) l2.get(i);
		// System.out.println(sss.getSBeginDate());
		// System.out.println(sss.getSEndDate());
		// System.out.println(sss.getSWeekCaption());
		// }
		//
		// int s30 = dayRange("2007-08-01", "2007-08-13");
		// System.out.println((s30));
		//
		// String s31 = dayAfterNum("2007-08-01", 13);
		// System.out.println((s31));
		//
		// System.out.println("=========================");
		// String a1 = getMonth("2007-08-01");
		// System.out.println((s31));

	}

	public DateUtil() {
	}

	/**
	 * 根据时间变量返回时间字符串 10/3月 ，3月10日格式
	 *
	 * @param date
	 * @return
	 */
	public static String dateToStringDDMM(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return (c.get(Calendar.DAY_OF_MONTH)) + "/ " + (c.get(Calendar.MONTH) + 1) + "月";
	}

	/**
	 * 日期相减得到小时 daySub("2005-09-29 21:00:00 ","2005-09-29 22:00:00") d1-d2 1
	 *
	 * @param Date1
	 * @param Date2
	 * @return
	 */
	public static double dateSubhour(String Date1, String Date2) {
		SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);
		double time = 0;
		try {
			Date start = (Date) format.parse(Date1);
			Date end = (Date) format.parse(Date2);
			double t = (end.getTime() - start.getTime()) / (1000 * 60);
			if (t % 60 == 0) {
				time = t / 60;
			} else {
				// 不足一小时按一小时计算
				time = t / 60 + 1;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Math.ceil(time);
	}

	/**
	 * 日期比较函数 d1比d2小 dateComp("2006-3-1", "2006-4-1")---> -1 d1比d2相同
	 * dateComp("2006-4-1", "2006-4-1")---> 0 d1比d2大 dateComp("2006-5-1",
	 * "2006-4-1")---> 1
	 *
	 * @param Date1
	 * @param Date2
	 * @return
	 *
	 */
	public static int dateComp(String Date1, String Date2) {
		if ((Date1 == null || Date1.trim().length() == 0) && (Date2 == null || Date2.trim().length() == 0))
			return 0;
		if (Date2 == null || Date2.trim().length() == 0)
			return 1;
		if (Date1 == null || Date1.trim().length() == 0)
			return -1;
		if (!isDate(Date1) || !isDate(Date2)) {
			return 0;
		} else {
			String sD1 = java.sql.Date.valueOf(Date1).toString();
			String sD2 = java.sql.Date.valueOf(Date2).toString();
			return sD1.compareTo(sD2);
		}
	}

	/**
	 * 日期比较函数 d1是否在dateBegin和dateEnd区间内
	 *
	 * @param date1
	 * @param dateBegin
	 * @param dateEnd
	 * @return
	 */
	public static boolean dateComp(String date1, String dateBegin, String dateEnd) {
		if ((date1 == null || date1.trim().length() == 0) || (dateBegin == null || dateBegin.trim().length() == 0)
				|| (dateEnd == null || dateEnd.trim().length() == 0))
			return false;
		if (!isDate(date1) || !isDate(dateBegin) || !isDate(dateEnd)) {
			return false;
		} else {
			String sD1 = java.sql.Date.valueOf(date1).toString();
			String sD2 = java.sql.Date.valueOf(dateBegin).toString();
			String sD3 = java.sql.Date.valueOf(dateEnd).toString();
			return (sD1.compareTo(sD2) >= 0) && (sD1.compareTo(sD3) <= 0);
		}
	}

	/**
	 * 日期增减函数 dateMove("2006-5-1", 78) 往后 -->2006-07-18 dateMove("2006-5-1", -78) 往前
	 * -->2006-02-12
	 *
	 * @param sCurDate
	 * @param iDays
	 * @return
	 */
	public static String dateMove(String sCurDate, int iDays) {
		if (sCurDate.length() > 10) {
			sCurDate = sCurDate.substring(0, sCurDate.indexOf(" "));
		}
		long lD = java.sql.Date.valueOf(sCurDate).getTime();

		long ll = 1L;
		ll = ll * (long) iDays * 24L * 3600L * 1000L;
		lD += ll;

		SimpleDateFormat sfDate = new SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);
		sfDate.setLenient(false);
		// sfDate.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		return sfDate.format(new Date(lD));
	}

	/**
	 * 周增减函数
	 *
	 * @param sCurDate
	 * @param iDays
	 * @return
	 */
	public static String weekMove(String sCurDate, int iDays) {
		if (sCurDate.length() > 10) {
			sCurDate = sCurDate.substring(0, sCurDate.indexOf(" "));
		}
		long lD = java.sql.Date.valueOf(sCurDate).getTime();

		long ll = 1L;
		ll = ll * (long) iDays * 24L * 3600L * 1000L * 7;
		lD += ll;

		SimpleDateFormat sfDate = new SimpleDateFormat(ISO_EXPANDED_DATE_FORMAT);
		sfDate.setLenient(false);
		// sfDate.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		return sfDate.format(new Date(lD));

	}

	/**
	 * 日期时间增减函数 输入时间 加减日期
	 *
	 * @param sCurDate
	 * @param iDays
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String dateTimeMove(String sCurDate, int iDays) {
		SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		Date date1;
		String mydate1 = "";
		try {
			date1 = format.parse(sCurDate);
			// date1.setHours(iHour);
			// date1.getYear();
			// date1.getMonth()
			date1.setDate(date1.getDate() + iDays);
			// iHour;
			// date1.setMinutes(0);
			// date1.setSeconds(0);

			mydate1 = format.format(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mydate1;

	}

	/**
	 * 日期相减函数 daySub("2006-3-1", "2006-4-1") d1-d2 -31 daySub("2006-5-1","2006-4-1")
	 * d1-d2 30
	 *
	 * @param Date1
	 * @param Date2
	 * @return
	 */

	public static long daySub(String Date1, String Date2) {
		// System.out.println(Date1.length());
		if (Date1.length() >= 10) {
			Date1 = Date1.substring(0, 10);
		}

		if (Date2.length() >= 10) {
			Date2 = Date2.substring(0, 10);
		}
		if (StringUtil.isValidateString(Date1)) {
			long lD1 = java.sql.Date.valueOf(Date1).getTime();
			long lD2 = java.sql.Date.valueOf(Date2).getTime();
			long ll = lD1 - lD2;
			ll /= 0x5265c00L;
			return ll;
		} else {
			return 0;
		}
	}

	/**
	 * 小时相减函数
	 *
	 * @param Date1
	 * @param Date2
	 * @return
	 */
	public static long hourSub(Timestamp Date1, Timestamp Date2) {

		if ((Date1 != null) && (Date2 != null)) {
			long lD1 = Date1.getTime();
			long lD2 = Date2.getTime();
			long ll = lD1 - lD2;
			return (int) (ll / (1000 * 60 * 60));
		} else {
			return 0;
		}
	}

	/**
	 * 日期相减函数
	 *
	 * @param Date1
	 * @param Date2
	 * @return
	 */
	public static long daySubMoreOne(String Date1, String Date2) {
		// System.out.println(Date1.length());
		if (Date1.length() >= 10) {
			Date1 = Date1.substring(0, 10);
		}

		if (Date2.length() >= 10) {
			Date2 = Date2.substring(0, 10);
		}
		if (StringUtil.isValidateString(Date1)) {
			long lD1 = java.sql.Date.valueOf(Date1).getTime();
			long lD2 = java.sql.Date.valueOf(Date2).getTime();
			long ll = lD1 - lD2;
			ll /= 0x5265c00L;
			return ll + 1;
		} else {
			return 0 + 1;
		}
	}

	/**
	 * 获得当前日期
	 *
	 * @return
	 */
	public static String getCurDate() {
		Date dd = new Date();
		return dateToString(dd);
		// java.util.Calendar dd = java.util.Calendar.getInstance();
		// Date dt = new Date(dd.getTime());
		// return dd.getTime().toString();
	}

	/**
	 * 获得当前日期时间
	 *
	 * @return
	 */
	public static String getDayTimeCurDate() {
		Date dd = new Date();
		SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		return format.format(dd);
		// java.util.Calendar dd = java.util.Calendar.getInstance();
		// Date dt = new Date(dd.getTime());
		// return dd.getTime().toString();
	}

	/**
	 * 获得当前日
	 *
	 * @return
	 */
	public static String getCurDay() {
		String s = getCurDate();
		return s.substring(s.lastIndexOf("-") + 1);
	}

	/**
	 * 获得当前时长日期格式
	 *
	 * @return
	 */
	public static String getCurLongDate() {
		return getDayTimeCurDate();
	}

	/**
	 * 获得当前月(字符)
	 *
	 * @return
	 */
	public static String getCurMonth() {
		String s = getCurDate();
		int iB = s.indexOf("-");
		return s.substring(iB + 1, s.indexOf("-", iB + 1));
	}

	/**
	 * 获得当前月(整型)
	 *
	 * @return
	 */
	public static int getIntCurMonth() {
		return Integer.parseInt(getCurMonth());
	}

	/**
	 * 获得当前时间
	 *
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String getCurTime() {

		String strHour = new Date().getHours() < 10 ? "0" + String.valueOf(new Date().getHours())
				: String.valueOf(new Date().getHours());
		String strMinutes = new Date().getMinutes() < 10 ? "0" + String.valueOf(new Date().getMinutes())
				: String.valueOf(new Date().getMinutes());
		String strSeconds = new Date().getSeconds() < 10 ? "0" + String.valueOf(new Date().getSeconds())
				: String.valueOf(new Date().getSeconds());
		String st = strHour + ":" + strMinutes + ":" + strSeconds;
		// int iB = st.indexOf(":");
		// return st.substring(iB - 2, iB + 6);
		return st;
	}

	/**
	 * 获得当前日对应的星期几
	 *
	 * @return
	 */
	public static int getCurWeekDay() {
		String sCurDay = getCurDate();
		String sDay = "1000-01-07";
		return Integer.parseInt(daySub(sCurDay, sDay) % 7L + "");
	}

	/**
	 * 获得当前年
	 *
	 * @return
	 */
	public static String getCurYear() {
		String s = getCurDate();
		return s.substring(0, s.indexOf("-"));
	}

	/**
	 * 根据传入的日期，获得对应日
	 *
	 * @param sdate
	 * @return
	 */
	public static String getDay(String sdate) {
		try {
			Date dt = java.sql.Date.valueOf(sdate);
			return dt.toString().substring(8);
		} catch (Exception _ex) {
			return "0";
		}
	}

	/**
	 * 根据传入的字符，获得对应日期
	 *
	 * @param sdate
	 * @return
	 */
	public static Date getDayFromString(String sdate) {
		Date dt = java.sql.Date.valueOf(sdate);
		Date returnDate = new Date(dt.getTime());
		try {
			SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATE_FORMAT);
			format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
			returnDate = format.parse(sdate);
		} catch (Exception _ex) {
			return returnDate;
		}
		return returnDate;
	}

	/**
	 * 根据传入的字符，获得对应日期/时间
	 *
	 * @param sDateTime
	 * @return
	 */
	public static Date getDayTimeFromString(String sDateTime) {
		SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		Date date1 = null;

		try {
			date1 = format.parse(sDateTime);
		} catch (Exception _ex) {
			return date1;
		}
		return date1;
	}

	/*
	 * 根据传入的字符，获得对应日期/时间
	 */
	// public static Date getDayTimeFromString(java.util.Date date) {
	// SimpleDateFormat sdformat = new SimpleDateFormat(
	// ISO_EXPANDED_DATETIME_FORMAT);
	// sdformat.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
	// java.util.Date date1 = null;
	//
	// try {
	// date1 = sdformat.(date);
	// } catch (Exception _ex) {
	// return date1;
	// }
	// return date1;
	// }
	/**
	 * 获得传入日期的月头日 getBeginDateOfMonth("2007-03-24") ----> 2007-03-01
	 */
	public static String getBeginDateOfMonth(String strDate) {
		strDate = strDate.substring(0, 7) + "-" + "01";
		return strDate;
	}

	/**
	 * 获得传入日期的月末日 getEndDateOfMonth("2007-03-24") ----> 2007-03-31
	 *
	 * @param strDate
	 * @return
	 */
	public static String getEndDateOfMonth(String strDate) {
		int iD = 30;
		int iM = StringUtil.str2int(strDate.substring(5, 7));
		if (iM == 1 || iM == 3 || iM == 5 || iM == 7 || iM == 8 || iM == 10 || iM == 12)
			iD = 31;
		else if (iM == 4 || iM == 6 || iM == 9 || iM == 11)
			iD = 30;
		else if (iM == 2)
			if (isRenYear(strDate))
				iD = 29;
			else
				iD = 28;
		strDate = strDate.substring(0, 7) + "-" + iD;
		return strDate;
	}

	/**
	 * 获得本地当前日期 2007年08月23日
	 *
	 * @return
	 */
	public static String getLocalCurDate() {
		String sData = getCurDate();
		return getYear(sData) + "年" + getStrMonth(sData) + "月" + getDay(sData) + "日";
	}

	/**
	 * 获得本地当前日对应的星期几
	 *
	 * @return
	 */
	public static String getLocalCurWeekDay() {
		int iDay = getCurWeekDay();
		String sLocalDay = "";
		if (iDay == 0)
			sLocalDay = "日";
		else if (iDay == 1)
			sLocalDay = "一";
		else if (iDay == 2)
			sLocalDay = "二";
		else if (iDay == 3)
			sLocalDay = "三";
		else if (iDay == 4)
			sLocalDay = "四";
		else if (iDay == 5)
			sLocalDay = "五";
		else if (iDay == 6)
			sLocalDay = "六";
		return "星期" + sLocalDay;
	}

	/**
	 * 根据输入的日期串生成标准日期格式 getLocalDate("2007-02-25") --> 2007年02月25日
	 *
	 * @param sDate
	 * @return
	 */
	public static String getLocalDate(String sDate) {
		return getYear(sDate) + "年" + getStrMonth(sDate) + "月" + getDay(sDate) + "日";
	}

	/**
	 * 根据传入的日期获得日的星期 getLocalWeekDay("2007-02-25")---->星期日
	 *
	 * @param sDate
	 * @return
	 */
	public static String getLocalWeekDay(String sDate) {
		int iDay = getWeekDay(sDate);
		String sLocalDay = "";
		if (iDay == 0)
			sLocalDay = "日";
		else if (iDay == 1)
			sLocalDay = "一";
		else if (iDay == 2)
			sLocalDay = "二";
		else if (iDay == 3)
			sLocalDay = "三";
		else if (iDay == 4)
			sLocalDay = "四";
		else if (iDay == 5)
			sLocalDay = "五";
		else if (iDay == 6)
			sLocalDay = "六";
		return "周" + sLocalDay;
	}

	/**
	 * 根据传入的日期获得日的星期 getLocalWeekDay(0)---->星期日
	 *
	 * @param inputFlag
	 * @param iDate
	 * @return
	 */
	private static String getPrivateLocalWeekDay(String inputFlag, int iDate) {

		String sLocalDay = "";
		if (iDate == 0)
			sLocalDay = "日";
		else if (iDate == 1)
			sLocalDay = "一";
		else if (iDate == 2)
			sLocalDay = "二";
		else if (iDate == 3)
			sLocalDay = "三";
		else if (iDate == 4)
			sLocalDay = "四";
		else if (iDate == 5)
			sLocalDay = "五";
		else if (iDate == 6)
			sLocalDay = "六";
		return inputFlag + sLocalDay;
	}

	/**
	 * 根据传入的日期获得日的星期 getLocalWeekDay(0)---->星期日
	 *
	 * @param iDate
	 * @return
	 */
	public static String getLocalWeekDay(int iDate) {
		return getPrivateLocalWeekDay("", iDate);
	}

	/**
	 * 根据传入的日期获得日的星期 getLocalWeekDay(0)---->星期日
	 *
	 * @param iDate
	 * @return
	 */
	public static String getLongLocalWeekDay(int iDate) {
		return getPrivateLocalWeekDay("周", iDate);
	}

	/**
	 * 获得传入日期的月 getMonth("2007-02-25");---->02
	 *
	 * @param sdate
	 * @return
	 */
	public static String getStrDate(String sdate, String pattern) {
		try {

			SimpleDateFormat sDateFormat = new SimpleDateFormat(pattern); // 加上时间
			// 必须捕获异常
			Date dt = sDateFormat.parse(sdate);

			return dateToString(dt, pattern);
		} catch (Exception _ex) {
			return "";
		}
	}
	
	public static String getStrDate(String sdate, String fromPattern, String toPattern) {
		try {

			SimpleDateFormat sDateFormat = new SimpleDateFormat(fromPattern); // 加上时间
			
			Date date = sDateFormat.parse(sdate);
			
			SimpleDateFormat sdf2 = new SimpleDateFormat(toPattern);
			String str = sdf2.format(date);			
			return str;
		} catch (Exception _ex) {
			return "";
		}
	}	

	/**
	 * 获得传入日期的月 getMonth("2007-02-25");---->02
	 *
	 * @param sdate
	 * @return
	 */
	public static String getStrMonth(String sdate) {
		try {
			Date dt = java.sql.Date.valueOf(sdate);
			return dt.toString().substring(5, 7);
		} catch (Exception _ex) {
			return "0";
		}
	}

	/**
	 * 获得传入日期的月
	 *
	 * @param sdate
	 * @return
	 */
	public static String getMonth(String sdate) {
		// try {
		// Date dt = java.sql.Date.valueOf(sdate);
		// int month = StringUtil.str2int(dt.toString().substring(5, 7));
		// return String.valueOf(month);
		// } catch (Exception _ex) {
		// return "0";
		// }
		try {
			Date dt = java.sql.Date.valueOf(sdate);
			return dt.toString().substring(5, 7);
		} catch (Exception _ex) {
			return "0";
		}
	}

	/**
	 *
	 * @param sdate
	 * @return
	 */
	public static String getIntMonth(String sdate) {
		try {
			return String.valueOf(StringUtil.str2int(sdate));
		} catch (Exception _ex) {
			return "0";
		}
	}

	/**
	 * 获得？年？月的天数 getNumOfMonth("2007","3")---->31
	 *
	 * @param sDate
	 * @param sMonth
	 * @return
	 */
	public static int getNumOfMonth(String sDate, String sMonth) {
		if (sMonth == null || sDate == null)
			return 0;
		int iYear = StringUtil.str2int(sDate);
		if (sMonth.equals("01") || sMonth.equals("03") || sMonth.equals("05") || sMonth.equals("07")
				|| sMonth.equals("08") || sMonth.equals("10") || sMonth.equals("12"))
			return 31;
		if (sMonth.equals("04") || sMonth.equals("06") || sMonth.equals("09") || sMonth.equals("11"))
			return 30;
		if (iYear % 4 == 0)
			return iYear % 100 == 0 || iYear % 400 != 0 ? 28 : 29;
		else
			return 28;
	}

	/**
	 * 得到传入日期的星期几 getWeekDay("2007-08-23");--->4
	 *
	 * @param sDate
	 * @return
	 */
	public static int getWeekDay(String sDate) {
		String sDay = "1000-01-07";
		return Integer.parseInt(daySub(sDate, sDay) % 7L + "");
	}

	/**
	 * 得到传入日期的年份 getYear("2007-08-23");---->2007
	 *
	 * @param sdate
	 * @return
	 */
	public static String getYear(String sdate) {
		try {
			Date dt = java.sql.Date.valueOf(sdate);
			return dt.toString().substring(0, 4);
		} catch (Exception _ex) {
			return "0";
		}
	}

	/**
	 * 判断传入的日期是否为正确的日期格式 isDate("2007-13-09");----false 传入的格式为"年-月-日"
	 *
	 * @param strDate
	 * @return
	 */
	public static boolean isDate(String strDate) {
		try {
			if (strDate == null || strDate.trim().length() == 0)
				return false;
			if (strDate.indexOf(":") != -1) {
				int iB = strDate.indexOf(":");
				String st = strDate.substring(iB - 2, iB + 6);
				int iH = Integer.parseInt(st.substring(0, 2));
				int iM = Integer.parseInt(st.substring(3, 5));
				int iS = Integer.parseInt(st.substring(6, 8));
				if (iH > 23 || iM > 59 || iS > 59)
					return false;
				String sd = strDate.substring(0, iB - 3);
				java.sql.Date.valueOf(sd.trim());
			} else {
				java.sql.Date.valueOf(strDate);
			}
			String sdate = strDate;
			int index = sdate.indexOf("-");
			if (index == -1)
				return false;
			String sY = sdate.substring(0, index);
			if (sY.length() != 4)
				return false;
			int index1 = sdate.indexOf("-", index + 1);
			if (index1 == -1)
				return false;
			String sM = sdate.substring(index + 1, index1);
			String sD = "";
			sD = sdate.substring(index1 + 1);
			int iM = StringUtil.str2int(sM);
			int iD = StringUtil.str2int(sD);
			if (iM > 12 || iM <= 0 || iD <= 0)
				return false;
			if (iM == 1 || iM == 3 || iM == 5 || iM == 7 || iM == 8 || iM == 10 || iM == 12) {
				if (iD > 31)
					return false;
			} else if (iM == 4 || iM == 6 || iM == 9 || iM == 11) {
				if (iD > 30)
					return false;
			} else if (iM == 2)
				if (isRenYear(strDate)) {
					if (iD > 29)
						return false;
				} else if (iD > 28)
					return false;
			return true;
		} catch (Exception _ex) {
			return false;
		}
	}

	/**
	 * 判断年是否为润年 isRenYear("2001-02-05");---false isRenYear("2000-02-05");---true
	 *
	 * @param sDate
	 * @return
	 */
	public static boolean isRenYear(String sDate) {
		try {
			String s = java.sql.Date.valueOf(sDate).toString();
			int iYear = StringUtil.str2int(s.substring(0, 4));
			return (iYear % 4 == 0 && iYear % 100 != 0) || iYear % 400 == 0;
		} catch (Exception _ex) {
			return false;
		}
	}

	/**
	 * 传入开始日期，结束日期，获得日期中的月份 LinkedList ll = monthRange("2007-02-04","2007-08-19");
	 * 2007-02 2007-03 2007-04 2007-05 2007-06 2007-07 2007-08
	 *
	 * @param sCurDate
	 * @param sEndDate
	 * @return
	 */
	public static LinkedList<String> monthRange(String sCurDate, String sEndDate) {
		LinkedList<String> list = new LinkedList<String>();

		if (daySub(sCurDate, sEndDate) <= 0) {
			sCurDate = dateMove(sCurDate, 0);
			sEndDate = dateMove(sEndDate, 0);

			// String sBeginMon = getMonth(sCurDate);
			// String sEndMon = getMonth(sEndDate);

			String sFirstMon = getYear(sCurDate) + "-" + getStrMonth(sCurDate);
			String sFirstDay = sFirstMon + "-01";
			String sEndDay = getYear(sEndDate) + "-" + getStrMonth(sEndDate) + "-01";

			while ((daySub(sFirstDay, sEndDay) < 1)) {
				list = monthRangeList(list, sFirstDay);
				sFirstDay = dateMove(getEndDateOfMonth(sFirstDay), 1);
			}
		}
		return list;
	}

	/**
	 * 传入年份，获得日期中的月份
	 *
	 * @param year
	 * @return
	 */
	public static String[] monthRange(String year) {
		if (!StringUtil.isValidateString(year)) {
			return new String[] {};
		}
		year = StringUtil.validateString(year);
		if (year.length() != 4) {
			throw new IllegalArgumentException("The year is Eorror!");
		}
		String currdate = StringUtil.validateString(year) + "-01-01";
		String nextdate = (Integer.valueOf(year) + 1) + "-06-01";
		LinkedList<String> months = monthRange(currdate, nextdate);
		return (String[]) months.toArray(new String[18]);
	}

	/**
	 * 传入mlist，结束日期，获得日期中的月份
	 *
	 * @param mlist
	 * @param sCurDate
	 * @return
	 */
	private static LinkedList<String> monthRangeList(LinkedList<String> mlist, String sCurDate) {
		String sMon = getYear(sCurDate) + "-" + getStrMonth(sCurDate);
		mlist.add(sMon);
		return mlist;
	}

	/**
	 * 传入开始日期，结束日期，获得日期中的月份 LinkedList li =
	 * monthRangeCaption("2007-02-04","2007-08-19"); 2007年02月 2007年03月 2007年04月
	 * 2007年05月 2007年06月 2007年07月 2007年08月
	 *
	 * @param sCurDate
	 * @param sEndDate
	 * @return
	 */
	public static LinkedList<String> monthRangeCaption(String sCurDate, String sEndDate) {
		LinkedList<String> list = new LinkedList<String>();
		LinkedList<String> mlist = monthRange(sCurDate, sEndDate);

		for (int i = 0; i < mlist.size(); i++) {
			String sTemp = (String) mlist.get(i);
			sTemp = sTemp.replaceAll("-", "年") + "月";
			list.add(sTemp);
		}

		return list;
	}

	/*
	 * 月的增加减少 MonthMove("2007-08-23", -3); --->2007-05-22 MonthMove("2007-08-23",
	 * 3); --->2007-11-21 有错误，不使用
	 */
	// public static String MonthMove(String sDate, int iMonth) {
	// int days = 0;
	// String sMonth = sDate.substring(sDate.indexOf("-") + 1, sDate
	// .lastIndexOf("-"));
	// String sDay = sDate.substring(sDate.lastIndexOf("-") + 1);
	// if (sMonth.startsWith("0"))
	// sMonth = sMonth.substring(1, 2);
	// if (sDay.startsWith("0"))
	// sDay = sDay.substring(1, 2);
	// if (Integer.parseInt(sMonth) + iMonth == 2
	// && Integer.parseInt(sDay) > 28 && iMonth >= 1) {
	// if (isRenYear(sDate))
	// days = 29;
	// else
	// days = 28;
	// return dateMove(sDate, days * iMonth);
	// }
	// if (sMonth.equals("1") || sMonth.equals("3") || sMonth.equals("5")
	// || sMonth.equals("7") || sMonth.equals("8")
	// || sMonth.equals("10") || sMonth.equals("12")) {
	// if (iMonth >= 1)
	// days = 30;
	// else if (iMonth <= -1)
	// days = 31;
	// } else if (sMonth.equals("4") || sMonth.equals("6")
	// || sMonth.equals("9") || sMonth.equals("11")) {
	// if (iMonth >= 1)
	// days = 31;
	// else if (iMonth <= -1)
	// days = 30;
	// } else if (sMonth.equals("2") && isRenYear(sDate))
	// days = 29;
	// else if (sMonth.equals("2") && !isRenYear(sDate))
	// days = 28;
	// int iTotal = iMonth * days;
	// return dateMove(sDate, iTotal);
	// }
	/**
	 * 年的增加减少 YearMove("2007-08-23", -3); ---->2004-8-23 YearMove("2007-08-23", -3);
	 * ---->2010-8-23
	 *
	 * @param sDate
	 * @param iYear
	 * @return
	 */
	public static String YearMove(String sDate, int iYear) {
		String retStr = "";
		String sYear = sDate.substring(0, 4);
		String sMonth = sDate.substring(sDate.indexOf("-") + 1, sDate.lastIndexOf("-"));
		String sDay = sDate.substring(sDate.lastIndexOf("-") + 1);
		if (sMonth.startsWith("0"))
			sMonth = sMonth.substring(1, 2);
		if (sDay.startsWith("0"))
			sDay = sDay.substring(1, 2);

		if (isRenYear(sDate) && sMonth.equals("2") && sDay.equals("29")) {
			retStr = Integer.toString(Integer.parseInt(sYear) + iYear) + "-" + sMonth + "-" + "28";
			if (isRenYear(retStr)) {
				retStr = retStr.substring(0, 4) + "-" + sMonth + "-" + "29";
			}
		} else {
			retStr = Integer.toString(Integer.parseInt(sYear) + iYear) + "-" + sMonth + "-" + sDay;
		}
		return retStr;
	}

	/**
	 * 关于星期的函数 判断两个日期是否在同一周 isSameWeekDates(new Date(2007,01,01),new
	 * Date(2006,12,28)); 跨年好像有问题
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameWeekDates(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		if (0 == subYear) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
			// 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		return false;
	}

	/**
	 * 产生周名字 java.util.Date dd = new java.sql.Date(); Date dt = new
	 * Date(dd.getTime()); String s26 = getSeqWeekCaption(dt);
	 * System.out.println((s26)); 2007年34周
	 *
	 * @param date
	 * @return
	 */
	public static String getSeqWeekCaption(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(java.sql.Date.valueOf(getSaturday(date)));
		String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		if (week.length() == 1)
			week = "0" + week;
		String year = Integer.toString(c.get(Calendar.YEAR));
		return year + "年" + week + "周";
	}

	/**
	 * 产生周名字 String s27 = getSeqWeek(dt); System.out.println((s27)); 34
	 *
	 * @param date
	 * @return
	 */
	public static String getSeqWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));

		return week;
	}

	/**
	 * 获得日期所在得周日的日期 2007-08-19 按照西方的习惯，一周以周日开始，哈哈，那一般应该是前面，注意
	 *
	 * @param date
	 * @return
	 */
	public static String getSunday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATE_FORMAT);
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		return format.format(c.getTime());
	}

	/**
	 * 获得周一的日期 2007-08-25
	 *
	 * @param date
	 * @return
	 */
	public static String getMonday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATE_FORMAT);
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		return format.format(c.getTime());

	}

	/**
	 * 获得周二的日期
	 *
	 * @param date
	 * @return
	 */
	public static String getTuesday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATE_FORMAT);
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		return format.format(c.getTime());

	}

	/**
	 * 获得周三的日期
	 *
	 * @param date
	 * @return
	 */
	public static String getWednesday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATE_FORMAT);
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		return format.format(c.getTime());

	}

	/**
	 * 获得周四的日期
	 *
	 * @param date
	 * @return
	 */
	public static String getThursday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATE_FORMAT);
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		return format.format(c.getTime());

	}

	/**
	 * 获得周五的日期
	 *
	 * @param date
	 * @return
	 */
	public static String getFriday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATE_FORMAT);
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		return format.format(c.getTime());

	}

	/**
	 * 获得周六的日期
	 *
	 * @param date
	 * @return
	 */
	public static String getSaturday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATE_FORMAT);
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		return format.format(c.getTime());

	}

	/**
	 * 根据时间变量返回时间字符串 yyyy-MM-dd
	 *
	 * @param date
	 * @return
	 */
	public static String dateToStringToYYMMDD(Timestamp date) {
		if (date == null) {
			return "";
		}
		Date udate = new Date(date.getTime());
		return dateNoGMTToString(udate, "yy/MM/dd");
	}

	public static String dateToStringToYYMMdd(Timestamp date) {
		if (date == null) {
			return "";
		}
		Date udate = new Date(date.getTime());
		return dateNoGMTToString(udate, "yy-MM-dd");
	}

	/**
	 * 带入开始日期和结束日期，得到所在的周的星期数，包括星期日的日期，星期六的日期，和caption 2007-08-19 2007-08-25
	 * 2007年34周
	 *
	 * @param sCurDate
	 * @param sEndDate
	 * @return
	 */
	public static LinkedList<String> weekRangeList(String sCurDate, String sEndDate) {
		LinkedList<String> list = new LinkedList<String>();

		// if (daySub(sCurDate, sEndDate) < 0) {
		// Date dCurDate = java.sql.Date.valueOf(sCurDate);
		// Date dEndDate = java.sql.Date.valueOf(sEndDate);
		//
		// if (isSameWeekDates(dCurDate, dEndDate)) {
		// // 在同一个星期内
		// WeekValue wv = new WeekValue();
		// wv.setSBeginDate(getSunday((dCurDate)));
		// wv.setSEndDate(getSaturday((dCurDate)));
		// wv.setSWeekCaption(getSeqWeekCaption(dCurDate));
		// list.add(wv);
		// } else {
		// // 不在同一个星期内
		// sCurDate = getSunday(((dCurDate)));
		// sEndDate = getSaturday((dEndDate));
		// while (!(isSameWeekDates(java.sql.Date.valueOf(sCurDate),
		// java.sql.Date.valueOf(sEndDate)))) {
		// WeekValue wv = new WeekValue();
		// wv.setSBeginDate(getSunday((java.sql.Date.valueOf(sCurDate))));
		// wv.setSEndDate(getSaturday((java.sql.Date.valueOf(sCurDate))));
		// wv.setSWeekCaption(getSeqWeekCaption(java.sql.Date
		// .valueOf(sCurDate)));
		// list.add(wv);
		// sCurDate = dateMove(sCurDate, 7);
		// }
		// WeekValue wv = new WeekValue();
		// wv.setSBeginDate(getSunday((java.sql.Date.valueOf(sCurDate))));
		// wv.setSEndDate(getSaturday((java.sql.Date.valueOf(sCurDate))));
		// wv.setSWeekCaption(getSeqWeekCaption(java.sql.Date
		// .valueOf(sCurDate)));
		// list.add(wv);
		// }
		// }
		return list;
	}

	/**
	 * 两个日期间隔的天数 dayRange("2007-08-01","2007-08-13");--->13
	 *
	 * @param sCurDate
	 * @param sEndDate
	 * @return
	 */
	public static int dayRange(String sCurDate, String sEndDate) {
		int i = 0;
		if (sCurDate.length() >= 10) {
			sCurDate = sCurDate.substring(0, 10);
		}

		if (sEndDate.length() >= 10) {
			sEndDate = sEndDate.substring(0, 10);
		}

		if (daySub(sCurDate, sEndDate) < 0) {
			Date dCurDate = java.sql.Date.valueOf(sCurDate);
			Date dEndDate = java.sql.Date.valueOf(sEndDate);
			long begintime = dCurDate.getTime();
			long endtime = dEndDate.getTime();
			long betweendays = (endtime - begintime) / (1000 * 60 * 60 * 24);
			i = Math.round(betweendays) + 1;
		}
		return i;
	}

	/**
	 * 返回若干天以后的日期 dayAfterNum("2007-08-01", 13);---2007年8月14日
	 *
	 * @param sCurDate
	 * @param i
	 * @return
	 */
	public static String dayAfterNum(String sCurDate, int i) {
		// String rtDate = "";
		Calendar c = Calendar.getInstance();
		c.setTime(java.sql.Date.valueOf(sCurDate));

		c.add(Calendar.DAY_OF_YEAR, i);
		return c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月" + c.get(Calendar.DAY_OF_MONTH) + "日";
	}

	/**
	 * 按照select取得时间范围
	 *
	 * @param range
	 * @return
	 */
	public static String getBeginDate(String range) {

		System.out.println(range + "---------------------range");

		if (range.trim().equals(TIME_RANGE_VALUES[0])) {// all
			return "";
		} else if (range.trim().equals(TIME_RANGE_VALUES[1])) {// today
			return dateToString(new Date()) + " 00:00:00";

		} else if (range.trim().equals(TIME_RANGE_VALUES[2])) {// yestoday
			return dateToString(getBeginOfYesterday()) + " 00:00:00";

		} else if (range.trim().equals(TIME_RANGE_VALUES[3])) {// tomorrow
			return dateToString(getBeginOfTomorrow()) + " 00:00:00";

		} else if (range.trim().equals(TIME_RANGE_VALUES[4])) {// this week
			return dateToString(getBeginOfThisWeek(new Date())) + " 00:00:00";

		} else if (range.trim().equals(TIME_RANGE_VALUES[5])) {// last week
			return dateToString(getBeginOfLastWeek(new Date())) + " 00:00:00";

		} else if (range.trim().equals(TIME_RANGE_VALUES[6])) {// next week
			return dateToString(getBeginOfNextWeek(new Date())) + " 00:00:00";

		} else if (range.trim().equals(TIME_RANGE_VALUES[7])) {// this month
			return dateToString(getBeginOfThisMonth(new Date())) + " 00:00:00";

		} else if (range.trim().equals(TIME_RANGE_VALUES[8])) {// last month
			return dateToString(getBeginOfLastMonth(new Date())) + " 00:00:00";

		} else if (range.trim().equals(TIME_RANGE_VALUES[9])) {// next month
			return dateToString(getBeginOfNextMonth(new Date())) + " 00:00:00";

		} else if (range.trim().equals(TIME_RANGE_VALUES[10])) {// this year
			return dateToString(getBeginOfThisYear()) + " 00:00:00";

		} else if (range.trim().equals(TIME_RANGE_VALUES[11])) {// last year
			return dateToString(getBeginOfLastYear()) + " 00:00:00";

		} else if (range.trim().equals(TIME_RANGE_VALUES[12])) {// next year
			return dateToString(getBeginOfNextYear()) + " 00:00:00";
		} else if (range.trim().equals(TIME_RANGE_VALUES[13])) {// was
			return "0000-00-00" + " 00:00:00";

		} else if (range.trim().equals(TIME_RANGE_VALUES[14])) {// will
			return dateToString(new Date()) + " 00:00:00";

		} else if ((range.trim().indexOf("/")) > -1) { // other
			String beginDate = range.trim();
			int curIndex = beginDate.indexOf("/");
			beginDate = beginDate.substring(0, curIndex);
			return beginDate + " 00:00:00";
		} else {
			return range.trim() + " 00:00:00";
		}
	}

	/**
	 * 按照select取得时间范围
	 *
	 * @param range
	 * @return
	 */
	public static String getEndDate(String range) {
		if (range.trim().equals(TIME_RANGE_VALUES[0])) {// all
			return "";
		} else if (range.trim().equals(TIME_RANGE_VALUES[1])) {// today
			return dateToString(new Date()) + " 23:59:59 ";

		} else if (range.trim().equals(TIME_RANGE_VALUES[2])) {// yesterday
			return dateToString(getEndOfYesterday()) + " 23:59:59 ";

		} else if (range.trim().equals(TIME_RANGE_VALUES[3])) {// tomorrow
			return dateToString(getEndOfTomorrow()) + " 23:59:59 ";

		} else if (range.trim().equals(TIME_RANGE_VALUES[4])) {// this week
			return dateToString(getEndOfThisWeek(new Date())) + " 23:59:59 ";

		} else if (range.trim().equals(TIME_RANGE_VALUES[5])) {// last week
			return dateToString(getEndOfLastWeek(new Date())) + " 23:59:59 ";

		} else if (range.trim().equals(TIME_RANGE_VALUES[6])) {// next week
			return dateToString(getEndOfNextWeek(new Date())) + " 23:59:59 ";

		} else if (range.trim().equals(TIME_RANGE_VALUES[7])) {// this month
			return dateToString(getEndOfThisMonth(new Date())) + " 23:59:59 ";

		} else if (range.trim().equals(TIME_RANGE_VALUES[8])) {// last month
			return dateToString(getEndOfLastMonth(new Date())) + " 23:59:59 ";

		} else if (range.trim().equals(TIME_RANGE_VALUES[9])) {// next month
			return dateToString(getEndOfNextMonth(new Date())) + " 23:59:59 ";

		} else if (range.trim().equals(TIME_RANGE_VALUES[10])) {// this year
			return dateToString(getEndOfThisYear()) + " 23:59:59 ";

		} else if (range.trim().equals(TIME_RANGE_VALUES[11])) {// Last year
			return dateToString(getEndOfLastYear()) + " 23:59:59 ";

		} else if (range.trim().equals(TIME_RANGE_VALUES[12])) {// next year
			return dateToString(getEndOfNextYear()) + " 23:59:59 ";

		} else if (range.trim().equals(TIME_RANGE_VALUES[13])) {// was
			return dateToString(new Date()) + " 23:59:59 ";

		} else if (range.trim().equals(TIME_RANGE_VALUES[14])) {// will
			return "9999-99-99" + " 23:59:59 ";

		} else if ((range.trim().indexOf("/")) > -1) { // other
			String EndDate = range.trim();
			int curIndex = EndDate.indexOf("/");
			EndDate = EndDate.substring(curIndex + 1);
			return EndDate + " 23:59:59 ";
		} else {
			return range.trim() + " 23:59:59";
		}
	}

	/**
	 * 按照select取得时间范围
	 *
	 * @param inputDate
	 * @param range
	 * @return
	 */
	public static String getSFAEndDate(String inputDate, String range) {
		/**
		 * private static final String SFA_DATE_VALUES[] = { "all", "today", "tomorrow",
		 * "nextweek", "onemonth", "twomonth", "threemonth", "halfyear", "oneyear" };
		 */

		if (range.trim().equals(SFA_DATE_VALUES[0])) {// all
			return dateMove(inputDate, 0);
		} else if (range.trim().equals(SFA_DATE_VALUES[1])) {// today
			return dateMove(inputDate, 0);
		} else if (range.trim().equals(SFA_DATE_VALUES[2])) {// tomorrow
			return dateMove(inputDate, 1);
		} else if (range.trim().equals(SFA_DATE_VALUES[3])) {// oneweek
			return dateMove(inputDate, 7);
		} else if (range.trim().equals(SFA_DATE_VALUES[4])) {// onemonth
			return dateMove(inputDate, 30);
		} else if (range.trim().equals(SFA_DATE_VALUES[5])) {// twomonth
			return dateMove(inputDate, 60);
		} else if (range.trim().equals(SFA_DATE_VALUES[6])) {// threemonth
			return dateMove(inputDate, 90);
		} else if (range.trim().equals(SFA_DATE_VALUES[7])) {// halfyear
			return dateMove(inputDate, 180);
		} else if (range.trim().equals(SFA_DATE_VALUES[8])) {// oneyear
			return dateMove(inputDate, 365);
		}
		return "";
	}

	/**
	 * 根据时间变量返回时间字符串 yyyy-MM-dd
	 *
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return dateToString(date, ISO_EXPANDED_DATE_FORMAT);
	}

	/**
	 * 根据时间变量返回时间字符串 yyyy-MM-dd
	 *
	 * @param date
	 * @return
	 */
	public static String dateToString(java.sql.Date date) {
		if (date == null) {
			return "";
		}
		Date udate = new Date(date.getTime());
		return dateToString(udate, ISO_EXPANDED_DATE_FORMAT);
	}

	/**
	 * 根据时间变量返回时间字符串 yyyy-MM-dd
	 *
	 * @param date
	 * @return
	 */
	public static String dateToString(Timestamp date) {
		if (date == null) {
			return "";
		}
		Date udate = new Date(date.getTime());
		return dateNoGMTToString(udate, ISO_EXPANDED_DATE_FORMAT);
	}

	/**
	 * 根据时间变量返回时间字符串 dd.MM.yyyy
	 *
	 * @param date
	 * @return
	 */
	public static String dateToStringDDMMYYYY(Timestamp date) {
		if (date == null) {
			return "";
		}
		Date udate = new Date(date.getTime());
		return dateNoGMTToString(udate, ISO_EXPANDED_DATE_FORMAT_DDMMYYYY);
	}

	/**
	 * 根据时间变量返回时间字符串 yyyy-MM-dd HH:mm:ss
	 *
	 * @param date
	 * @return
	 */
	public static String datetoString(Timestamp date) {
		if (date == null) {
			return "";
		}
		Date udate = new Date(date.getTime());
		return dateNoGMTToString(udate, ISO_EXPANDED_DATETIME_FORMAT);
	}

	/**
	 * 根据时间变量返回时间字符串 yyyy-MM-dd HH:mm
	 *
	 * @param date
	 * @return
	 */
	public static String datetostring(Timestamp date) {
		if (date == null) {
			return "";
		}
		Date udate = new Date(date.getTime());
		return dateNoGMTToString(udate, ISO_EXPANDED_DATETIME);
	}

	/**
	 * 根据时间变量返回时间字符串 yyyy-MM-dd HH:mm:ss / yyyy-MM-dd
	 *
	 * @param date
	 * @param time
	 * @return
	 */
	public static String dateToString(Timestamp date, boolean time) {
		if (date == null) {
			return "";
		}
		Date udate = new Date(date.getTime());
		if (time) {
			return dateNoGMTToString(udate, ISO_EXPANDED_DATETIME_FORMAT);
		} else {
			return dateNoGMTToString(udate, ISO_EXPANDED_DATE_FORMAT);
		}
	}

	/**
	 * 字符串转换为日期java.util.Date
	 *
	 * @param dateText
	 *            字符串
	 */
	public static Date stringToDate(String dateString) {

		return stringToDate(dateString, ISO_EXPANDED_DATE_FORMAT, LENIENT_DATE);
	}

	/**
	 * 字符串转换为日期java.util.Date
	 *
	 * @param dateText
	 *            字符串
	 * @param format
	 *            日期格式
	 * @param lenient
	 *            日期越界标志
	 * @return
	 */
	public static Date stringToDate(String dateText, String format, boolean lenient) {

		if (dateText == null) {

			return null;
		}

		DateFormat df = null;

		try {

			if (format == null) {
				df = new SimpleDateFormat();
			} else {
				df = new SimpleDateFormat(format);
			}

			// setLenient avoids allowing dates like 9/32/2001
			// which would otherwise parse to 10/2/2001
			df.setLenient(false);
			df.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
			return df.parse(dateText);
		} catch (ParseException e) {

			return null;
		}
	}

	/**
	 * 根据时间变量返回时间字符串
	 *
	 * @return 返回时间字符串
	 * @param pattern
	 *            时间字符串样式
	 * @param date
	 *            时间变量
	 */
	public static String dateToString(Date date, String pattern) {

		if (date == null) {

			return "";
		}

		try {

			SimpleDateFormat sfDate = new SimpleDateFormat(pattern);
			sfDate.setLenient(false);
			sfDate.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
			return sfDate.format(date);
		} catch (Exception e) {

			return "";
		}
	}

	/**
	 * 日期范围函数组
	 *
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateNoGMTToString(Date date, String pattern) {

		if (date == null) {

			return "";
		}

		try {

			SimpleDateFormat sfDate = new SimpleDateFormat(pattern);
			sfDate.setLenient(false);
			// Remove by Sandzou
			// sfDate.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
			return sfDate.format(date);
		} catch (Exception e) {

			return "";
		}
	}

	/**
	 * 本周开始日期
	 *
	 * @param today
	 * @return
	 */
	public static Date getBeginOfThisWeek(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);

		int todayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if (todayOfWeek >= Calendar.MONDAY && todayOfWeek <= Calendar.SATURDAY) {
			// calendar.add(Calendar.DATE, 2-todayOfWeek);
			calendar.add(Calendar.DATE, -(todayOfWeek - 1));
		} else if (todayOfWeek == Calendar.SUNDAY) {
			// calendar.add(Calendar.DATE, -6);
			calendar.add(Calendar.DATE, 0);
		}

		return calendar.getTime();
	}

	/**
	 * 本周结束日期
	 *
	 * @param today
	 * @return
	 */
	public static Date getEndOfThisWeek(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);

		int todayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if (todayOfWeek >= Calendar.MONDAY && todayOfWeek <= Calendar.SATURDAY) {
			// calendar.add(Calendar.DATE, 8-todayOfWeek);
			calendar.add(Calendar.DATE, 7 - todayOfWeek);
		} else if (todayOfWeek == Calendar.SUNDAY) {
			// calendar.add(Calendar.DATE, 0);
			calendar.add(Calendar.DATE, 6);
		}

		return calendar.getTime();
	}

	/**
	 * 上周开始日期
	 *
	 * @param today
	 * @return
	 */
	public static Date getBeginOfLastWeek(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.DATE, -7);

		return getBeginOfThisWeek(calendar.getTime());
	}

	/**
	 * 上周结束日期
	 *
	 * @param today
	 * @return
	 */
	public static Date getEndOfLastWeek(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.DATE, -7);

		return getEndOfThisWeek(calendar.getTime());
	}

	/**
	 * 下周开始日期
	 *
	 * @param today
	 * @return
	 */
	public static Date getBeginOfNextWeek(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.DATE, 7);

		return getBeginOfThisWeek(calendar.getTime());
	}

	/**
	 * 下周结束日期
	 *
	 * @param today
	 * @return
	 */
	public static Date getEndOfNextWeek(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.DATE, 7);

		return getEndOfThisWeek(calendar.getTime());
	}

	/**
	 * 本月开始日期
	 *
	 * @param today
	 * @return
	 */
	public static Date getBeginOfThisMonth(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);

		int todayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DATE, 1 - todayOfMonth);

		return calendar.getTime();
	}

	/**
	 * 本月结束日期
	 *
	 * @param today
	 * @return
	 */
	public static Date getEndOfThisMonth(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);

		int todayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int maxOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DAY_OF_MONTH, maxOfMonth - todayOfMonth);

		return calendar.getTime();
	}

	/**
	 * 上月开始日期
	 *
	 * @param today
	 * @return
	 */
	public static Date getBeginOfLastMonth(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.MONTH, -1);

		return getBeginOfThisMonth(calendar.getTime());
	}

	/**
	 * 上月结束日期
	 *
	 * @param today
	 * @return
	 */
	public static Date getEndOfLastMonth(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.MONTH, -1);

		return getEndOfThisMonth(calendar.getTime());
	}

	/**
	 * 下月开始日期
	 *
	 * @param today
	 * @return
	 */
	public static Date getBeginOfNextMonth(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.MONTH, 1);

		return getBeginOfThisMonth(calendar.getTime());
	}

	/**
	 * 下月结束日期
	 *
	 * @param today
	 * @return
	 */
	public static Date getEndOfNextMonth(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.MONTH, 1);

		return getEndOfThisMonth(calendar.getTime());
	}

	/**
	 * 今年开始日期
	 *
	 * @return
	 */
	public static Date getBeginOfThisYear() {
		Calendar calendar = Calendar.getInstance();
		int thisYear = calendar.get(Calendar.YEAR);

		return stringToDate(thisYear + "-1-1");
	}

	/**
	 * 今年结束日期
	 *
	 * @return
	 */
	public static Date getEndOfThisYear() {
		Calendar calendar = Calendar.getInstance();
		int thisYear = calendar.get(Calendar.YEAR);

		return stringToDate(thisYear + "-12-31");
	}

	/**
	 * 去年开始日期
	 *
	 * @return
	 */
	public static Date getBeginOfLastYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, -1);
		int thisYear = calendar.get(Calendar.YEAR);

		return stringToDate(thisYear + "-1-1");
	}

	/**
	 * 去年结束日期
	 *
	 * @return
	 */
	public static Date getEndOfLastYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, -1);
		int thisYear = calendar.get(Calendar.YEAR);

		return stringToDate(thisYear + "-12-31");
	}

	/**
	 * 明年开始日期
	 *
	 * @return
	 */
	public static Date getBeginOfNextYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, 1);
		int thisYear = calendar.get(Calendar.YEAR);

		return stringToDate(thisYear + "-1-1");
	}

	/**
	 * 明年结束日期
	 *
	 * @return
	 */
	public static Date getEndOfNextYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, 1);
		int thisYear = calendar.get(Calendar.YEAR);

		return stringToDate(thisYear + "-12-31");
	}

	/**
	 * 昨天开始时间
	 *
	 * @return
	 */
	public static Date getBeginOfYesterday() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -1);
		String yesterday = String.valueOf(calendar.get(Calendar.YEAR)) + "-"
				+ String.valueOf(calendar.get(Calendar.MONTH) + 1) + "-" + String.valueOf(calendar.get(Calendar.DATE));

		return stringToDate(yesterday);
	}

	/**
	 * 昨天结束时间
	 *
	 * @return
	 */
	public static Date getEndOfYesterday() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -1);
		String yesterday = String.valueOf(calendar.get(Calendar.YEAR)) + "-"
				+ String.valueOf(calendar.get(Calendar.MONTH) + 1) + "-" + String.valueOf(calendar.get(Calendar.DATE));

		return stringToDate(yesterday);
	}

	/**
	 * 明天开始时间
	 *
	 * @return
	 */
	public static Date getBeginOfTomorrow() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 1);
		String yesterday = String.valueOf(calendar.get(Calendar.YEAR)) + "-"
				+ String.valueOf(calendar.get(Calendar.MONTH) + 1) + "-" + String.valueOf(calendar.get(Calendar.DATE));

		return stringToDate(yesterday);
	}

	/**
	 * 明天结束时间
	 *
	 * @return
	 */
	public static Date getEndOfTomorrow() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 1);
		String yesterday = String.valueOf(calendar.get(Calendar.YEAR)) + "-"
				+ String.valueOf(calendar.get(Calendar.MONTH) + 1) + "-" + String.valueOf(calendar.get(Calendar.DATE));

		return stringToDate(yesterday);
	}

	/**
	 * 返回当前日期字符串
	 *
	 * @param pattern
	 *            日期字符串样式
	 * @return
	 */
	public static String getCurrentDateString(String pattern) {
		return dateToString(getCurrentDateTime(), pattern);
	}

	/**
	 * 返回当前时间
	 *
	 * @return 返回当前时间
	 */
	public static Date getCurrentDateTime() {
		Calendar calNow = Calendar.getInstance();
		calNow.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		Date dtNow = calNow.getTime();

		return dtNow;
	}

	/**
	 * 返回当前日期字符串
	 *
	 * @param pattern
	 *            日期字符串样式
	 * @return
	 */
	public static String getHASPDateString(String haspDate) {
		String sReturn = "";
		sReturn = haspDate.substring(0, 4) + "-" + haspDate.substring(4, 6) + "-" + haspDate.substring(6, 8);
		return sReturn;
	}

	/**
	 * 小时增加函数 minuteMove("2006-5-1", 78) 往后 -->2006-07-18 minuteMove("2006-5-1",
	 * -78) 往前 -->2006-02-12
	 *
	 * @param sCurDate
	 * @param range
	 * @return
	 */

	public static String getDelayHour(String sCurDate, String range) {
		if (range.trim().equals(HOUR_RANGE_VALUES[0])) {// 否
			return "";
		} else if (range.trim().equals(HOUR_RANGE_VALUES[1])) {// 0.5个小时
			return minuteMove(sCurDate, 30);
		} else if (range.trim().equals(HOUR_RANGE_VALUES[2])) {// 1个小时
			return minuteMove(sCurDate, 1 * 60);

		} else if (range.trim().equals(HOUR_RANGE_VALUES[3])) {// 3个小时
			return minuteMove(sCurDate, 3 * 60);

		} else if (range.trim().equals(HOUR_RANGE_VALUES[4])) {// 5个小时
			return minuteMove(sCurDate, 5 * 60);

		} else if (range.trim().equals(HOUR_RANGE_VALUES[5])) {// 1天
			return minuteMove(sCurDate, 24 * 60);

		} else if (range.trim().equals(HOUR_RANGE_VALUES[6])) {// 1周
			return minuteMove(sCurDate, 7 * 24 * 60);

		} else if (range.trim().equals(HOUR_RANGE_VALUES[7])) {// 1月
			return minuteMove(sCurDate, 7 * 24 * 30 * 60);
		}
		return "";
	}

	/**
	 * 分钟增减函数
	 *
	 * @param sCurDate
	 * @param iMinute
	 * @return
	 */
	public static String minuteMove(String sCurDate, int iMinute) {
		SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));

		Date date1;

		String mydate1 = "";
		try {
			date1 = format.parse(sCurDate);

			long Time = (date1.getTime() / 1000) + 60 * iMinute;

			date1.setTime(Time * 1000);

			mydate1 = format.format(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mydate1;
	}

	/**
	 * 小时增减函数
	 *
	 * @param sCurDate
	 * @param iHour
	 * @return
	 */
	public static String hourMove(String sCurDate, int iHour) {
		return minuteMove(sCurDate, iHour * 60);
	}

	/**
	 * 小时等于
	 *
	 * @param sCurDate
	 * @param iHour
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String hourEquals(String sCurDate, int iHour) {
		// if (sCurDate.length() <= 10) {
		// sCurDate = sCurDate + " 00:00:00";
		// }
		// long lD = java.sql.Date.valueOf(sCurDate).getTime();
		SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		Date date1;
		String mydate1 = "";
		try {
			date1 = format.parse(sCurDate);
			date1.setHours(iHour);
			// date1.getYear();
			// date1.getMonth()
			// date1.getDate();
			// iHour;
			date1.setMinutes(0);
			date1.setSeconds(0);

			mydate1 = format.format(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mydate1;

		// Date dd = new Date();
		// long lD = dd.UTC(2008 - 1900, 10 - 1, 10, 3, 01, 01);
		//
		// long ll = 1L;
		// ll = ll * (long) iHour * 3600L * 1000L;
		// lD += ll;
		//
		// return dateToString((new Date(lD)), ISO_EXPANDED_DATETIME_FORMAT);
	}

	/**
	 * 传入开始日期，结束日期，获得日期所得日期 LinkedList ll = monthRange("2007-02-04","2007-08-19");
	 * 2007-02 2007-03 2007-04 2007-05 2007-06 2007-07 2007-08
	 *
	 * @param sCurDate
	 * @param sEndDate
	 * @return
	 */
	public static LinkedList<String> daysRange(String sCurDate, String sEndDate) {
		LinkedList<String> list = new LinkedList<String>();

		if (daySub(sCurDate, sEndDate) <= 0) {
			sCurDate = dateMove(sCurDate, 0);
			sEndDate = dateMove(sEndDate, 0);

			while ((daySub(sCurDate, sEndDate) < 1)) {
				list.add(sCurDate);
				sCurDate = dateMove(sCurDate, 1);
			}
		}
		return list;
	}

	/**
	 * 返回验证后的日期的值
	 *
	 * @param sDate
	 * @return
	 */
	public static String validateDate(String sDate) {
		if (StringUtil.isValidateString(sDate)) {
			if (sDate.length() >= 10) {
				sDate = sDate.substring(0, 10);
				if (("1900-01-01".equalsIgnoreCase(sDate)) || ("1900-01-02".equalsIgnoreCase(sDate))
						|| ("0000-00-00".equalsIgnoreCase(sDate))) {
					sDate = "";
				}
			}
		} else {
			sDate = "";
		}
		return sDate;
	}

	/**
	 * 返回验证后的日期时间的值
	 *
	 * @param sDateTime
	 * @return
	 */
	public static String validateDateTime(String sDateTime) {
		if (StringUtil.isValidateString(sDateTime)) {
			if ((sDateTime.indexOf("0000-00-00") > -1) || (sDateTime.indexOf("1900-01-01") > -1)) {
				sDateTime = "";
			} else if ((sDateTime.indexOf("0000-00-00") == -1) || (sDateTime.indexOf("1900-01-01") == -1)) {
				return sDateTime;
			}

		} else {
			sDateTime = "";
		}
		return sDateTime;
	}

	/**
	 * 判断是否为合法的日期时间字符串
	 *
	 * @param str_input
	 * @return boolean;符合为true,不符合为false
	 */
	public static boolean isValidateDate(String sDate) {
		if (StringUtil.isValidateString(sDate)) {
			SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATE_FORMAT);
			format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
			format.setLenient(false);
			try {
				format.format(format.parse(sDate));
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * 判断是否为合法的日期时间字符串
	 *
	 * @param str_input
	 * @return boolean;符合为true,不符合为false
	 */
	public static boolean isValidateDateTime(String sDateTime) {
		if (StringUtil.isValidateString(sDateTime)) {
			SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);
			format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
			format.setLenient(false);
			try {
				format.format(format.parse(sDateTime));
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * 判断是否为合法的日期时间字符串
	 *
	 * @param sDate
	 * @return
	 */
	public static boolean isValidateLongDate(String sDate) {
		boolean bReturn = false;
		return bReturn;
	}

	/**
	 * 取得带入日期所在周的第一天 getBeginDateOfWeek("2007-03-24") ----> 2007-03-01
	 *
	 * @param strDate
	 * @return
	 */
	public static String getBeginDateOfWeek(String strDate) {
		int sWeek = DateUtil.getWeekDay(strDate);
		return DateUtil.dateMove(strDate, 0 - sWeek);
	}

	/**
	 * 取得带入日期所在周的最后一天
	 *
	 * @param strDate
	 * @return
	 */
	public static String getEndDateOfWeek(String strDate) {
		int sWeek = DateUtil.getWeekDay(strDate);
		return DateUtil.dateMove(strDate, 6 - sWeek);
	}

	/**
	 * 取得带入日期所在年的第一天
	 *
	 * @param strDate
	 * @return
	 */
	public static String getBeginDateOfYear(String strDate) {
		String beginOfYear = DateUtil.getYear(strDate);
		return beginOfYear + "-01-01";
	}

	/**
	 * 取得带入日期所在年的最后一天
	 *
	 * @param strDate
	 * @return
	 */
	public static String getEndDateOfYear(String strDate) {
		String beginOfYear = DateUtil.getYear(strDate);
		return beginOfYear + "-12-31";
	}

	/**
	 * 日期增加-按月增加
	 *
	 * @param date
	 * @param days
	 * @return java.util.Date
	 */
	public static Date dateIncreaseByMonth(Date date, int mnt) {

		Calendar c = Calendar.getInstance();
		c.setTime(java.sql.Date.valueOf(getSaturday(date)));
		c.add(Calendar.MONTH, mnt);

		return c.getTime();
	}

	/**
	 * 按照输入日期，取得增减月的日期
	 *
	 * @param startDate
	 * @param monthNum
	 * @return
	 */
	public static String MonthMove(String startDate, int monthNum) {
		String resultDate;
		resultDate = "";
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat(ISO_EXPANDED_DATE_FORMAT);
			sdf.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
			calendar.setTime(sdf.parse(startDate));
			calendar.add(Calendar.MONTH, monthNum);
			calendar.add(Calendar.DATE, 0);
			Date date = calendar.getTime();
			resultDate = sdf.format(date);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
		return resultDate;
	}

	/**
	 * 按照输入日期，取得增减季度的日期
	 *
	 * @param startDate
	 * @param quarterNum
	 * @return
	 */
	public static String QuarterMove(String startDate, int quarterNum) {
		String resultDate;
		resultDate = "";
		try {
			String strYear = getYear(MonthMove(startDate, quarterNum * 3));
			String strMonth = getMonth(MonthMove(startDate, quarterNum * 3));
			if (strMonth == null || strYear == null)
				return "";
			if (strMonth.equals("01") || strMonth.equals("02") || strMonth.equals("03")) {
				return strYear + "-" + "01" + "-" + "01";
			} else if (strMonth.equals("04") || strMonth.equals("05") || strMonth.equals("06")) {
				return strYear + "-" + "04" + "-" + "01";
			} else if (strMonth.equals("07") || strMonth.equals("08") || strMonth.equals("09")) {
				return strYear + "-" + "07" + "-" + "01";
			} else if (strMonth.equals("10") || strMonth.equals("11") || strMonth.equals("12")) {
				return strYear + "-" + "10" + "-" + "01";
			} else
				return "";
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
		return resultDate;
	}

	/**
	 * 取得季度开始时间
	 *
	 * @param startDate
	 * @return
	 */
	public static String getQuarterBegin(String startDate) {
		String resultDate;
		resultDate = "";
		try {
			String strYear = getYear(startDate);
			String strMonth = getMonth(startDate);
			if (strMonth == null || strYear == null)
				return "";
			if (strMonth.equals("01") || strMonth.equals("02") || strMonth.equals("03")) {
				return strYear + "-" + "01" + "-" + "01";
			} else if (strMonth.equals("04") || strMonth.equals("05") || strMonth.equals("06")) {
				return strYear + "-" + "04" + "-" + "01";
			} else if (strMonth.equals("07") || strMonth.equals("08") || strMonth.equals("09")) {
				return strYear + "-" + "07" + "-" + "01";
			} else if (strMonth.equals("10") || strMonth.equals("11") || strMonth.equals("12")) {
				return strYear + "-" + "10" + "-" + "01";
			} else
				return "";
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
		return resultDate;
	}

	/**
	 * 取得季度结束时间
	 *
	 * @param startDate
	 * @return
	 */
	public static String getQuarterEnd(String startDate) {
		String resultDate;
		resultDate = "";
		try {
			String strYear = getYear(startDate);
			String strMonth = getMonth(startDate);
			if (strMonth == null || strYear == null)
				return "";
			if (strMonth.equals("01") || strMonth.equals("02") || strMonth.equals("03")) {
				return strYear + "-" + "03" + "-" + "31";
			} else if (strMonth.equals("04") || strMonth.equals("05") || strMonth.equals("06")) {
				return strYear + "-" + "06" + "-" + "30";
			} else if (strMonth.equals("07") || strMonth.equals("08") || strMonth.equals("09")) {
				return strYear + "-" + "09" + "-" + "30";
			} else if (strMonth.equals("10") || strMonth.equals("11") || strMonth.equals("12")) {
				return strYear + "-" + "12" + "-" + "31";
			} else
				return "";
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
		return resultDate;
	}

	/**
	 * 按照输入日期，取得增减半年的日期
	 *
	 * @param startDate
	 * @param halfYearNum
	 * @return
	 */
	public static String HalfYearMove(String startDate, int halfYearNum) {
		String resultDate;
		resultDate = "";
		try {
			String strYear = getYear(MonthMove(startDate, halfYearNum * 6));
			String strMonth = getMonth(MonthMove(startDate, halfYearNum * 6));
			if (strMonth == null || strYear == null)
				return "";
			if (strMonth.equals("01") || strMonth.equals("02") || strMonth.equals("03") || strMonth.equals("04")
					|| strMonth.equals("05") || strMonth.equals("06")) {
				return strYear + "-" + "01" + "-" + "01";
			} else if (strMonth.equals("07") || strMonth.equals("08") || strMonth.equals("09") || strMonth.equals("10")
					|| strMonth.equals("11") || strMonth.equals("12")) {
				return strYear + "-" + "07" + "-" + "01";
			} else
				return "";
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
		return resultDate;
	}

	/**
	 * 获取半年底日期
	 *
	 * @param startDate
	 * @return
	 */
	public static String getHalfYearEnd(String startDate) {
		String resultDate;
		resultDate = "";
		try {
			String strYear = getYear(startDate);
			String strMonth = getMonth(startDate);
			if (strMonth == null || strYear == null)
				return "";
			if (strMonth.equals("01") || strMonth.equals("02") || strMonth.equals("03") || strMonth.equals("04")
					|| strMonth.equals("05") || strMonth.equals("06")) {
				return strYear + "-" + "06" + "-" + "30";
			} else if (strMonth.equals("07") || strMonth.equals("08") || strMonth.equals("09") || strMonth.equals("10")
					|| strMonth.equals("11") || strMonth.equals("12")) {
				return strYear + "-" + "12" + "-" + "31";
			} else
				return "";
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
		return resultDate;
	}

	/**
	 * 按照输入的日期时间，取得日期(仅适用于datetime类型)
	 *
	 * @param strDate
	 * @return
	 */
	public static String getDayOfDateTime(String strDate) {
		if (!StringUtil.isValidateString(strDate)) {
			// return SystemDate.getCurDate();
			return "";
		}
		if (strDate.length() >= 10) {
			return validateDate(strDate.substring(0, 10));
		}
		// return SystemDate.getCurDate();
		return "";
	}

	/**
	 * 按照输入的日期时间，取得小时(仅适用于datetime类型)
	 *
	 * @param strDate
	 * @return
	 */
	@SuppressWarnings("unused")
	public static String getHourOfDateTime(String strDate) {

		if (!StringUtil.isValidateString(strDate)) {
			// return SystemDate.getCurTime().substring(0, 2);
			return "";
		}
		if (true) {
			String[] strMin = strDate.split(":");
			return strDate = strMin[0].substring(strMin[0].indexOf(" ") + 1, strMin[0].length());
		}
		// return SystemDate.getCurTime().substring(0, 2);
		return "";
	}

	/**
	 * 按照输入的日期时间，取得分钟(仅适用于datetime类型)
	 *
	 * @param strDate
	 * @return
	 */
	@SuppressWarnings("unused")
	public static String getMinOfDateTime(String strDate) {
		if (!StringUtil.isValidateString(strDate)) {
			// return SystemDate.getCurTime().substring(3, 5);
			return "";
		}
		if (true) {
			String[] strMin = strDate.split(":");
			return strDate = strMin[1];
		}
		// return SystemDate.getCurTime().substring(3, 5);
		return "";
	}

	/**
	 * 取得两个时间间隔的分钟
	 *
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long getDistance(Date startTime, Date endTime) {
		long distance = endTime.getTime() - startTime.getTime();
		return distance / (60 * 1000);
	}

	/**
	 * 取得两个时间间隔的秒数
	 *
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long getDistanceMiles(Date startTime, Date endTime) {
		long distance = endTime.getTime() - startTime.getTime();
		return distance / (1000);
	}

	/**
	 * 输入String 获得时间
	 *
	 * @param strDateTime
	 * @return
	 */
	public static GregorianCalendar getDate(String strDateTime) {
		SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		Date date = new Date();
		GregorianCalendar calendar = new GregorianCalendar();
		try {
			if (StringUtil.isValidateString(strDateTime)) {
				date = format.parse(strDateTime);
				date = new Date(date.getTime());
				calendar.setTime(date);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return calendar;
	}

	/**
	 * 取得两个时间间隔的分钟
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Long getInterval(String date1, String date2) {
		long minutes = (getDate(date2).getTimeInMillis() - getDate(date1).getTimeInMillis()) / 60000;
		return minutes;
	}

	/**
	 * 针对一个日期时间，加减时间
	 *
	 * @param date
	 * @param amount
	 * @param field
	 * @return
	 */
	public static Date addTime(Date date, int amount, int field) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(field, amount);
		return c.getTime();
	}

	/**
	 * 针对一个日期时间，加减时间，返回字符
	 *
	 * @param strDateTime
	 * @param iAmount
	 * @param field
	 * @return
	 */
	public static String getPassDateTime(String strDateTime, int iAmount, int field) {
		return dateToString(addTime(getDayTimeFromString(strDateTime), iAmount, field), ISO_EXPANDED_DATETIME_FORMAT);
	}

	/**
	 * 带入日期，返回00:00:00日期+时间
	 *
	 * @param strDate
	 * @return
	 */
	public static String getBeginDateTimeFromDate(String strDate) {
		return StringUtil.validateString(strDate) + " 00:00:00";
	}

	/**
	 * 带入日期，返回23:59:59日期+时间
	 *
	 * @param strDate
	 * @return
	 */
	public static String getEndDateTimeFromDate(String strDate) {
		return StringUtil.validateString(strDate) + " 23:59:59";
	}

	/**
	 * 带入日期，返回'00:00:00日期+时间'
	 *
	 * @param strDate
	 * @return
	 */
	public static String getBeginDateTimeSQLFromDate(String strDate) {
		return "'" + StringUtil.validateString(strDate) + " 00:00:00" + "'";
	}

	/**
	 * 带入日期，返回'23:59:59日期+时间'
	 *
	 * @param strDate
	 * @return
	 */
	public static String getEndDateTimeSQLFromDate(String strDate) {
		return "'" + StringUtil.validateString(strDate) + " 23:59:59" + "'";
	}

	/**
	 * 判断时间date1是否在时间date2之前 时间格式 2005-4-21 16:16:34
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isDateBefore(String date1, String date2) {
		try {
			DateFormat df = DateFormat.getDateTimeInstance();
			return df.parse(date1).before(df.parse(date2));
		} catch (ParseException e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	/**
	 * 判断时间date1是否在当前时间之前
	 *
	 * @param date2
	 * @return
	 */
	public static boolean isDateBefore(String date2) {
		if (!StringUtil.isValidateString(date2)) {
			return true;
		}
		try {
			Date date1 = new Date();
			DateFormat df = DateFormat.getDateTimeInstance();
			return date1.before(df.parse(date2));
		} catch (ParseException e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	/**
	 * 取得该年的一月一日
	 *
	 * @param iYear
	 * @return
	 */
	public static String beginOfYear(int iYear) {
		return String.valueOf(iYear) + "-1-1";
	}

	/**
	 * 取得该年的12月31日
	 *
	 * @param iYear
	 * @return
	 */
	public static String endOfYear(int iYear) {
		return String.valueOf(iYear) + "-12-31";
	}

	/**
	 * 取得日期时间 Calendar.YEAR, year + 1900 the month value between 0-11 月份要先减1
	 *
	 * @param iYear
	 * @param iMonth
	 * @param iDay
	 * @param iHour
	 * @param iMinute
	 * @param iSecond
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String getDateTime(int iYear, int iMonth, int iDay, int iHour, int iMinute, int iSecond) {
		SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));

		Date tmpDate = new Date();

		String strOutputDateTime = "";
		try {

			tmpDate.setYear(iYear - 1900);
			tmpDate.setMonth(iMonth);
			tmpDate.setDate(iDay);
			tmpDate.setHours(iHour);
			tmpDate.setMinutes(iMinute);
			tmpDate.setSeconds(iSecond);

			strOutputDateTime = format.format(tmpDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return strOutputDateTime;

	}

	/**
	 * 根据传入的datetime取得date
	 *
	 * @param strDateTime
	 * @return
	 */
	public static String getDateFormDateTime(String strDateTime) {
		if (!StringUtil.isValidateString(strDateTime)) {
			return "";
		}
		if (isValidateDateTime(strDateTime)) {
			String[] strDate = strDateTime.split(" ");
			return strDate[0];
		}
		return "";
	}

	/**
	 * 根据传入的datetime取得time
	 *
	 * @param strDateTime
	 * @return
	 */
	public static String getTimeFormDateTime(String strDateTime) {
		if (!StringUtil.isValidateString(strDateTime)) {
			return "";
		}
		if (isValidateDateTime(strDateTime)) {
			String[] strDate = strDateTime.split(" ");
			return strDate[1];
		}
		return "";
	}

	/**
	 * 转化不同时间类型
	 *
	 * @param date
	 * @return
	 */
	public static java.sql.Date convterSqlData(Date date) {
		if (date == null) {
			return null;
		}
		return new java.sql.Date(date.getTime());
	}

	/**
	 * 获得时间
	 *
	 * @return
	 */
	public static Timestamp getCurLongDateTimestamp() {
		String strTime = getCurLongDate();
		Timestamp ts = Timestamp.valueOf(strTime);
		return ts;
	}

	/**
	 * 获得时间
	 *
	 * @param timestamp
	 * @return
	 */
	public static Timestamp getTimestamp(Timestamp timestamp) {
		String strTime = getCurLongDate();
		Timestamp ts = Timestamp.valueOf(strTime);
		return ts;
	}

	/**
	 * 获得时间
	 *
	 * @param timestamp
	 * @return
	 */
	public static Timestamp getCreateTime(Timestamp timestamp) {
		if (timestamp == null) {
			return getCurLongDateTimestamp();
		}
		return timestamp;
	}

	/**
	 * 获得时间
	 *
	 * @param timestamp
	 * @return
	 */
	public static Timestamp haveTimestamp(Timestamp timestamp) {
		if (timestamp == null) {
			return getCurLongDateTimestamp();
		}
		return timestamp;
	}

	/**
	 * 转化不同时间类型
	 *
	 * @param date
	 * @return
	 */
	public static Date convterUtilData(java.sql.Date date) {
		if (date == null) {
			return null;
		}
		return new Date(date.getTime());
	}

	/**
	 * 从date数组中取值
	 *
	 * @param date
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public static java.sql.Date getDataAryValue(java.sql.Date[] date, int index) throws Exception {
		if (date == null || date.length <= 0) {
			return null;
		}
		if (index < 0 || index > date.length) {
			return null;
		}
		return date[index];
	}

	/**
	 * 从date数组中取值
	 *
	 * @param date
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public static Timestamp getDateAryValue(Timestamp[] date, int index) throws Exception {
		if (date == null || date.length <= 0) {
			return null;
		}
		if (index < 0 || index > date.length) {
			return null;
		}
		return date[index];
	}

	/**
	 * 从当前日期中获得年份
	 *
	 * @param date
	 * @return
	 */
	public static String getYear(Date date) {
		if (date == null) {

		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		return format.format(date);
	}

	/**
	 * 从当前日期中获得双位年份
	 *
	 * @param date
	 * @return
	 */
	public static String getTwoDigitYear(Date date) {
		if (date == null) {

		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		return format.format(date).substring(2, 4);
	}

	/**
	 * 从当前日期中获得月份
	 */
	public static String getMonth(Date date) {
		if (date == null) {

		}
		SimpleDateFormat format = new SimpleDateFormat("MM");
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		return format.format(date);
	}

	/**
	 * timestamp1> timestamp2 返回 正数 timestamp1= timestamp2 返回 0 timestamp1>
	 * timestamp2 返回 负数 日期比较
	 *
	 * @param timestamp1
	 * @param timestamp2
	 * @return
	 */
	public static long dateCompare(Timestamp timestamp1, Timestamp timestamp2) {
		if (timestamp1 == null && timestamp2 == null) {
			return 0;
		}
		if (timestamp1 != null && timestamp2 == null) {
			return 1;
		}
		if (timestamp1 == null && timestamp2 != null) {
			return -1;
		}
		return timestamp1.getTime() - timestamp2.getTime();
	}

	/**
	 * 验证年
	 *
	 * @param sYear
	 * @return
	 */
	public static boolean isValidateYear(String sYear) {
		boolean bReturn = false;
		if (sYear.length() == 4) {
			bReturn = true;
		}
		return bReturn;
	}

	/**
	 * 验证月
	 *
	 * @param sMonth
	 * @return
	 */
	public static boolean isValidateMonth(String sMonth) {
		boolean bReturn = false;
		if ((sMonth.length() == 1) || (sMonth.length() == 2)) {
			bReturn = true;
		}
		return bReturn;
	}

	/**
	 * 一年一个月的时间
	 *
	 * @param sYear
	 * @param sMonth
	 * @return
	 */
	public static String getDateByYearAndMonth(String sYear, String sMonth) {
		return StringUtil.validateString(sYear) + "-" + StringUtil.validateString(sMonth) + "-" + "01";
	}

	/**
	 *
	 * @param timestampStr
	 * @return
	 */
	public static Timestamp stringToTimestamp(String timestampStr) {
		if (timestampStr == null || timestampStr.trim().equals(" ")) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);
		format.setTimeZone(TimeZone.getTimeZone(TIMEZONE_GMT));
		try {
			Date date = format.parse(StringUtil.validateString(timestampStr));
			return new Timestamp(date.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 通过年份获得整年的月首和月末日期
	 *
	 * @param year
	 * @return
	 */
	public static List<String[]> getListByYear(String year) {
		List<String[]> list = new ArrayList<String[]>();
		String date = "";
		for (int i = 1; i <= getIntCurMonth(); i++) {
			if (i < 10) {
				date = year + "-0" + i + "-01";
			} else
				date = year + "-" + i + "-01";
			String[] sarry = new String[2];
			sarry[0] = year + "-01-01";
			if (i == getIntCurMonth()) {
				sarry[1] = getCurDate();
			} else {
				sarry[1] = getEndDateOfMonth(date);
			}
			list.add(sarry);
		}

		return list;
	}

	/**
	 * 一年中的所有列表
	 *
	 * @param year
	 * @return
	 */
	public static List<String[]> getAllListByYear(String year) {
		List<String[]> list = new ArrayList<String[]>();
		String date = "";
		for (int i = 1; i <= 12; i++) {
			if (i < 10) {
				date = year + "-0" + i + "-01";
			} else
				date = year + "-" + i + "-01";
			String[] sarry = new String[2];
			sarry[0] = getBeginDateOfMonth(date);
			sarry[1] = getEndDateOfMonth(date);
			list.add(sarry);
		}
		return list;
	}

	/**
	 * 获得当前的日期时间
	 *
	 * @return
	 */
	public static java.sql.Date getCurDateTime() {
		return new java.sql.Date(System.currentTimeMillis());
	}

	/**
	 * 取当前的毫秒
	 *
	 * @return
	 */
	public static String getTimeMillis() {
		return String.valueOf(System.currentTimeMillis());
	}

	/**
	 * 取当前的毫秒返回固定长度
	 *
	 * @return
	 */
	public static String getTimeMillis(int length) {
		long cur = System.currentTimeMillis();
		int len = String.valueOf(cur).length();
		String strCur = String.valueOf(cur);
		if (len < length) {
			return strCur + StringUtil.randomIntNumber(length - len);
		} else if (len > length) {
			return "1" + strCur.substring(strCur.length() - 6) + StringUtil.randomIntNumber(3);
		} else {
			return strCur;
		}

	}

	@SuppressWarnings("unused")
	public static String getDateTo(String time) throws Exception {
		long now = System.currentTimeMillis();
		long s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(time).getTime();// 根据字符串time得到毫秒数.
		System.out.println(now - s);
		Date date = new Date(now - s);
		/*
		 * System.out.println(date.getHours() + ":" + date.getMinutes() + ":" +
		 * date.getSeconds());
		 */
		return "";
	}

	public static String getDateBefore(int number) throws Exception {
		int num = -number;
		Format f = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, num);
		f.format(c.getTime());
		return f.format(c.getTime());
	}

	public static String getHms(int longtime) throws Exception {
		int h = longtime / 3600;
		int m = (longtime - h * 3600) / 60;
		int s = longtime - h * 3600 - m * 60;
		String time = h + ":" + m + ":" + s;
		return time;
	}

	/**
	 * method 将字符串类型的日期按照转换为一个timestamp（时间戳记java.sql.Timestamp）
	 *
	 * @param dateString
	 *            需要转换为timestamp的字符串
	 * @param formaterString
	 *            dateString字符串的解析格式
	 * @return
	 * @throws ParseException
	 */
	public final static Timestamp string2Time(String dateString) throws Exception {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);// 设定格式
		// dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		dateFormat.setLenient(false);
		Date timeDate = dateFormat.parse(dateString);// util类型
		Timestamp dateTime = new Timestamp(timeDate.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
		return dateTime;
	}
}
