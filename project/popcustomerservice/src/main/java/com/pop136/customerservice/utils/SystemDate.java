package com.pop136.customerservice.utils;

/**
 * Created by XH on 2018-8-14.
 */
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SystemDate {

    public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";

    public static final String ISO_EXPANDED_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static boolean LENIENT_DATE = false;

    public static String[] TIME_RANGE_VALUES = { "all", "today", "yesterday",
            "tomorrow", "thisweek", "lastweek", "nextweek", "thismonth",
            "lastmonth", "nextmonth", "thisyear", "lastyear", "nextyear",
            "was", "will", "before7day", "before15day", "before30day",
            "before60day", "before90day", "before150day", "before200day",
            "before1000day" };

    private static final String SFA_DATE_VALUES[] = { "0", "1", "2", "3", "4",
            "5", "6", "7", "8" };

    public static String[] HOUR_RANGE_VALUES = { "none", "halfhour", "onehour",
            "threehour", "fivehour", "oneday", "oneweek", "onemonth" };

    // dateComp 日期比较函数 d1比d2小 dateComp("2006-3-1", "2006-4-1")---> -1
    // dateComp 日期比较函数 d1是否在dateBegin和dateEnd区间内
    // dateMove 日期增加函数 dateMove("2006-5-1", 78) 往后 -->2006-07-18
    // dateTimeMove 日期时间增减函数 输入时间 加减日期
    // daySub 日期相减函数 daySub("2006-3-1", "2006-4-1") d1-d2 -31
    // getCurDate 获得当前日期 2007-08-23
    // getCurDay 获得当前日 23
    // getCurLongDate 获得当前长日期格式 2007-08-23 16:22:24
    // getCurMonth 获得当前月 08
    // getCurTime 获得当前时间 16:24:1
    // getCurWeekDay 获得当前日对应的星期几 星期四---->4
    // getCurYear 获得当前年 2007
    // getDay 根据传入的日期，获得对应日 getDay("2007-03-24") --->24
    // getDayFromString 根据传入的字符，获得对应日期 getDayFromString
    // getDayTimeFromString 根据传入的字符，获得对应日期/时间
    // getBeginDateOfMonth 获得传入日期的月头日 getBeginDateOfMonth("2007-03-24") ---->
    // 2007-03-01
    // getEndDateOfMonth 获得传入日期的月末日 getEndDateOfMonth("2007-03-24") ---->
    // 2007-03-31
    // getLocalCurDate 获得本地当前日期 2007年08月23日
    // getLocalCurWeekDay 获得本地当前日对应的星期几 星期四
    // getLocalDate 根据输入的日期串生成标准日期格式 getLocalDate("2007-02-25") --> 2007年02月25日
    // getLocalWeekDay 根据传入的日期获得日的星期 getLocalWeekDay("2007-02-25")---->星期日
    // getLocalWeekDay 根据传入的日期获得日的星期 getLocalWeekDay(0)---->星期日
    // getMonth 获得传入日期的月 getMonth("2007-02-25");---->02
    // getNumOfMonth 获得？年？月的天数 getNumOfMonth("2007","3")---->31
    // getWeekDay 得到传入日期的星期几 getWeekDay("2007-08-23");--->4
    // getYear 得到传入日期的年份 getYear("2007-08-23");---->2007
    // isDate 判断传入的日期是否为正确的日期格式 isDate("2007-13-09");----false 传入的格式为"年-月-日"
    // isRenYear 判断年是否为润年 isRenYear("2001-02-05");---false
    // isRenYear("2000-02-05");---true
    // monthRange 传入开始日期，结束日期，获得日期中的月份 LinkedList ll =
    // monthRange("2007-02-04","2007-08-19"); 2007-02 2007-03 2007-04 2007-05
    // 2007-06 2007-07 2007-08
    // monthRangeList
    // monthRangeCaption 传入开始日期，结束日期，获得日期中的月份 LinkedList li =
    // monthRangeCaption("2007-02-04","2007-08-19"); 2007年02月 2007年03月 2007年04月
    // 2007年05月 2007年06月 2007年07月 2007年08月
    // YearMove 年的增加减少 YearMove("2007-08-23", -3); ---->2004-8-23
    // isSameWeekDates 关于星期的函数 判断两个日期是否在同一周
    // getSeqWeekCaption 产生周名字
    // getSeqWeek 产生周 String s27 = getSeqWeek(dt); System.out.println((s27)); 34
    // getSunday 获得日期所在得周日的日期 2007-08-19 按照西方的习惯，一周以周日开始，哈哈，那一般应该是前面，注意
    // getMonday 获得周一的日期 2007-08-25
    // getTuesday 获得周二的日期 2007-08-25
    // getWednesday 获得周三的日期 2007-08-25
    // getThursday 获得周四的日期 2007-08-25
    // getFriday 获得周五的日期 2007-08-25
    // getSaturday 获得周六的日期 2007-08-25
    // weekRangeList 带入开始日期和结束日期，得到所在的周的星期数，包括星期日的日期，星期六的日期，和caption 2007-08-19
    // 2007-08-25
    // dayRange 两个日期间隔的天数 dayRange("2007-08-01","2007-08-13");--->13
    // dayAfterNum 返回若干天以后的日期 dayAfterNum("2007-08-01", 13);---2007年8月14日
    // getBeginDate 按照select取得时间范围
    // getEndDate 按照select取得时间范围
    // dateToString 根据时间变量返回时间字符串 yyyy-MM-dd
    // stringToDate 字符串转换为日期java.util.Date
    // stringToDate 字符串转换为日期java.util.Date
    // dateToString 根据时间变量返回时间字符串
    // getBeginOfThisWeek 取得本周的开始时间
    // getEndOfThisWeek 取得本周的结束时间
    // getBeginOfLastWeek 取得上周的开始时间
    // getEndOfLastWeek 取得上周的结束时间
    // getBeginOfNextWeek 取得下周的开始时间
    // getEndOfNextWeek 取得下周的结束时间
    // getBeginOfThisMonth 取得本月的开始时间
    // getEndOfThisMonth 取得本月的结束时间
    // getBeginOfLastMonth 取得上月的开始时间
    // getEndOfLastMonth 取得上月的结束时间
    // getBeginOfNextMonth 取得下月的开始时间
    // getEndOfNextMonth 取得下月的结束时间
    // getBeginOfThisYear 取得今年的开始时间
    // getEndOfThisYear 取得今年的结束时间
    // getBeginOfLastYear 取得去年的开始时间
    // getEndOfLastYear 取得去年的结束时间
    // getBeginOfNextYear 取得明年的开始时间
    // getEndOfNextYear 取得明年的结束时间
    // getBeginOfYesterday 取得昨天的开始时间
    // getEndOfYesterday 取得昨天的结束时间
    // getBeginOfTomorrow 取得明天的开始时间
    // getEndOfTomorrow 取得明天的结束时间
    // getCurrentDateString 返回当前日期字符串
    // getCurrentDateTime 返回当前时间
    // getHASPDateString Hasp专用去时间
    // getDelayHour 小时增加函数
    // hourMove 小时增减函数
    // hourEquals 小时等于
    // daysRange 传入开始日期，结束日期，获得日期所得日期
    // validateDate 返回验证后的日期的值
    // validateDateTime 返回验证后的日期时间的值
    // isValidateDate 验证是否是日期
    // isValidateDateTime 验证是否是日期时间
    // isValidateLongDate 验证是否是日期时间
    // getBeginDateOfWeek 取得带入日期所在周的第一天
    // getEndDateOfWeek 取得带入日期所在周的最后一天
    // getBeginDateOfYear 取得带入日期所在年的第一天
    // getEndDateOfYear 取得带入日期所在年的最后一天
    // dateIncreaseByMonth 日期增加-按月增加
    // MonthMove 按照输入日期，取得增减月的日期
    // getDayOfDateTime 按照输入的日期时间，取得日期
    // getHourOfDateTime 按照输入的日期时间，取得小时
    // getMinOfDateTime 按照输入的日期时间，取得分钟
    // getDistance 取得两个时间间隔的分钟
    // getDate 输入String 获得时间
    // getInterval 取得两个时间间隔的分钟
    // addTime 针对一个日期时间，加减时间
    // getPassDateTime 针对一个日期时间，加减时间，返回字符
    // getBeginDateTimeFromDate 带入日期，返回00:00:00日期+时间
    // getEndDateTimeFromDate 带入日期，返回23:59:59日期+时间
    // isDateBefore 判断时间date1是否在时间date2之前
    // isDateBefore 判断时间date1是否在当前时间之前
    // beginOfYear 取得该年的一月一日
    // endOfYear 取得该年的12月31日
    // getDateTime 取得日期时间
    // getDateFormDateTime 根据传入的datetime取得date
    // getTimeFormDateTime 根据传入的datetime取得Time

    /**
     * @param args
     */
    public static void main(String args[]) {
        System.out.println(NewInSometime(getCurTime(),"13:10:00","13:30:00"));
        System.out.println(getStringCurLongDate());
        System.out.println(getWeekDateByWeekInYear(2011, 30));
        System.out.println(getWeekDateByWeekInMonth(2011, 2, 3));
        System.out.println(dateComp("2008-09-24", "2008-09-23", "2008-11-23"));
        System.out.println("-----");
        System.out.println(daySub("1900-1-1 0:00:00", "2008-09-24"));

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

        // LinkedList list = daysRange("2008-10-01", "2008-11-23");
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
        String s2 = dateMove("2006-5-1", 78);
        System.out.println((s2));
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

    public SystemDate() {
    }

    /*
     * 日期比较函数 d1比d2小 dateComp("2006-3-1", "2006-4-1")---> -1 d1比d2相同
     * dateComp("2006-4-1", "2006-4-1")---> 0 d1比d2大 dateComp("2006-5-1",
     * "2006-4-1")---> 1
     */
    public static int dateComp(String Date1, String Date2) {
        if ((Date1 == null || Date1.trim().length() == 0)
                && (Date2 == null || Date2.trim().length() == 0))
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

    /*
     * 日期比较函数 d1是否在dateBegin和dateEnd区间内
     */
    public static boolean dateComp(String date1, String dateBegin,
                                   String dateEnd) {
        if ((date1 == null || date1.trim().length() == 0)
                || (dateBegin == null || dateBegin.trim().length() == 0)
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

    /*
     * 日期增加函数 dateMove("2006-5-1", 78) 往后 -->2006-07-18 ateMove("2006-5-1", -78)
     * 往前 -->2006-02-12
     */
    public static String dateMove(String sCurDate, int iDays) {

        if (!StringUtils.isValidateString(sCurDate)) {
            return "";
        }
        if (sCurDate.length() > 10) {
            sCurDate = sCurDate.substring(0, sCurDate.indexOf(" "));
        }
        long lD = java.sql.Date.valueOf(sCurDate).getTime();

        long ll = 1L;
        ll = ll * (long) iDays * 24L * 3600L * 1000L;
        lD += ll;

        return dateToString((new Date(lD)), ISO_EXPANDED_DATE_FORMAT);

    }

    public static String weekMove(String sCurDate, int iDays) {
        if (!StringUtils.isValidateString(sCurDate)) {
            return "";
        }
        if ((sCurDate.length() > 10)) {
            sCurDate = sCurDate.substring(0, sCurDate.indexOf(" "));
        }
        long lD = java.sql.Date.valueOf(sCurDate).getTime();

        long ll = 1L;
        ll = ll * (long) iDays * 24L * 3600L * 1000L * 7;
        lD += ll;

        return dateToString((new Date(lD)), ISO_EXPANDED_DATE_FORMAT);

    }

    public static String dateTimeMove(String sCurDate, int iDays) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        java.util.Date date1;

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

    /*
     * 日期相减函数 daySub("2006-3-1", "2006-4-1") d1-d2 -31 daySub("2006-5-1",
     * "2006-4-1") d1-d2 30
     */
    public static long daySub(String Date1, String Date2) {
        if ((!StringUtils.isValidateString(Date1))
                || (!StringUtils.isValidateString(Date2))) {
            return 0;
        }
        // System.out.println(Date1.length());
        if (Date1.length() > 10) {
            // Date1 = Date1.substring(0, 10);
            Date1 = Date1.substring(0, Date1.indexOf(" "));
        }

        if (Date2.length() > 10) {
            // Date2 = Date2.substring(0, 10);
            Date2 = Date2.substring(0, Date2.indexOf(" "));
        }
        if ((StringUtils.isValidateString(Date1))
                && (StringUtils.isValidateString(Date2))) {
            long lD1 = java.sql.Date.valueOf(Date1).getTime();
            long lD2 = java.sql.Date.valueOf(Date2).getTime();
            long ll = lD1 - lD2;
            ll /= 0x5265c00L;
            return ll;
        } else {
            return 0;
        }
    }

    /*
     * 获得当前日期 2007-08-23
     */
    public static String getCurDate() {
        java.util.Date dd = new java.util.Date();
        Date dt = new java.sql.Date(dd.getTime());
        return dt.toString();
        // java.util.Calendar dd = java.util.Calendar.getInstance();
        // Date dt = new Date(dd.getTime());
        // return dd.getTime().toString();
    }

    /*
     * 获得当前日 23
     */
    public static String getCurDay() {
        String s = getCurDate();
        return s.substring(s.lastIndexOf("-") + 1);
    }

    /*
     * 获得当前长日期格式 2007-08-23 16:22:24
     */
    public static String getCurLongDate() {
        return getCurDate() + " " + getCurTime();
    }

    /*
     * 获得当前月 08
     */
    public static String getCurMonth() {
        String s = getCurDate();
        int iB = s.indexOf("-");
        return s.substring(iB + 1, s.indexOf("-", iB + 1));
    }

    /*
     * 获得当前时间 16:24:1
     */
    public static String getCurTime() {

        String strHour = new java.util.Date().getHours() < 10 ? "0"
                + String.valueOf(new java.util.Date().getHours()) : String
                .valueOf(new java.util.Date().getHours());
        String strMinutes = new java.util.Date().getMinutes() < 10 ? "0"
                + String.valueOf(new java.util.Date().getMinutes()) : String
                .valueOf(new java.util.Date().getMinutes());
        String strSeconds = new java.util.Date().getSeconds() < 10 ? "0"
                + String.valueOf(new java.util.Date().getSeconds()) : String
                .valueOf(new java.util.Date().getSeconds());
        String st = strHour + ":" + strMinutes + ":" + strSeconds;
        int iB = st.indexOf(":");
        // return st.substring(iB - 2, iB + 6);
        return st;
    }

    /*
     * 获得当前日对应的星期几 星期四---->4
     */
    public static int getCurWeekDay() {
        String sCurDay = getCurDate();
        String sDay = "1000-01-07";
        return Integer.parseInt(daySub(sCurDay, sDay) % 7L + "");
    }

    /*
     * 获得当前年 2007
     */
    public static String getCurYear() {
        String s = getCurDate();
        return s.substring(0, s.indexOf("-"));
    }

    /*
     * 根据传入的日期，获得对应日 getDay("2007-03-24") --->24
     */
    public static String getDay(String sdate) {
        try {
            Date dt = java.sql.Date.valueOf(sdate);
            return dt.toString().substring(8);
        } catch (Exception _ex) {
            return "0";
        }
    }

    /*
     * 根据传入的字符，获得对应日期 getDayFromString
     */
    public static Date getDayFromString(String sdate) {
        Date dt = java.sql.Date.valueOf(sdate);
        java.util.Date returnDate = new java.util.Date(dt.getTime());
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            returnDate = sdf.parse(sdate);
        } catch (Exception _ex) {
            return returnDate;
        }
        return returnDate;
    }

    /*
     * 根据传入的字符，获得对应日期/时间
     */
    public static Date getDayTimeFromString(String sDateTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date1 = null;

        try {
            date1 = format.parse(sDateTime);
        } catch (Exception _ex) {
            return date1;
        }
        return date1;
    }

    /*
     * 获得传入日期的月头日 getBeginDateOfMonth("2007-03-24") ----> 2007-03-01
     */
    public static String getBeginDateOfMonth(String strDate) {
        strDate = strDate.substring(0, 7) + "-" + "01";
        return strDate;
    }

    /*
     * 获得传入日期的月末日 getEndDateOfMonth("2007-03-24") ----> 2007-03-31
     */
    public static String getEndDateOfMonth(String strDate) {
        int iD = 30;
        int iM = StringUtils.str2int(strDate.substring(5, 7));
        if (iM == 1 || iM == 3 || iM == 5 || iM == 7 || iM == 8 || iM == 10
                || iM == 12)
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

    /*
     * 获得本地当前日期 2007年08月23日
     */
    public static String getLocalCurDate() {
        String sData = getCurDate();
        return getYear(sData) + "年" + getMonth(sData) + "月" + getDay(sData)
                + "日";
    }

    /*
     * 获得本地当前日对应的星期几 星期四
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

    /*
     * 根据输入的日期串生成标准日期格式 getLocalDate("2007-02-25") --> 2007年02月25日
     */
    public static String getLocalDate(String sDate) {
        return getYear(sDate) + "年" + getMonth(sDate) + "月" + getDay(sDate)
                + "日";
    }

    /*
     * 根据传入的日期获得日的星期 getLocalWeekDay("2007-02-25")---->星期日
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

    /*
     * 根据传入的日期获得日的星期 getLocalWeekDay(0)---->星期日
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

    /*
     * 根据传入的日期获得日的星期 getLocalWeekDay(0)---->星期日
     */
    public static String getLocalWeekDay(int iDate) {
        return getPrivateLocalWeekDay("", iDate);
    }

    /*
     * 根据传入的日期获得日的星期 getLocalWeekDay(0)---->星期日
     */
    public static String getLongLocalWeekDay(int iDate) {
        return getPrivateLocalWeekDay("周", iDate);
    }

    /*
     * 获得传入日期的月 getMonth("2007-02-25");---->02
     */
    public static String getMonth(String sdate) {
        try {
            Date dt = java.sql.Date.valueOf(sdate);
            return dt.toString().substring(5, 7);
        } catch (Exception _ex) {
            return "0";
        }
    }

    /*
     * 获得？年？月的天数 getNumOfMonth("2007","3")---->31
     */
    public static int getNumOfMonth(String sDate, String sMonth) {
        if (sMonth == null || sDate == null)
            return 0;
        int iYear = StringUtils.str2int(sDate);
        if (sMonth.equals("01") || sMonth.equals("03") || sMonth.equals("05")
                || sMonth.equals("07") || sMonth.equals("08")
                || sMonth.equals("10") || sMonth.equals("12"))
            return 31;
        if (sMonth.equals("04") || sMonth.equals("06") || sMonth.equals("09")
                || sMonth.equals("11"))
            return 30;
        if (iYear % 4 == 0)
            return iYear % 100 == 0 || iYear % 400 != 0 ? 28 : 29;
        else
            return 28;
    }

    /*
     * 得到传入日期的星期几 getWeekDay("2007-08-23");--->4
     */
    public static int getWeekDay(String sDate) {
        String sDay = "1000-01-07";
        return Integer.parseInt(daySub(sDate, sDay) % 7L + "");
    }

    /*
     * 得到传入日期的年份 getYear("2007-08-23");---->2007
     */
    public static String getYear(String sdate) {
        try {
            Date dt = java.sql.Date.valueOf(sdate);
            return dt.toString().substring(0, 4);
        } catch (Exception _ex) {
            return "0";
        }
    }

    /*
     * 判断传入的日期是否为正确的日期格式 isDate("2007-13-09");----false 传入的格式为"年-月-日"
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
            int iM = StringUtils.str2int(sM);
            int iD = StringUtils.str2int(sD);
            if (iM > 12 || iM <= 0 || iD <= 0)
                return false;
            if (iM == 1 || iM == 3 || iM == 5 || iM == 7 || iM == 8 || iM == 10
                    || iM == 12) {
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

    /*
     * 判断年是否为润年 isRenYear("2001-02-05");---false isRenYear("2000-02-05");---true
     */
    public static boolean isRenYear(String sDate) {
        try {
            String s = java.sql.Date.valueOf(sDate).toString();
            int iYear = StringUtils.str2int(s.substring(0, 4));
            return (iYear % 4 == 0 && iYear % 100 != 0) || iYear % 400 == 0;
        } catch (Exception _ex) {
            return false;
        }
    }

    /*
     * 传入开始日期，结束日期，获得日期中的月份 LinkedList ll =
     * monthRange("2007-02-04","2007-08-19"); 2007-02 2007-03 2007-04 2007-05
     * 2007-06 2007-07 2007-08
     */
    public static LinkedList monthRange(String sCurDate, String sEndDate) {
        LinkedList list = new LinkedList();
        if ((!StringUtils.isValidateString(sCurDate))
                || (!StringUtils.isValidateString(sEndDate))) {
            return list;
        }

        if (daySub(sCurDate, sEndDate) <= 0) {
            sCurDate = dateMove(sCurDate, 0);
            sEndDate = dateMove(sEndDate, 0);

            String sBeginMon = getMonth(sCurDate);
            String sEndMon = getMonth(sEndDate);

            String sFirstMon = getYear(sCurDate) + "-" + getMonth(sCurDate);
            String sFirstDay = sFirstMon + "-01";
            String sEndDay = getYear(sEndDate) + "-" + getMonth(sEndDate)
                    + "-01";

            while ((daySub(sFirstDay, sEndDay) < 1)) {
                list = monthRangeList(list, sFirstDay);
                sFirstDay = dateMove(getEndDateOfMonth(sFirstDay), 1);
            }
        }
        return list;
    }

    private static LinkedList monthRangeList(LinkedList mlist, String sCurDate) {
        String sMon = getYear(sCurDate) + "-" + getMonth(sCurDate);
        mlist.add(sMon);
        return mlist;
    }

    /*
     * 传入开始日期，结束日期，获得日期中的月份 LinkedList li =
     * monthRangeCaption("2007-02-04","2007-08-19"); 2007年02月 2007年03月 2007年04月
     * 2007年05月 2007年06月 2007年07月 2007年08月
     */
    public static LinkedList monthRangeCaption(String sCurDate, String sEndDate) {
        LinkedList list = new LinkedList();
        LinkedList mlist = monthRange(sCurDate, sEndDate);

        for (int i = 0; i < mlist.size(); i++) {
            String sTemp = (String) mlist.get(i);
            sTemp = sTemp.replaceAll("-", "年") + "月";
            list.add(sTemp);
        }

        return list;
    }

    /*
     * 月的增加减少 MonthMove("2007-08-23", -3); --->2007-05-22
     * MonthMove("2007-08-23", 3); --->2007-11-21 有错误，不使用
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
	/*
	 * 年的增加减少 YearMove("2007-08-23", -3); ---->2004-8-23 YearMove("2007-08-23",
	 * -3); ---->2010-8-23
	 */
    public static String YearMove(String sDate, int iYear) {
        String retStr = "";
        String sYear = sDate.substring(0, 4);
        String sMonth = sDate.substring(sDate.indexOf("-") + 1, sDate
                .lastIndexOf("-"));
        String sDay = sDate.substring(sDate.lastIndexOf("-") + 1);
        if (sMonth.startsWith("0"))
            sMonth = sMonth.substring(1, 2);
        if (sDay.startsWith("0"))
            sDay = sDay.substring(1, 2);

        if (isRenYear(sDate) && sMonth.equals("2") && sDay.equals("29")) {
            retStr = Integer.toString(Integer.parseInt(sYear) + iYear) + "-"
                    + sMonth + "-" + "28";
            if (isRenYear(retStr)) {
                retStr = retStr.substring(0, 4) + "-" + sMonth + "-" + "29";
            }
        } else {
            retStr = Integer.toString(Integer.parseInt(sYear) + iYear) + "-"
                    + sMonth + "-" + sDay;
        }
        return retStr;
    }

    /*
     * 关于星期的函数 判断两个日期是否在同一周 isSameWeekDates(new Date(2007,01,01),new
     * Date(2006,12,28)); 跨年好像有问题
     */
    public static boolean isSameWeekDates(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        if (0 == subYear) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
                    .get(Calendar.WEEK_OF_YEAR))
                return true;
        } else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
            // 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
                    .get(Calendar.WEEK_OF_YEAR))
                return true;
        } else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
                    .get(Calendar.WEEK_OF_YEAR))
                return true;
        }
        return false;
    }

    /*
     * 产生周名字 java.util.Date dd = new java.sql.Date(); Date dt = new
     * Date(dd.getTime()); String s26 = getSeqWeekCaption(dt);
     * System.out.println((s26)); 2007年34周
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

    /*
     * 产生周 String s27 = getSeqWeek(dt); System.out.println((s27)); 34
     */
    public static String getSeqWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));

        return week;
    }

    /*
     * 获得日期所在得周日的日期 2007-08-19 按照西方的习惯，一周以周日开始，哈哈，那一般应该是前面，注意
     */
    public static String getSunday(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    }

    /*
     * 获得周一的日期 2007-08-25
     */
    public static String getMonday(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());

    }

    /*
     * 获得周二的日期 2007-08-25
     */
    public static String getTuesday(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());

    }

    /*
     * 获得周三的日期 2007-08-25
     */
    public static String getWednesday(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());

    }

    /*
     * 获得周四的日期 2007-08-25
     */
    public static String getThursday(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());

    }

    /*
     * 获得周五的日期 2007-08-25
     */
    public static String getFriday(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());

    }

    /*
     * 获得周六的日期 2007-08-25
     */
    public static String getSaturday(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());

    }

    /*
     * 带入开始日期和结束日期，得到所在的周的星期数，包括星期日的日期，星期六的日期，和caption 2007-08-19 2007-08-25
     * 2007年34周
     */
    public static LinkedList weekRangeList(String sCurDate, String sEndDate) {
        LinkedList list = new LinkedList();
        if ((!StringUtils.isValidateString(sCurDate))
                || (!StringUtils.isValidateString(sEndDate))) {
            return list;
        }

        if (daySub(sCurDate, sEndDate) < 0) {
            Date dCurDate = java.sql.Date.valueOf(sCurDate);
            Date dEndDate = java.sql.Date.valueOf(sEndDate);

            if (isSameWeekDates(dCurDate, dEndDate)) {
                // 在同一个星期内
                WeekValue wv = new WeekValue();
                wv.setSBeginDate(getSunday((dCurDate)));
                wv.setSEndDate(getSaturday((dCurDate)));
                wv.setSWeekCaption(getSeqWeekCaption(dCurDate));
                list.add(wv);
            } else {
                // 不在同一个星期内
                sCurDate = getSunday(((dCurDate)));
                sEndDate = getSaturday((dEndDate));
                while (!(isSameWeekDates(java.sql.Date.valueOf(sCurDate),
                        java.sql.Date.valueOf(sEndDate)))) {
                    WeekValue wv = new WeekValue();
                    wv.setSBeginDate(getSunday((java.sql.Date
                                    .valueOf(sCurDate))));
                    wv.setSEndDate(getSaturday((java.sql.Date
                                    .valueOf(sCurDate))));
                    wv.setSWeekCaption(getSeqWeekCaption(java.sql.Date
                            .valueOf(sCurDate)));
                    list.add(wv);
                    sCurDate = dateMove(sCurDate, 7);
                }
                WeekValue wv = new WeekValue();
                wv.setSBeginDate(getSunday((java.sql.Date.valueOf(sCurDate))));
                wv.setSEndDate(getSaturday((java.sql.Date.valueOf(sCurDate))));
                wv.setSWeekCaption(getSeqWeekCaption(java.sql.Date
                        .valueOf(sCurDate)));
                list.add(wv);
            }
        }
        return list;
    }

    /*
     * 两个日期间隔的天数 dayRange("2007-08-01","2007-08-13");--->13
     */
    public static int dayRange(String sCurDate, String sEndDate) {
        int i = 0;
        if (!StringUtils.isValidateString(sCurDate)
                || !StringUtils.isValidateString(sEndDate)) {
            return 0;
        }
        if ((sCurDate.length() > 10)) {
            // sCurDate = sCurDate.substring(0, 10);
            sCurDate = sCurDate.substring(0, sCurDate.indexOf(" "));
        }

        if ((sEndDate.length() > 10)) {
            // sEndDate = sEndDate.substring(0, 10);
            sEndDate = sEndDate.substring(0, sEndDate.indexOf(" "));
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

    /*
     * 返回若干天以后的日期 dayAfterNum("2007-08-01", 13);---2007年8月14日
     */
    public static String dayAfterNum(String sCurDate, int i) {
        String rtDate = "";
        Calendar c = Calendar.getInstance();
        c.setTime(java.sql.Date.valueOf(sCurDate));

        c.add(Calendar.DAY_OF_YEAR, i);
        return c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月"
                + c.get(Calendar.DAY_OF_MONTH) + "日";
    }

    /*
     * 按照select取得时间范围
     *
     */
    public static String getBeginDate(String range) {
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
            return "1900-01-01" + " 00:00:00";

        } else if (range.trim().equals(TIME_RANGE_VALUES[14])) {// will
            return dateToString(new Date()) + " 00:00:00";

        } else if (range.trim().equals(TIME_RANGE_VALUES[15])) {// before 7 day
            return "1900-01-01" + " 00:00:00";

        } else if (range.trim().equals(TIME_RANGE_VALUES[16])) {// before 15 day
            return "1900-01-01" + " 00:00:00";

        } else if (range.trim().equals(TIME_RANGE_VALUES[17])) {// before 30 day
            return "1900-01-01" + " 00:00:00";

        } else if (range.trim().equals(TIME_RANGE_VALUES[18])) {// before 60 day
            return "1900-01-01" + " 00:00:00";

        } else if (range.trim().equals(TIME_RANGE_VALUES[19])) {// before 90 day
            return "1900-01-01" + " 00:00:00";

        } else if (range.trim().equals(TIME_RANGE_VALUES[20])) {// before 150
            // day
            return "1900-01-01" + " 00:00:00";

        } else if (range.trim().equals(TIME_RANGE_VALUES[21])) {// before 200
            // day
            return "1900-01-01" + " 00:00:00";

        } else if (range.trim().equals(TIME_RANGE_VALUES[22])) {// before 1000
            // day
            return "1900-01-01" + " 00:00:00";

        } else if ((range.trim().indexOf("/")) > -1) { // other
            String beginDate = range.trim();
            int curIndex = beginDate.indexOf("/");
            beginDate = beginDate.substring(0, curIndex);
            if (StringUtils.includeStr(beginDate, " ")) {
                return beginDate;
            } else {
                return beginDate + " 00:00:00";
            }
        }

        return "";
    }

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
            return "9999-12-31" + " 23:59:59 ";

        } else if (range.trim().equals(TIME_RANGE_VALUES[15])) {// before 7 day
            // return dateMove(dateToString(new Date()), -7) + " 00:00:00";
            return dateMove(dateToString(new Date()), -6) + " 00:00:00";
        } else if (range.trim().equals(TIME_RANGE_VALUES[16])) {// before 15 day
            // return dateMove(dateToString(new Date()), -15) + " 00:00:00";
            return dateMove(dateToString(new Date()), -14) + " 00:00:00";
        } else if (range.trim().equals(TIME_RANGE_VALUES[17])) {// before 30day
            // return dateMove(dateToString(new Date()), -30) + " 00:00:00";
            return dateMove(dateToString(new Date()), -29) + " 00:00:00";
        } else if (range.trim().equals(TIME_RANGE_VALUES[18])) {// before 60 day
            // return dateMove(dateToString(new Date()), -60) + " 00:00:00";
            return dateMove(dateToString(new Date()), -59) + " 00:00:00";
        } else if (range.trim().equals(TIME_RANGE_VALUES[19])) {// before 90 day
            // return dateMove(dateToString(new Date()), -90) + " 00:00:00";
            return dateMove(dateToString(new Date()), -89) + " 00:00:00";
        } else if (range.trim().equals(TIME_RANGE_VALUES[20])) {// before 150day
            // return dateMove(dateToString(new Date()), -150) + " 00:00:00";
            return dateMove(dateToString(new Date()), -149) + " 00:00:00";
        } else if (range.trim().equals(TIME_RANGE_VALUES[21])) {// before 200
            // day
            // return dateMove(dateToString(new Date()), -200) + " 00:00:00";
            return dateMove(dateToString(new Date()), -199) + " 00:00:00";

        } else if ((range.trim().indexOf("/")) > -1) { // other
            String EndDate = range.trim();
            int curIndex = EndDate.indexOf("/");
            EndDate = EndDate.substring(curIndex + 1);
            if (StringUtils.includeStr(EndDate, " ")) {
                return EndDate;
            } else {
                return EndDate + " 23:59:59 ";
            }
        }

        return "";
    }

    public static String getSFAEndDate(String inputDate, String range) {
        /**
         * private static final String SFA_DATE_VALUES[] = { "all", "today",
         * "tomorrow", "nextweek", "onemonth", "twomonth", "threemonth",
         * "halfyear", "oneyear" };
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
    public static Date stringToDate(String dateText, String format,
                                    boolean lenient) {

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

            return null;
        }

        try {

            SimpleDateFormat sfDate = new SimpleDateFormat(pattern);
            sfDate.setLenient(false);

            return sfDate.format(date);
        } catch (Exception e) {

            return null;
        }
    }

    /**
     * 日期范围函数组 getBeginOfThisWeek 本周开始日期 getEndOfThisWeek 本周结束日期
     * getBeginOfLastWeek 上周开始日期 getEndOfLastWeek 上周结束日期 getBeginOfThisMonth
     * 本月开始日期 getEndOfThisMonth 本月结束日期 getBeginOfLastMonth 上月开始日期
     * getEndOfLastMonth 上月结束日期 getBeginOfThisYear 今年开始日期 getEndOfThisYear
     * 今年结束日期
     *
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

    public static Date getBeginOfLastWeek(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE, -7);

        return getBeginOfThisWeek(calendar.getTime());
    }

    public static Date getEndOfLastWeek(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE, -7);

        return getEndOfThisWeek(calendar.getTime());
    }

    public static Date getBeginOfNextWeek(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE, 7);

        return getBeginOfThisWeek(calendar.getTime());
    }

    public static Date getEndOfNextWeek(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE, 7);

        return getEndOfThisWeek(calendar.getTime());
    }

    public static Date getBeginOfThisMonth(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        int todayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, 1 - todayOfMonth);

        return calendar.getTime();
    }

    public static Date getEndOfThisMonth(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        int todayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int maxOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DAY_OF_MONTH, maxOfMonth - todayOfMonth);

        return calendar.getTime();
    }

    public static Date getBeginOfLastMonth(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, -1);

        return getBeginOfThisMonth(calendar.getTime());
    }

    public static Date getEndOfLastMonth(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, -1);

        return getEndOfThisMonth(calendar.getTime());
    }

    public static Date getBeginOfNextMonth(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, 1);

        return getBeginOfThisMonth(calendar.getTime());
    }

    public static Date getEndOfNextMonth(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, 1);

        return getEndOfThisMonth(calendar.getTime());
    }

    public static Date getBeginOfThisYear() {
        Calendar calendar = Calendar.getInstance();
        int thisYear = calendar.get(Calendar.YEAR);

        return stringToDate(thisYear + "-1-1");
    }

    public static Date getEndOfThisYear() {
        Calendar calendar = Calendar.getInstance();
        int thisYear = calendar.get(Calendar.YEAR);

        return stringToDate(thisYear + "-12-31");
    }

    public static Date getBeginOfLastYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -1);
        int thisYear = calendar.get(Calendar.YEAR);

        return stringToDate(thisYear + "-1-1");
    }

    public static Date getEndOfLastYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -1);
        int thisYear = calendar.get(Calendar.YEAR);

        return stringToDate(thisYear + "-12-31");
    }

    public static Date getBeginOfNextYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 1);
        int thisYear = calendar.get(Calendar.YEAR);

        return stringToDate(thisYear + "-1-1");
    }

    public static Date getEndOfNextYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 1);
        int thisYear = calendar.get(Calendar.YEAR);

        return stringToDate(thisYear + "-12-31");
    }

    public static Date getBeginOfYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -1);
        String yesterday = String.valueOf(calendar.get(Calendar.YEAR)) + "-"
                + String.valueOf(calendar.get(Calendar.MONTH) + 1) + "-"
                + String.valueOf(calendar.get(Calendar.DATE));

        return stringToDate(yesterday);
    }

    public static Date getEndOfYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -1);
        String yesterday = String.valueOf(calendar.get(Calendar.YEAR)) + "-"
                + String.valueOf(calendar.get(Calendar.MONTH) + 1) + "-"
                + String.valueOf(calendar.get(Calendar.DATE));

        return stringToDate(yesterday);
    }

    public static Date getBeginOfTomorrow() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 1);
        String yesterday = String.valueOf(calendar.get(Calendar.YEAR)) + "-"
                + String.valueOf(calendar.get(Calendar.MONTH) + 1) + "-"
                + String.valueOf(calendar.get(Calendar.DATE));

        return stringToDate(yesterday);
    }

    public static Date getEndOfTomorrow() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 1);
        String yesterday = String.valueOf(calendar.get(Calendar.YEAR)) + "-"
                + String.valueOf(calendar.get(Calendar.MONTH) + 1) + "-"
                + String.valueOf(calendar.get(Calendar.DATE));

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
        java.util.Calendar calNow = java.util.Calendar.getInstance();
        java.util.Date dtNow = calNow.getTime();

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
        sReturn = haspDate.substring(0, 4) + "-" + haspDate.substring(4, 6)
                + "-" + haspDate.substring(6, 8);
        return sReturn;
    }

	/*
	 * 小时增加函数 minuteMove("2006-5-1", 78) 往后 -->2006-07-18 minuteMove("2006-5-1",
	 * -78) 往前 -->2006-02-12
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

    public static String minuteMove(String sCurDate, int iMinute) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        java.util.Date date1;

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

    public static String hourMove(String sCurDate, int iHour) {
        return minuteMove(sCurDate, iHour * 60);
    }

    public static String hourEquals(String sCurDate, int iHour) {
        // if (sCurDate.length() <= 10) {
        // sCurDate = sCurDate + " 00:00:00";
        // }
        // long lD = java.sql.Date.valueOf(sCurDate).getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        java.util.Date date1;

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

    /*
     * 传入开始日期，结束日期，获得日期所得日期 LinkedList ll =
     * monthRange("2007-02-04","2007-08-19"); 2007-02 2007-03 2007-04 2007-05
     * 2007-06 2007-07 2007-08
     */
    public static LinkedList daysRange(String sCurDate, String sEndDate) {
        LinkedList list = new LinkedList();
        if ((!StringUtils.isValidateString(sCurDate))
                || (!StringUtils.isValidateString(sEndDate))) {
            return list;
        }

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
     * 字符串转换为日期java.util.Date
     *
     * @param dateText
     *            字符串
     */
    public static Date stringtoDate(String dateString) {

        return stringToDate(dateString, ISO_EXPANDED_DATETIME_FORMAT,
                LENIENT_DATE);
    }

    public static String validateDate(String sDate) {
        if (StringUtils.isValidateString(sDate)) {
            if (sDate.length() > 10) {
                // sDate = sDate.substring(0, 10);
                sDate = sDate.substring(0, sDate.indexOf(" "));
                if (("1900-01-01".equalsIgnoreCase(sDate))
                        || ("1900-01-02".equalsIgnoreCase(sDate))
                        || ("0000-00-00".equalsIgnoreCase(sDate))) {
                    sDate = "";
                }
            }
        } else {
            sDate = "";
        }
        return sDate;
    }

    public static String validateDateTime(String sDateTime) {
        if (StringUtils.isValidateString(sDateTime)) {
            if ((sDateTime.indexOf("0000-00-00") > -1)
                    || (sDateTime.indexOf("1900-01-01") > -1)) {
                sDateTime = "";
            } else if ((sDateTime.indexOf("0000-00-00") == -1)
                    || (sDateTime.indexOf("1900-01-01") == -1)) {
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
        if (StringUtils.isValidateString(sDate)) {
            SimpleDateFormat formatter = new SimpleDateFormat(
                    ISO_EXPANDED_DATE_FORMAT);
            formatter.setLenient(false);
            try {
                formatter.format(formatter.parse(sDate));
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
        if (StringUtils.isValidateString(sDateTime)) {
            SimpleDateFormat formatter = new SimpleDateFormat(
                    ISO_EXPANDED_DATETIME_FORMAT);
            formatter.setLenient(false);
            try {
                formatter.format(formatter.parse(sDateTime));
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean isValidateLongDate(String sDate) {
        boolean bReturn = false;
        return bReturn;
    }

    //

    /*
     * 获得传入日期的月头日 getBeginDateOfWeek("2007-03-24") ----> 2007-03-01
     */
    public static String getBeginDateOfWeek(String strDate) {
        int sWeek = SystemDate.getWeekDay(strDate);
        return SystemDate.dateMove(strDate, 0 - sWeek);
    }

    public static String getEndDateOfWeek(String strDate) {
        int sWeek = SystemDate.getWeekDay(strDate);
        return SystemDate.dateMove(strDate, 6 - sWeek);
    }

    public static String getBeginDateOfYear(String strDate) {
        String beginOfYear = SystemDate.getYear(strDate);
        return beginOfYear + "-01-01";
    }

    public static String getEndDateOfYear(String strDate) {
        String beginOfYear = SystemDate.getYear(strDate);
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

    public static String MonthMove(String startDate, int monthNum) {
        String resultDate;
        resultDate = "";
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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

    // 仅适用于datetime类型
    public static String getDayOfDateTime(String strDate) {
        if (!StringUtils.isValidateString(strDate)) {
            // return SystemDate.getCurDate();
            return "";
        }
        if (strDate.length() > 10) {
            // return validateDate(strDate.substring(0, 10));
            return validateDate(strDate.substring(0, strDate.indexOf(" ")));
        }
        // return SystemDate.getCurDate();
        return "";
    }

    // 仅适用于datetime类型
    public static String getHourOfDateTime(String strDate) {

        if (!StringUtils.isValidateString(strDate)) {
            // return SystemDate.getCurTime().substring(0, 2);
            return "";
        }
        if (true) {
            String[] strMin = strDate.split(":");
            return strDate = strMin[0].substring(strMin[0].indexOf(" ") + 1,
                    strMin[0].length());
        }
        // return SystemDate.getCurTime().substring(0, 2);
        return "";
    }

    // 仅适用于datetime类型
    public static String getMinOfDateTime(String strDate) {
        if (!StringUtils.isValidateString(strDate)) {
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

    public static long getDistance(Date startTime, Date endTime) {
        long distance = endTime.getTime() - startTime.getTime();
        return distance / (60 * 1000);
    }

    public static GregorianCalendar getDate(String strDateTime) {
        SimpleDateFormat timeFormat = new SimpleDateFormat(
                ISO_EXPANDED_DATETIME_FORMAT);
        Date date = new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        try {
            if (StringUtils.isValidateString(strDateTime)) {
                date = timeFormat.parse(strDateTime);
                date = new Date(date.getTime());
                calendar.setTime(date);
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return calendar;
    }

    public static Long getInterval(String date1, String date2) {
        long minutes = (getDate(date2).getTimeInMillis() - getDate(date1)
                .getTimeInMillis()) / 60000;
        return minutes;
    }

    public static java.util.Date addTime(java.util.Date date, int amount,
                                         int field) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        c.add(field, amount);
        return c.getTime();
    }

    public static String getPassDateTime(String strDateTime, int iAmount,
                                         int field) {
        return dateToString(addTime(getDayTimeFromString(strDateTime), iAmount,
                field), ISO_EXPANDED_DATETIME_FORMAT);
    }

    public static String getBeginDateTimeFromDate(String strDate) {
        return StringUtils.validateString(strDate) + " 00:00:00";
    }

    public static String getEndDateTimeFromDate(String strDate) {
        return StringUtils.validateString(strDate) + " 23:59:59 ";
    }

    // 判断时间date1是否在时间date2之前
    // 时间格式 2005-4-21 16:16:34
    public static boolean isDateBefore(String date1, String date2) {
        try {
            DateFormat df = DateFormat.getDateTimeInstance();
            return df.parse(date1).before(df.parse(date2));
        } catch (ParseException e) {
            System.out.print(e.getMessage());
            return false;
        }
    }

    public static boolean isDateBefore(String date2) {
        if (!StringUtils.isValidateString(date2)) {
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

    public static String beginOfYear(int iYear) {
        return String.valueOf(iYear) + "-1-1";
    }

    public static String endOfYear(int iYear) {
        return String.valueOf(iYear) + "-12-31";
    }

    // Calendar.YEAR, year + 1900
    // the month value between 0-11 月份要先减1
    public static String getDateTime(int iYear, int iMonth, int iDay,
                                     int iHour, int iMinute, int iSecond) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        java.util.Date tmpDate = new java.util.Date();

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
        if (!StringUtils.isValidateString(strDateTime)) {
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
        if (!StringUtils.isValidateString(strDateTime)) {
            return "";
        }
        if (isValidateDateTime(strDateTime)) {
            String[] strDate = strDateTime.split(" ");
            return strDate[1];
        }
        return "";
    }

    /**
     * 周计数,为全年中的周计数
     *
     * @param year
     * @param weekCount
     * @return
     */
    public static String getWeekDateByWeekInYear(int year, int weekCount) {

        Calendar cal = Calendar.getInstance();
        // 设置calendar的日期,此处可以确定某一天
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, weekCount);

        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    /**
     * 周计数为月中的周计数
     *
     * @param year
     * @param month
     * @param weekCount
     * @return
     */
    public static String getWeekDateByWeekInMonth(int year, int month,
                                                  int weekCount) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.WEEK_OF_MONTH, weekCount);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    /**
     * 取日期加时间，无分隔符20110817103218
     *
     * @return
     */
    public static String getStringCurLongDate() {
        return StringUtils.replaceStr(getCurDate(), "-", "")
                + StringUtils.replaceStr(getCurTime(), ":", "");
    }

    public static String getDifferSecond(String date, long time) {

        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            java.util.Date begin = dfs.parse(date);
            // long time = 60;
            java.util.Date end = new java.util.Date(time * 1000
                    + begin.getTime());
            String endStr = dfs.format(end);

            // System.out.print(endStr);
            return endStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean getInSomeTime(String timestr, String begintime,
                                        String endtime) {
        boolean f = false;
        if (!StringUtils.isValidateString(timestr)
                || !StringUtils.isValidateString(begintime)
                || !StringUtils.isValidateString(endtime)) {
            return false;

        }
        Date time = null;
        Date timeBegin = null;
        Date timeEnd = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            time = sdf.parse(timestr);
            timeBegin = sdf.parse(begintime);
            timeEnd = sdf.parse(endtime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if ((time.before(timeEnd)) && (time.after(timeBegin))) {
            f = true;
        }
        return f;
    }

    public static boolean NewInSometime(String timestr, String begintime,
                                        String endtime) {
        boolean b = false;
        if (!StringUtils.isValidateString(timestr)
                || !StringUtils.isValidateString(begintime)
                || !StringUtils.isValidateString(endtime)) {
            return false;

        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        try {
            java.util.Date time = format.parse(timestr);
            java.util.Date begin = format.parse(begintime);
            java.util.Date end = format.parse(endtime);

            if (time.getTime() - begin.getTime() >= 0
                    && time.getTime() - end.getTime() <= 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return b;
    }

    public static String getSecondMove(String date, long time) {

        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (date.length() < 19) {
            return "";
        }
        try {

            java.util.Date begin = dfs.parse(date);
            // long time = 60;
            java.util.Date end = new java.util.Date(time * 1000
                    + begin.getTime());
            String endStr = dfs.format(end);

            // System.out.print(endStr);
            return endStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

    // 返回参数日期之间的秒数
    public static long daySubS(String Date1, String Date2) {

        long ll = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            java.util.Date time = format.parse(Date1);
            java.util.Date begin = format.parse(Date2);
            ll = time.getTime() - begin.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ll / 1000;

    }

    /**
     * 根据时间变量返回时间字符串 yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String datetoString(Date date) {
        return dateToString(date, ISO_EXPANDED_DATETIME_FORMAT);
    }

}
