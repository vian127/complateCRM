package com.pop136.customerservice.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	/**
	 * toSpilt(String str, String fu) 截取字符串放入List,通过&符号 checkString(String str)
	 * 验证字符串合法性（即该字符串不可以为null） 该方法不除去字符串中空格 replaceStr(String str, String
	 * oldStr, String newStr) 替换字符（区分大小写）用newStr 替换 str 中的oldStr
	 * replaceStrIgnoreCase(String str, String oldStr,String newStr)
	 * 替换字符（不区分大小写） 大小写都替换 用newStr 替换 str 中的oldStr escapeHTMLTags(String s)
	 * 将html格式转成&格式 <a>转&lt;a&gt; hash(String s) 将字符串转成MD5加密 encodeHex(byte
	 * abyte0[]) 将byte转成16进制数值 decodeHex(String s) 将16进制数值转成byte
	 * hexCharToByte(char c) 将16进制数值转成byte的子函数 toLowerCaseWordArray(String s)
	 * 将传入的string转换为String的数组，以“,\r\n.:/\\+”为分割符隔开的,并转为小写 toUpperCaseWord(String
	 * s) 将传入的string转换为String，以“,\r\n.:/\\+”为分割符隔开的,并转为大写，并用空格隔开
	 * removeCommonWords(String as[])
	 * 原意为将传入的String数组中的相同String去处，但是实际Testing并没有达到该功能 UN PASS TEST
	 * randomString(int i) 取随机的String 传入的i为取出的字符数 chopAtWord(String s, int i)
	 * 取String的第一个到第i个字符，包括第i个字符 example chopAtWord("abcdefg", 3) = "abc" \n后的不取
	 * escapeForXML(String s) 转xml格式的输入<a>为&lt;a&gt;格式 unescapeFromXML(String s)
	 * 转xml格式的&lt;a&gt;输入为 <a>格式 zeroPadString(String s, int i) 将传入的string前加i个零
	 * zeroPadString("ab",6);-->0000ab dateToMillis(Date date) 将传入的date前加零,加成15位
	 * dateToMillis(new Date());-->001187853901994 parseString(String s, String
	 * de) 把s中的字符，以de为分隔符分开，转成sring[] parseString("abacbacbababaaaa","b"); 转成 a
	 * ac convertArrayToSQLString(String[] convertArray)
	 * 将String[]转换成以单引号和逗号隔开的string a ac ac a a aaaa 转成
	 * convertStringToSQLString(String convertStr)
	 * 将String以","格开的转换成以单引号和逗号隔开的string a,ac,ac,a,a,aaaa 转成
	 * 'a','ac','ac','a','a','aaaa' unitArray(String src[], String de)
	 * 将String[]转换成以de隔开的string a ac ac a a aaaa 转成 a++ac++ac++a++a++aaaa
	 * convJavaUni(String langCode, String langStr) 把langStr 转成utf8
	 * encodeIsoString(String langCode, String langStr) 把langStr 转成utf8 (String
	 * strInputData) 左右全角半角空格去除 DivStrByFlag(String str, String flag) 字符串分割
	 * isValidateStringArray(String[] str) 验证是否是个有效的字符串数组 cutString(String str,
	 * String singleChar, boolean front) 从当前字符串中某个字符开始截取字符串 iso2gb(String str)
	 * 转换编码 maxInt(int int1, int int2, int int3, int int4) 获得最大值 maxSignInt(int
	 * int1, int int2) 获得最大值 convertInteger(String str) 将整数字符串转化为整数
	 * validateParity(String strInput) 判断是否是奇数偶数 false 奇数 true 偶数
	 * 如果输入的不是一个字符串，则返回true arrStringSplitByiFlag(String[] strContext, int
	 * iFlag) 将数组根据iFlag长度进行分割，转成mList equalsString(String str1, String str2)
	 * 判断String是否相同,大小写敏感 equalsIgnoreCaseString(String str1, String str2)
	 * 判断String是否相同,大小写不敏感 equalsIgnoreCaseString(String str1, int str2)
	 * 判断String是否相同,大小写不敏感 mergeArrayString(String[] sourceByte1,String[]
	 * sourceByte2) 合并两个String[] getArrBySpace(String strTemp, String strSplit)
	 * 把a,b,c,d 按照 strSplit 做 split 转成 string数组 gbk2utf8(String strTemp)
	 * gbk转utf8 getZeroString(int iTotalLenght, String strInput) 在strInput前补零
	 * getNumberDigit(int number) 获得一个整数位数 getStringNum(int number, int digit)
	 * 将数字转换含有0的数字字符串 int2str(Integer number) 将数字转换成字符串 long2str(Long number)
	 * 将数字转换成字符串 map2Str(HashMap<String, String> inMap, String strPrefix)
	 * hashmap转成string getHashMapLength(HashMap<String, String> inMap)
	 * 取得haspmap的长度 compareHashMap(HashMap<String, String> fromMap,
	 * HashMap<String, String> toMap) 判断两个map是否相同
	 *
	 * getFirstLetter(String str, String strDefaultValue) 获得字符串第一个字母
	 * getStringArrayValue(String[] str, int index) 从字符串数组中安全获得数组中某个元素的值(String
	 * 类型) getStringArrayLength(String[] str) 获得string 数组长度
	 * isArrContainsString(String[] str, String inStr) 忽略大小写
	 * 判断数组里的所有字符串和第二个字符串参数是否相同 如果都是非空并且所有字符串相同返回true，否则返回false
	 * isContainsString(String allStr, String subStr) 检验第一个字符串是否包含第二个字符串 如果有
	 * 返回true 如果没有返回false isOddEven(int para) 参数小于2返回true,大于2返回false
	 * validateTimestamp(Timestamp t) 将传进来的日期类型转换为字符串类型 getsrcbystateid(int t)
	 * 根据参数值返回不同的src属性值 randomIntNumber(int i) 取随机数字
	 */

	private static final char QUOTE_ENCODE[] = "&quot;".toCharArray();

	private static final char AMP_ENCODE[] = "&amp;".toCharArray();

	private static final char LT_ENCODE[] = "&lt;".toCharArray();

	private static final char GT_ENCODE[] = "&gt;".toCharArray();

	private static final char APOS_ENCODE[] = "&apos;".toCharArray();

	private static Object initLock = new Object();

	private static MessageDigest digest = null;

	private static final int fillchar = 61;

	private static final String cvt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

	private static final String commonWords[] = { "a", "and", "as", "at", "be", "do", "i", "if", "in", "is", "it", "so",
			"the", "to" };

	private static Map<String, String> commonWordsMap = null;

	private static Random randGen = null;

	private static char numbersAndLetters[] = null;

	private static final char zeroArray[] = "0000000000000000".toCharArray();

	// 首字母大写
	public static String captureName(String name) {
		// name = name.substring(0, 1).toUpperCase() + name.substring(1);
		// return name;
		char[] cs = name.toCharArray();
		cs[0] -= 32;
		return String.valueOf(cs);

	}

	public static String BigDecimalToString(BigDecimal b) {
		return b != null ? b.setScale(2, BigDecimal.ROUND_HALF_UP).toString() : "0";
	}

	public static void main(String[] args) throws Exception {


        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        //Collections.sort(names, (a, b) -> b.compareTo(a));
        System.out.println(names);


//		 Runnable r = () -> { System.out.println("hello world"); };
//		 r.run();
		// 这里不需要{}和return
		// java.util.Comparator<String> c2 = (String s1, String s2) ->
		// s2.length()-s1.length();
		// System.out.println(c2.compare("s1", "12323"));

		//Gson gson = new Gson();

		String str12 = UUID.randomUUID().toString();
		System.out.println(str12);
		String str1 = "http://wx.qlogo.cn/mmopen/pmgXibbY2UQNS3DBxmUNpSOO9icmrFZj5YkTWBfTxMWP2C4KjH0vqicQ69cdh0AqwDhlB6OZIf39GWW5ibuxVBQySibdWyo9ZkblW/0";
		System.out.println(str1.substring(0, 4));
		String PHONE = "20520596";

		System.out.println(PHONE.substring(0, 4));
		System.out.println(PHONE.substring(4));

		BigDecimal a11 = new BigDecimal(123.90222);
		System.out.println(a11 != null ? a11.setScale(2, BigDecimal.ROUND_HALF_UP).toString() : "0");
		String g = getDecimalFormatdouble(0);
		System.out.println(g + "----333333333333-----tony-----333366--");
		Calendar now = Calendar.getInstance();
		System.out.println("年: " + now.get(Calendar.YEAR));
		System.out.println("月: " + (now.get(Calendar.MONTH) + 1) + "");
		System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));
		System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY));
		System.out.println("分: " + now.get(Calendar.MINUTE));
		System.out.println("秒: " + now.get(Calendar.SECOND));
		System.out.println("当前时间毫秒数：" + now.getTimeInMillis());
		System.out.println(now.getTime());

		Date d = new Date();
		System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr = sdf.format(d);
		System.out.println("格式化后的日期：" + dateNowStr);

		/*
		 * String str = "2012-1-13 17:26:33"; //要跟上面sdf定义的格式一样 Date today =
		 * sdf.parse(str); System.out.println("字符串转成日期：" + today);
		 */

		System.out.println(UUID.randomUUID().toString());
		System.out.println("flag:" + isValidateString("-2"));
		Map<String, String> map = new HashMap<String, String>();
		System.out.println(map.containsKey("abc"));

		System.out.println(Integer.parseInt("5"));
		String Str = "6";
		System.out.println(Str.toUpperCase());

		System.out.println(getRandNum(6));

		String str = "A60900_C_ISCOMMENT";
		System.out.println(StringUtil.repalceString(str, "_C", ""));
		System.out.println(str.substring(0, 6));
		Integer i = 0;
		System.out.println(i + 1);

		String xt = "23万你买不了吃亏，也买不了上当，在北京连个厕所都买不了，现在却能买个逼格爆表的 特斯拉！";
		System.out.println(java.net.URLEncoder.encode(xt));
		System.out.println(java.net.URLEncoder.encode(java.net.URLEncoder.encode(xt)));
		String str_xt = "23%E4%B8%87%E4%BD%A0%E4%B9%B0%E4%B8%8D%E4%BA%86%E5%90%83%E4%BA%8F%EF%BC%8C%E4%B9%9F%E4%B9%B0%E4%B8%8D%E4%BA%86%E4%B8%8A%E5%BD%93%EF%BC%8C%E5%9C%A8%E5%8C%97%E4%BA%AC%E8%BF%9E%E4%B8%AA%E5%8E%95%E6%89%80%E9%83%BD%E4%B9%B0%E4%B8%8D%E4%BA%86%EF%BC%8C%E7%8E%B0%E5%9C%A8%E5%8D%B4%E8%83%BD%E4%B9%B0%E4%B8%AA%E9%80%BC%E6%A0%BC%E7%88%86%E8%A1%A8%E7%9A%84+%E7%89%B9%E6%96%AF%E6%8B%89%EF%BC%81";
		System.out.println(java.net.URLDecoder.decode(str_xt));

		String ee = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1f3dbde2d6969a65&redirect_uri=http://m.51mcr.com/mcr_weixin/weixin/mcr/mcr_pageDetail.bk?socialMediaID=456&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect&appURL=";

		ee += "http://10.10.8.32:8080/McrWeb/mobile/infomation.bk?1=1&pageSize=20&currPage=1&share_type=true&iswx=1&C_A51100_C_ID=&C_A60900_C_ID=";
		String de = "http%3A%2F%2F121.41.13.95%3A8080%2FMcrWeb%2Fmobile%2FgetArticleIfomation.bk%3FC_A60900_C_ID%3DA60900IAC00001-154B95D1F825H4FH8PBMA80U7FL2Q45I4%26pageSize%3D20%26currPage%3D1%26share_type%3Dfalse%26C_A62900_C_ID%3DA50100IAC00001-154A9C6C9667NE4F6UI0LE47EECI9U0US";
		System.out.println(java.net.URLDecoder.decode(de));
		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		// list1.add("3");
		// list1.add("4");
		String ZH = "";
		for (String string2 : list1) {
			ZH += string2 + ",";
		}
		System.out.println(ZH + "TONY-----------------");
		List<String> list2 = new ArrayList<String>();
		list2.add("3");
		list2.add("4");
		list2.add("5");
		String s = "";
		for (String string : list2) {

			string += ",";
			s += string;
		}
		System.out.println("+++++++ouye++++++" + s.lastIndexOf(","));

		System.out.println("+++++++ouye++++++" + s.substring(0, s.lastIndexOf(",")));
		System.out.println(toSpilt(s, ","));
		// list1.removeAll(list2);
		// list2.removeAll(list1);

		String D_DATE_TIME = "D_DATE_TIME";
		System.out.println(D_DATE_TIME.indexOf("D_"));

		Set<String> set = new HashSet<String>();
		set.add("abc");
		set.add("cde");
		set.add("efg");
		set.add("fgh");
		set.add("abc"); // 重复的abc,set会自动将其去掉
		System.out.println("size=" + set.size());

		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("aaa");
		list.add("fff");
		list.add("abc");
		System.out.println("ListSize=" + list.size());
		set.addAll(list); // 将list中的值加入set,并去掉重复的abc

		System.out.println("size=" + set.size());
		for (Iterator<String> it = set.iterator(); it.hasNext();) {
			System.out.println("value=" + it.next().toString());
		}

		String url_temp = "1@@@map/2-15/4.png";
		List<Object> temp = toSpilt(url_temp, "@@@");
		System.out.println(temp);

		System.out.println(subString("古古怪怪的温柔要说", 0, 6));

		// System.out.println(getComponentIDByBaseComponentID(new
		// U03100Form()));

		System.out.println(isContainsString("123456", "6"));

		

		System.out.println("111:" + repalceString("AA.BB", "\\.", "_"));

		String xxx = "Calcichew, Laevolac";
		String[] arr = getArrBySpace(xxx, ",");
		if (arr != null) {
			for (String x : arr) {
				System.out.println(x.trim());
			}
		}

		System.out.println("==========================");

		System.out.println(getTableNameByComponentID("123456"));

		System.out.println(endWith("aaa_id", "0id"));

		System.out.println(beginWith("Y,Y,Y", "Y"));
		System.out.println(beginWith("Y,Y,Y", "N"));

		System.out.println(getZeroString(5, "abc"));

		System.out.println("530401".indexOf("5304"));

		System.out.println("//yuiyiyou".substring(0, 2));

		System.out.println(cutBegin("123", "01"));
		// String ss =getDecimalFormat(3, ",", 123456);
		// String ss = getTotalCountBlank(1, 4, 2, "", "0");

		// String ss =
		// "[pricesell]=([baseprice]-[basecost])*[factor1]/10+[costsell]";
		// String ss = "[pricesell]=[baseprice]-[basecost]*1";
		// ArrayList sss = new ArrayList();
		// /*
		// baseprice
		// basecost
		// factor1
		// costsell
		// */
		//
		// sss.add(new String("baseprice"));
		// sss.add(new String("basecost"));
		// sss.add(new String("factor1"));
		// sss.add(new String("costsell"));
		// ArrayList sssss = getArrayListByString(ss, sss);
		// for (int j = 0; j < sssss.size(); j++) {
		// System.out.println(sssss.get(j));
		// }
		// HashMap hp = new HashMap();
		// hp.put("factor1", new Double(30));
		// hp.put("costsell", new Double(40));
		// hp.put("baseprice", new Double(20));
		// hp.put("basecost", new Double(10));
		//
		// ArrayList sssss = getPSValueByString(ss, hp);
		// for (int j = 0; j < sssss.size(); j++) {
		// System.out.println(sssss.get(j));
		// }
		// System.out.println("====================" + getPSBySQL(ss, "?"));
		// replace
		// System.out.println("cutEnd----" + cutEnd("abc =,,", ","));

		// String xxx = validateTwoString("22", null);
		// System.out.println(maxInt(1, 2, 3, 4));
		/*
		 * String ss1= convertStringToSQLString("a,b,c,d");
		 * System.out.println(ss1);
		 *
		 *
		 * String s1 = replaceStr("ababAba a","a","x"); System.out.println(s1);
		 * String s2 = replaceStrIgnoreCase("ababAba a","a","x");
		 * System.out.println(s2);
		 *
		 * String s3 = escapeHTMLTags("<a>"); System.out.println(s3);
		 *
		 * String s4 = hash("a"); System.out.println(s4);
		 *
		 * byte[] buffer = new byte[1]; buffer[0] = 125; String s5 =
		 * encodeHex(buffer); System.out.println(s5);
		 *
		 * System.out.println("========"); String s6 = encodeBase64("1");
		 * System.out.println(s6);
		 *
		 *
		 * String[] s7 = toLowerCaseWordArray("AND+NT");
		 * System.out.println(s7[0]); System.out.println(s7[1]);
		 *
		 * String s8 = toUpperCaseWord("and,nt"); System.out.println(s8);
		 *
		 * String[] s91 = new String[3]; s91[0] = "b1"; s91[1] = "b1"; s91[2] =
		 * "b1";
		 *
		 * String s9[] = removeCommonWords(s91); System.out.println(s9.length);
		 * System.out.println(s9[0]); System.out.println(s9[1]);
		 * System.out.println(s9[2]); System.out.println("========"); String s10
		 * = randomString(3); System.out.println(s10);
		 *
		 * String s11 = chopAtWord("abcd\t\nefg", 7); System.out.println(s11);
		 *
		 * String[] ss = new String[4]; ss[0] = "b"; ss[1] = "adc"; ss[2] = "d";
		 * ss[3] = "acd"; String s12 = highlightWords("abc", ss, "b", "b");
		 * System.out.println(s12);
		 *
		 * String s13 = escapeForXML("<a>"); System.out.println(s13);
		 *
		 * String s14 = unescapeFromXML("&lt;a&gt;"); System.out.println(s14);
		 *
		 * String s15 = zeroPadString("ab",6); System.out.println(s15);
		 *
		 * Date d = new Date(); String s16 = dateToMillis(d);
		 * System.out.println(s16);
		 *
		 * String[] s17 = null; s17 = parseString("abacbacbababaaaa","b");
		 * System.out.println(s17.length); System.out.println(s17[0]);
		 * System.out.println(s17[1]); System.out.println(s17[2]);
		 * System.out.println(s17[3]); System.out.println(s17[4]);
		 * System.out.println(s17[5]);
		 *
		 * String s18 = convertArrayToSQLString(s17); System.out.println(s18);
		 *
		 * String s19 = unitArray(s17,"++"); System.out.println(s19); // String
		 * s20 = revHTMLUni("gb2312", "斯多夫&#x;多&#x;斯多夫缩短"); //
		 * System.out.println(s20);
		 *
		 * String s21 = convJavaUni("ISO8859_1", "阿瑟缩短");
		 * System.out.println(s21);
		 *
		 * String s22= encodeIsoString("ISO8859_1","\u003f\u003f\u003f\u003f");
		 * System.out.println(s22);
		 */
		System.out.println(strConstantCount("aaaaaa", ","));

		double f = 0.5545;
		BigDecimal c = new BigDecimal(f);
		double f1 = c.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

		// * 100 + "%"
		System.out.println(f1 * 100 + "%" + "================");

		String g1 = getDecimalFormatdouble(f);
		System.out.println(g1 + "----333333333333-----tony-----333366--");

		String a = "123abc";
		String b = "1";
		System.out.println("********" + a.lastIndexOf(b));

		Double long1 = 1.00;// 经度
		Double lat1 = 1.00;// 纬度
		Double long2 = 33.00;// 经度
		Double lat2 = 33.00;// 纬度
		Double dd = Distance(long1, lat1, long2, lat2);
		System.out.println(dd + "pppppppppp");

	}

	public static String getDecimalFormatdouble(double dbAmount) {
		// DecimalFormat df = new DecimalFormat("######0.00");
		// String num=df.format(dbAmount);
		// double p=Double
		// .parseDouble(num);
		double rate = dbAmount;
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(2);// 设置保留小数位
		nf.setRoundingMode(RoundingMode.HALF_UP); // 设置舍入模式
		String percent = nf.format(rate);
		return (percent);
	}

	public static Object returnObjectByLength(List<Object> list, int i) {
		return list.get(i);
	}

	public static double getsun(double i) {
		BigDecimal b = new BigDecimal(i);
		double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}

	/**
	 * 截取字符串放入List,通过&符号toSpilt
	 *
	 * @param str
	 * @return
	 */
	public static List<Object> toSpilt(String str, String fu) {
		String[] s = str.split(fu);
		List<Object> list = new ArrayList<Object>();
		if (s.length <= 0) {
			return null;
		} else {
			for (int i = 0; i < s.length; i++) {
				if (equalsString(s[i].toString(), "")) {
					continue;
				}
				list.add(s[i]);
			}
			return list;
		}
	}

    /**
     * 截取字符串放入List,通过&符号toSpilt
     *
     * @param str
     * @return
     */
    public static List<String> toSpiltToString(String str, String fu) {
        String[] s = str.split(fu);
        List<String> list = new ArrayList<String>();
        if (s.length <= 0) {
            return null;
        } else {
            for (int i = 0; i < s.length; i++) {
                if (equalsString(s[i].toString(), "")) {
                    continue;
                }
                list.add(s[i]);
            }
            return list;
        }
    }
	/**
	 * 验证字符串合法性（即该字符串不可以为null） 该方法不除去字符串中空格
	 *
	 * @param str
	 *            String
	 * @return 如果为空就返回""
	 */
	public static String checkString(String str) {
		if (str == null || str.equalsIgnoreCase("null")) {
			return "";
		}

		if (str.equals("-2")) {
			return "";
		}
		if (str.equals("-3")) {
			return "";
		}

		/**
		 * 除去前后的空格
		 */
		return str.trim();
	}

	/*
	 * 替换字符（区分大小写）
	 *
	 * 用newStr 替换 str 中的oldStr
	 */
	public static String replaceStr(String str, String oldStr, String newStr) {
		if (str == null || newStr == null || oldStr == null || oldStr.trim().length() == 0)
			return "";
		int iE = str.indexOf(oldStr);
		int iB = 0;
		String temp = "";
		for (; iE != -1; iE = str.indexOf(oldStr, iB)) {
			temp = temp + str.substring(iB, iE) + newStr;
			iB = iE + oldStr.length();
		}

		if (iB < str.length())
			temp = temp + str.substring(iB);
		return temp;
	}

	/*
	 * 替换字符（不区分大小写） 大小写都替换 用newStr 替换 str 中的oldStr
	 */
	public static final String replaceStrIgnoreCase(String str, String oldStr, String newStr) {
		if (str == null || newStr == null || oldStr == null || oldStr.trim().length() == 0)
			return "";
		String s3 = str.toLowerCase();
		String s4 = oldStr.toLowerCase();
		int i = 0;
		if ((i = s3.indexOf(s4, i)) >= 0) {
			char ac[] = str.toCharArray();
			char ac1[] = newStr.toCharArray();
			int j = oldStr.length();
			StringBuffer stringbuffer = new StringBuffer(ac.length);
			stringbuffer.append(ac, 0, i).append(ac1);
			i += j;
			int k;
			for (k = i; (i = s3.indexOf(s4, i)) > 0; k = i) {
				stringbuffer.append(ac, k, i - k).append(ac1);
				i += j;
			}

			stringbuffer.append(ac, k, ac.length - k);
			return stringbuffer.toString();
		} else {
			return str;
		}
	}

	public static final String replaceStr(String str, String oldStr, String newStr, int ai[]) {
		if (str == null || newStr == null || oldStr == null || oldStr.trim().length() == 0)
			return "";
		int i = 0;
		if ((i = str.indexOf(oldStr, i)) >= 0) {
			int j = 0;
			j++;
			char ac[] = str.toCharArray();
			char ac1[] = newStr.toCharArray();
			int k = oldStr.length();
			StringBuffer stringbuffer = new StringBuffer(ac.length);
			stringbuffer.append(ac, 0, i).append(ac1);
			i += k;
			int l;
			for (l = i; (i = str.indexOf(oldStr, i)) > 0; l = i) {
				j++;
				stringbuffer.append(ac, l, i - l).append(ac1);
				i += k;
			}

			stringbuffer.append(ac, l, ac.length - l);
			ai[0] = j;
			return stringbuffer.toString();
		} else {
			return str;
		}
	}

	/*
	 * 将html格式转成&格式 <a>转&lt;a&gt;
	 */
	public static final String escapeHTMLTags(String s) {
		if (s == null)
			return null;
		int i = 0;
		int j = 0;
		char ac[] = s.toCharArray();
		int k = ac.length;
		StringBuffer stringbuffer = new StringBuffer((int) ((double) k * 1.3D));
		for (; i < k; i++) {
			char c = ac[i];
			if (c <= '>')
				if (c == '<') {
					if (i > j)
						stringbuffer.append(ac, j, i - j);
					j = i + 1;
					stringbuffer.append(LT_ENCODE);
				} else if (c == '>') {
					if (i > j)
						stringbuffer.append(ac, j, i - j);
					j = i + 1;
					stringbuffer.append(GT_ENCODE);
				}
		}

		if (j == 0)
			return s;
		if (i > j)
			stringbuffer.append(ac, j, i - j);
		return stringbuffer.toString();
	}

	/*
	 * 将字符串转成MD5加密
	 */
	public static final synchronized String hash(String s) {
		if (digest == null)
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException nosuchalgorithmexception) {
				System.err.println("Failed to load the MD5 MessageDigest. Jive will be unable to function normally.");
				nosuchalgorithmexception.printStackTrace();
			}
		digest.update(s.getBytes());
		return encodeHex(digest.digest());
	}

	/*
	 * 将byte转成16进制数值
	 */
	public static final String encodeHex(byte abyte0[]) {
		StringBuffer stringbuffer = new StringBuffer(abyte0.length * 2);
		for (int i = 0; i < abyte0.length; i++) {
			if ((abyte0[i] & 0xff) < 16)
				stringbuffer.append("0");
			stringbuffer.append(Long.toString(abyte0[i] & 0xff, 16));
		}

		return stringbuffer.toString();
	}

	/*
	 * 将16进制数值转成byte
	 */
	public static final byte[] decodeHex(String s) {
		char ac[] = s.toCharArray();
		byte abyte0[] = new byte[ac.length / 2];
		int i = 0;
		for (int j = 0; j < ac.length; j += 2) {
			byte byte0 = 0;
			byte0 |= hexCharToByte(ac[j]);
			byte0 <<= 4;
			byte0 |= hexCharToByte(ac[j + 1]);
			abyte0[i] = byte0;
			i++;
		}

		return abyte0;
	}

	/*
	 * 将16进制数值转成byte的子函数
	 */
	private static final byte hexCharToByte(char c) {
		switch (c) {
		case 48: // '0'
			return 0;

		case 49: // '1'
			return 1;

		case 50: // '2'
			return 2;

		case 51: // '3'
			return 3;

		case 52: // '4'
			return 4;

		case 53: // '5'
			return 5;

		case 54: // '6'
			return 6;

		case 55: // '7'
			return 7;

		case 56: // '8'
			return 8;

		case 57: // '9'
			return 9;

		case 97: // 'a'
			return 10;

		case 98: // 'b'
			return 11;

		case 99: // 'c'
			return 12;

		case 100: // 'd'
			return 13;

		case 101: // 'e'
			return 14;

		case 102: // 'f'
			return 15;

		case 58: // ':'
		case 59: // ';'
		case 60: // '<'
		case 61: // '='
		case 62: // '>'
		case 63: // '?'
		case 64: // '@'
		case 65: // 'A'
		case 66: // 'B'
		case 67: // 'C'
		case 68: // 'D'
		case 69: // 'E'
		case 70: // 'F'
		case 71: // 'G'
		case 72: // 'H'
		case 73: // 'I'
		case 74: // 'J'
		case 75: // 'K'
		case 76: // 'L'
		case 77: // 'M'
		case 78: // 'N'
		case 79: // 'O'
		case 80: // 'P'
		case 81: // 'Q'
		case 82: // 'R'
		case 83: // 'S'
		case 84: // 'T'
		case 85: // 'U'
		case 86: // 'V'
		case 87: // 'W'
		case 88: // 'X'
		case 89: // 'Y'
		case 90: // 'Z'
		case 91: // '['
		case 92: // '\\'
		case 93: // ']'
		case 94: // '^'
		case 95: // '_'
		case 96: // '`'
		default:
			return 0;
		}
	}

	public static String encodeBase64(String s) {
		return encodeBase64(s.getBytes());
	}

	public static String encodeBase64(byte abyte0[]) {
		int l = abyte0.length;
		StringBuffer stringbuffer = new StringBuffer((l / 3 + 1) * 4);
		for (int i1 = 0; i1 < l; i1++) {
			int i = abyte0[i1] >> 2 & 0x3f;
			stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(i));
			i = abyte0[i1] << 4 & 0x3f;
			if (++i1 < l)
				i |= abyte0[i1] >> 4 & 0xf;
			stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(i));
			if (i1 < l) {
				int j = abyte0[i1] << 2 & 0x3f;
				if (++i1 < l)
					j |= abyte0[i1] >> 6 & 0x3;
				stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(j));
			} else {
				i1++;
				stringbuffer.append('=');
			}
			if (i1 < l) {
				int k = abyte0[i1] & 0x3f;
				stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(k));
			} else {
				stringbuffer.append('=');
			}
		}

		return stringbuffer.toString();
	}

	public static String decodeBase64(String s) {
		return decodeBase64(s.getBytes());
	}

	public static String decodeBase64(byte abyte0[]) {
		int k = abyte0.length;
		StringBuffer stringbuffer = new StringBuffer((k * 3) / 4);
		for (int l = 0; l < k; l++) {
			int i = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(abyte0[l]);
			l++;
			int j = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(abyte0[l]);
			i = i << 2 | j >> 4 & 0x3;
			stringbuffer.append((char) i);
			if (++l < k) {
				i = abyte0[l];
				if (61 == i)
					break;
				i = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf((char) i);
				j = j << 4 & 0xf0 | i >> 2 & 0xf;
				stringbuffer.append((char) j);
			}
			if (++l >= k)
				continue;
			j = abyte0[l];
			if (61 == j)
				break;
			j = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf((char) j);
			i = i << 6 & 0xc0 | j;
			stringbuffer.append((char) i);
		}

		return stringbuffer.toString();
	}

	/*
	 * 将传入的string转换为String的数组，以“,\r\n.:/\\+”为分割符隔开的,并转为小写
	 */
	public static final String[] toLowerCaseWordArray(String s) {
		if (s == null || s.length() == 0)
			return new String[0];
		StringTokenizer stringtokenizer = new StringTokenizer(s, " ,\r\n.:/\\+");
		String as[] = new String[stringtokenizer.countTokens()];
		for (int i = 0; i < as.length; i++)
			as[i] = stringtokenizer.nextToken().toLowerCase();

		return as;
	}

	/*
	 * 将传入的string转换为String，以“,\r\n.:/\\+”为分割符隔开的,并转为大写，并用空格隔开
	 */
	public static final String toUpperCaseWord(String s) {
		StringTokenizer stringtokenizer = new StringTokenizer(s, " ,\r\n.:/\\+");
		StringBuffer sb = new StringBuffer(s.length());
		String as[] = new String[stringtokenizer.countTokens()];
		char ac[];
		for (int i = 0; i < as.length; i++) {
			as[i] = stringtokenizer.nextToken().toLowerCase();
			ac = new char[as[i].length()];
			ac = as[i].toCharArray();
			ac[0] = Character.toUpperCase(ac[0]);
			as[i] = new String(ac);
			sb.append(" " + as[i]);
		}
		return sb.toString();
	}

	/*
	 * 原意为将传入的String数组中的相同String去处，但是实际Testing并没有达到该功能 UN PASS TEST
	 */
	public static final String[] removeCommonWords(String as[]) {
		if (commonWordsMap == null)
			synchronized (initLock) {
				if (commonWordsMap == null) {
					commonWordsMap = new HashMap<String, String>();
					for (int i = 0; i < commonWords.length; i++)
						commonWordsMap.put(commonWords[i], commonWords[i]);

				}
			}
		ArrayList<String> arraylist = new ArrayList<String>(as.length);
		for (int j = 0; j < as.length; j++)
			if (!commonWordsMap.containsKey(as[j]))
				arraylist.add(as[j]);

		return arraylist.toArray(new String[arraylist.size()]);
	}

	/*
	 * 取随机的String 传入的i为取出的字符数
	 */
	public static final String randomString(int i) {
		if (i < 1)
			return null;
		if (randGen == null)
			synchronized (initLock) {
				if (randGen == null) {
					randGen = new Random();
					numbersAndLetters = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
							.toCharArray();
				}
			}
		char ac[] = new char[i];
		for (int j = 0; j < ac.length; j++)
			ac[j] = numbersAndLetters[randGen.nextInt(71)];

		return new String(ac);
	}

	/*
	 * 取String的第一个到第i个字符，包括第i个字符 example chopAtWord("abcdefg", 3) = "abc" \n后的不取
	 */
	public static final String chopAtWord(String s, int i) {
		if (s == null)
			return s;
		char ac[] = s.toCharArray();
		int j = s.length();
		if (i < j)
			j = i;
		for (int k = 0; k < j - 1; k++) {
			if (ac[k] == '\r' && ac[k + 1] == '\n')
				return s.substring(0, k + 1);
			if (ac[k] == '\n')
				return s.substring(0, k);
		}

		if (ac[j - 1] == '\n')
			return s.substring(0, j - 1);
		if (s.length() < i)
			return s;
		for (int l = i - 1; l > 0; l--)
			if (ac[l] == ' ')
				return s.substring(0, l).trim();

		return s.substring(0, i);
	}

	public static final String highlightWords(String s, String as[], String s1, String s2) {
		if (s == null || as == null || s1 == null || s2 == null)
			return null;
		for (int i = 0; i < as.length; i++) {
			String s3 = s.toLowerCase();
			char ac[] = s.toCharArray();
			String s4 = as[i].toLowerCase();
			int j = 0;
			if ((j = s3.indexOf(s4, j)) >= 0) {
				int k = s4.length();
				StringBuffer stringbuffer = new StringBuffer(ac.length);
				boolean flag = false;
				char c = ' ';
				if (j - 1 > 0) {
					c = ac[j - 1];
					if (!Character.isLetter(c))
						flag = true;
				}
				boolean flag2 = false;
				char c2 = ' ';
				if (j + k < ac.length) {
					c2 = ac[j + k];
					if (!Character.isLetter(c2))
						flag2 = true;
				}
				if (flag && flag2 || j == 0 && flag2) {
					stringbuffer.append(ac, 0, j);
					if (flag && c == ' ')
						stringbuffer.append(c);
					stringbuffer.append(s1);
					stringbuffer.append(ac, j, k).append(s2);
					if (flag2 && c2 == ' ')
						stringbuffer.append(c2);
				} else {
					stringbuffer.append(ac, 0, j);
					stringbuffer.append(ac, j, k);
				}
				j += k;
				int l;
				for (l = j; (j = s3.indexOf(s4, j)) > 0; l = j) {
					boolean flag1 = false;
					char c1 = ac[j - 1];
					if (!Character.isLetter(c1))
						flag1 = true;
					boolean flag3 = false;
					if (j + k < ac.length) {
						c2 = ac[j + k];
						if (!Character.isLetter(c2))
							flag3 = true;
					}
					if (flag1 && flag3 || j + k == ac.length) {
						stringbuffer.append(ac, l, j - l);
						if (flag1 && c1 == ' ')
							stringbuffer.append(c1);
						stringbuffer.append(s1);
						stringbuffer.append(ac, j, k).append(s2);
						if (flag3 && c2 == ' ')
							stringbuffer.append(c2);
					} else {
						stringbuffer.append(ac, l, j - l);
						stringbuffer.append(ac, j, k);
					}
					j += k;
				}

				stringbuffer.append(ac, l, ac.length - l);
				s = stringbuffer.toString();
			}
		}

		return s;
	}

	/*
	 * 转xml格式的输入<a>为&lt;a&gt;格式
	 */
	public static final String escapeForXML(String s) {
		if (s == null)
			return null;
		int i = 0;
		int j = 0;
		char ac[] = s.toCharArray();
		int k = ac.length;
		StringBuffer stringbuffer = new StringBuffer((int) ((double) k * 1.3D));
		for (; i < k; i++) {
			char c = ac[i];
			if (c <= '>')
				if (c == '<') {
					if (i > j)
						stringbuffer.append(ac, j, i - j);
					j = i + 1;
					stringbuffer.append(LT_ENCODE);
				} else if (c == '&') {
					if (i > j)
						stringbuffer.append(ac, j, i - j);
					j = i + 1;
					stringbuffer.append(AMP_ENCODE);
				} else if (c == '"') {
					if (i > j)
						stringbuffer.append(ac, j, i - j);
					j = i + 1;
					stringbuffer.append(QUOTE_ENCODE);
				}
			if (c == '>') {
				if (i > j)
					stringbuffer.append(ac, j, i - j);
				j = i + 1;
				stringbuffer.append(GT_ENCODE);
			}
		}

		if (j == 0)
			return s;
		if (i > j)
			stringbuffer.append(ac, j, i - j);
		return stringbuffer.toString();
	}

	/*
	 * 转xml格式的&lt;a&gt;输入为 <a>格式
	 */
	public static final String unescapeFromXML(String s) {
		s = replaceStr(s, "&lt;", "<");
		s = replaceStr(s, "&gt;", ">");
		s = replaceStr(s, "&quot;", "\"");
		return replaceStr(s, "&amp;", "&");
	}

	/*
	 * 将传入的string前加i个零 zeroPadString("ab",6);-->0000ab
	 */
	public static final String zeroPadString(String s, int i) {
		StringBuffer stringbuffer = new StringBuffer(i);
		stringbuffer.append(zeroArray, 0, i - s.length()).append(s);
		return stringbuffer.toString();
	}

	/*
	 * 将传入的date前加零,加成15位 dateToMillis(new Date());-->001187853901994
	 */
	public static final String dateToMillis(Date date) {
		return zeroPadString(Long.toString(date.getTime()), 15);
	}

	/*
	 * 把s中的字符，以de为分隔符分开，转成sring[] parseString("abacbacbababaaaa","b"); 转成 a ac
	 * ac a a aaaa
	 */
	public static String[] parseString(String s, String de) {
		if (s == null || de == null || s.equals("") || de.equals(""))
			return null;

		int i = 1;
		for (int j = 0; j < s.length(); j++)
			if (s.charAt(j) == de.charAt(0))
				i++;

		String as[] = new String[i];
		StringTokenizer stringtokenizer = new StringTokenizer(s, de);
		for (int k = 0; stringtokenizer.hasMoreTokens(); k++)
			as[k] = stringtokenizer.nextToken();

		return as;
	}

	/*
	 * 将String[]转换成以单引号和逗号隔开的string a ac ac a a aaaa 转成
	 * 'a','ac','ac','a','a','aaaa'
	 */
	public static String convertArrayToSQLString(String[] convertArray) {
		String tmpString = null;
		if (convertArray != null) {
			for (int i = 0; i < convertArray.length; i++)

			{
				if (convertArray[i] != null)
					if (tmpString == null)
						tmpString = "'" + convertArray[i] + "'";
					else
						tmpString = tmpString + "'" + convertArray[i] + "'";
				if (i < convertArray.length - 1)
					tmpString = tmpString + ",";
			}
		}
		return tmpString;

	}

	/*
	 * 将String以","格开的转换成以单引号和逗号隔开的string a,ac,ac,a,a,aaaa 转成
	 * 'a','ac','ac','a','a','aaaa'
	 */
	public static String convertStringToSQLString(String convertStr) {
		String tmpString = null;
		if ((convertStr != null) && (!(convertStr.trim().equals("")))) {
			String[] convertArray = convertStr.split(",");
			for (int i = 0; i < convertArray.length; i++)

			{
				if (convertArray[i] != null)
					if (tmpString == null)
						tmpString = "'" + convertArray[i] + "'";
					else
						tmpString = tmpString + "'" + convertArray[i] + "'";
				if (i < convertArray.length - 1)
					tmpString = tmpString + ",";
			}

		} else {
			tmpString = "''";
		}
		return tmpString;
	}

	public static String convertStringToLikeSQLString(String convertStr) {
		return "'%" + convertStr + "%'";
	}

	/*
	 * 将String[]转换成以de隔开的string a ac ac a a aaaa 转成 a++ac++ac++a++a++aaaa
	 */
	public static final String unitArray(String src[], String de) {
		String temp = "";
		if (src != null) {
			for (int j = 0; j < src.length; j++) {
				temp += src[j] + de;
			}
		}
		return temp.substring(0, temp.length() - de.length());
	}

	public static String revHTMLUni(String langCode, String langStr) {
		int startIndex = 0, curIndex = 0, curChar = 0;
		char c;
		Character A;
		String myStr = "";
		while (langStr.indexOf("&#", startIndex) != -1) {
			curIndex = langStr.indexOf("&#", startIndex);
			curChar = Integer.parseInt(langStr.substring(curIndex + 2, langStr.indexOf(";", curIndex)));
			c = (char) curChar;
			A = new Character(c);

			try {
				myStr = new String(A.toString().getBytes(langCode), "ISO8859-1");
			} catch (UnsupportedEncodingException ul) {
			}

			langStr = replaceStr(langStr, "&#" + curChar + ";", myStr);
		}
		return langStr;
	}

	public static String convHTMLUni(String langCode, String langStr) {
		if (langStr == null || langCode == null)
			return "";

		char c;
		Character C;
		int intChar = 0;
		String myStr = null;
		StringBuffer stringBuf = new StringBuffer();

		try {
			myStr = new String(langStr.toString().getBytes("ISO8859-1"), langCode);
		} catch (UnsupportedEncodingException ul) {
		}

		int strLen = myStr.length();
		char mychar[] = new char[strLen];
		myStr.getChars(0, strLen - 1, mychar, 0);

		for (int i = 0; i < strLen; i++) {
			c = myStr.charAt(i);

			if (c > '\377') {
				C = new Character(c);
				intChar = C.hashCode();
				stringBuf.append("&#" + intChar + ";");
			} else {
				stringBuf.append(c);
			}
		}

		return stringBuf.toString();
	}

	/*
	 * 把langStr 转成utf8
	 */
	public static String convJavaUni(String langCode, String langStr) {
		try {
			StringBuffer stringBuf = new StringBuffer();
			String converttext = new String(langStr.toString().getBytes("ISO8859-1"), langCode);
			int strLen = converttext.length();
			for (int i = 0; i < strLen; i++) {
				char c = converttext.charAt(i);
				stringBuf.append("\\u" + charToHex(c));
			}

			return stringBuf.toString();

		} catch (UnsupportedEncodingException uee) {
			return uee.toString();
		}
	}

	public static String charToHex(char c) {
		// Returns hex String representation of char c
		byte hi = (byte) (c >>> 8);
		byte lo = (byte) (c & 0xff);
		return byteToHex(hi) + byteToHex(lo);
	}

	public static String byteToHex(byte b) {
		// Returns hex String representation of byte b
		char hexDigit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		char[] array = { hexDigit[(b >> 4) & 0x0f], hexDigit[b & 0x0f] };
		return new String(array);
	}

	/*
	 * 把langStr 转成utf8
	 */
	public static String encodeIsoString(String langCode, String langStr) {
		if (langStr == null) {
			return "";
		}
		// langStr = emp.string.StringUtil.replace(langStr, "\'", "&acute;");
		langStr = replaceStr(langStr, "\"", "&quot;");
		try {
			if (langCode != null && langCode.equals("gb2312")) {
				byte abyte0[] = langStr.getBytes("ISO8859_1");
				return new String(abyte0, "GB2312");
			}
			if (langCode != null && langCode.equals("big5")) {
				byte abyte0[] = langStr.getBytes("ISO8859_1");
				return new String(abyte0, "BIG5");
			}
			if (langCode != null && langCode.equals("iso8859-1")) {
				return langStr;
			}
			return langStr;
		} catch (Exception e) {
			return langStr;
		}
	}

	// /****************************************///

	public static String GB2Unicode(String str) {
		try {
			if (str == null) {
				return null;
			} else {
				String str2 = new String(str.getBytes("iso8859-1"));
				return str2;
			}
		} catch (Throwable _ex) {
			return null;
		}
	}

	public static int getStrLength(String str) {
		try {
			if (str == null || str.trim().length() == 0) {
				return 0;
			} else {
				int iLeng = str.getBytes().length;
				return iLeng;
			}
		} catch (Throwable _ex) {
			return 50000;
		}
	}

	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception _ex) {
			return false;
		}
	}

	public static boolean isNumeric(String str) {
		if (str == null)
			return false;
		int dom = 0;
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) != '.') {
				if ((i != 0 || !str.substring(0, 1).equalsIgnoreCase("-"))
						&& (str.charAt(i) > '9' || str.charAt(i) < '0'))
					return false;
			} else if (++dom > 1)
				return false;

		return true;
	}

	// public static void main(String args[]) {
	// String s = ".00";
	// s = setScale(s, 2);
	// }

	public static String[] parseStr(String str, String chars) {
		if (str == null || chars == null)
			return null;
		else
			return null;
	}

	public static String setScale(String str, int scale) {
		if (str == null || str.trim().length() == 0)
			return "";
		try {
			BigDecimal bd = new BigDecimal(str);
			BigDecimal bd1 = bd.setScale(scale, 5);
			return bd1.toString();
		} catch (Exception e) {
			System.out.print("e =============" + str + " " + scale);
			e.printStackTrace();
			System.out.print("e =============" + e.getMessage());
			return "0";
		}
	}

	public static float str2float(String str) {
		if (str == null)
			return 0.0F;
		try {
			return Float.valueOf(str).floatValue();
		} catch (Exception _ex) {
			return 0.0F;
		}
	}

	public static BigDecimal str2BigDecimal(String str) {
		if (str == null)
			return new BigDecimal(0);
		try {
			return new BigDecimal(str);
		} catch (Exception _ex) {
			return new BigDecimal(0);
		}
	}

	public static int str2int(String str) {
		if (str == null)
			return 0;
		try {
			return Integer.parseInt(str);
		} catch (Exception _ex) {
			return 0;
		}
	}

	public static String Unicode2GB(Object obj) {
		try {
			if (obj == null)
				return null;
			if (obj.getClass() != java.lang.String.class) {
				return obj + "";
			} else {
				String str2 = new String(obj.toString().getBytes("gb2312"), "8859_1");
				return str2;
			}
		} catch (Throwable _ex) {
			return null;
		}
	}

	public static String changeToGBK(String s) {
		String tempStr = "";
		try {
			tempStr = new String(s.getBytes("ISO8859_1"), "GBK");
		} catch (Exception ex) {
			tempStr = s;
		}

		return tempStr;
	}

	/**
	 * 左右全角半角空格去除
	 *
	 * strInputData
	 * 
	 * @author Michael Yang
	 */
	public static String trimS(String strInputData) {
		String strStart = "";
		String strEnd = "";
		boolean flag = true;

		if (strInputData.length() == 0)
			return strInputData;
		while (flag) {
			strStart = strInputData.substring(0, 1);
			strEnd = strInputData.substring(strInputData.length() - 1);
			if (strEnd.equalsIgnoreCase("　") || strEnd.equalsIgnoreCase(" ")) {
				strInputData = strInputData.substring(0, strInputData.length() - 1);
				if (strInputData.length() == 0)
					flag = false;
			} else if (strStart.equalsIgnoreCase("　") || strStart.equalsIgnoreCase(" ")) {
				strInputData = strInputData.substring(1, strInputData.length());
				if (strInputData.length() == 0)
					flag = false;
			} else {
				flag = false;
			}
		}
		return strInputData;
	}

	/*
	 * public static Vector DivStrByFlag(String str,String flag){ Vector vec =
	 * new Vector(); try{ StringTokenizer st = new StringTokenizer(str,flag);
	 * while (st.hasMoreTokens()) { vec.add(st.nextToken()); } } catch(Exception
	 * e){ System.out.print("字符串分解错误"+e); } return vec; }
	 */

	// 字符串分割
	// str：需要分割的字符串 flag：分割符
	// 返回Vector
	public static Vector<String> DivStrByFlag(String str, String flag) {

		Vector<String> v = new Vector<String>();
		String str1 = new String();
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i + 1).equals(flag)) {
				v.add(str1);
				str1 = new String();
			} else {
				str1 += str.charAt(i);
			}
		}

		v.add(str1);
		return v;

		/*
		 * String array[]; array=new String[v.size()];
		 *
		 * for(int i=0;i<array.length;i++) { array[i]=new
		 * String((String)v.elementAt(i)); } return array;
		 */
	}

	/**
	 *
	 * @param strTemp
	 * @return
	 */
	public static boolean isValidateString(String strTemp) {
		boolean b = false;
		if ((strTemp != null) && !(strTemp.trim().equals("-2")) && (!(strTemp.trim().equals("")))
				&& (!(strTemp.trim().equalsIgnoreCase("null")))) {
			b = true;
		}
		return b;
	}

	/**
	 * 验证是否是个有效的字符串数组
	 *
	 * @param str
	 * @return
	 */
	public static boolean isValidateStringArray(String[] str) {
		if (str == null || str.length <= 0) {
			return false;
		}
		return true;
	}

	public static boolean isValidateBlackString(String strTemp) {
		boolean b = false;
		if ((strTemp != null) && (!(strTemp.trim().equalsIgnoreCase("null")))) {
			b = true;
		}
		return b;
	}

	public static boolean isValidateInt(int iTemp) {
		boolean b = false;
		if (true) {
			b = true;
		}
		return b;
	}

	public static String validateString(String strTemp) {
		String b = "";
		if ((strTemp != null) && (!(strTemp.trim().equals(""))) && (!(strTemp.trim().equalsIgnoreCase("null")))) {
			b = strTemp;
		}
		return b.trim();
	}

	public static String validateDate(String strTemp) {
		String b = "";
		if ((strTemp != null) && (!(strTemp.trim().equals(""))) && (!(strTemp.trim().equalsIgnoreCase("null")))
				&& (!(strTemp.trim().equals("0000-00-00")))) {
			b = strTemp;
		}
		return b;
	}

	public static String validateTrimString(String strTemp) {
		String b = "";
		if ((strTemp != null) && (!(strTemp.trim().equals(""))) && (!(strTemp.trim().equalsIgnoreCase("null")))) {
			b = strTemp.trim();
		}
		return b;
	}

	public static String ValidateInt(int iTemp) {
		String b = "";
		if ((!(iTemp == 0))) {
			b = String.valueOf(iTemp);
		}
		return b;
	}

	public static String ValidateDouble(Double dbTemp) {
		String b = "";
		if ((dbTemp != null) && (!(dbTemp == 0))) {
			b = String.valueOf(dbTemp);
		}
		return b;
	}

	public static String validateBlackString(String strTemp) {
		String b = "9";
		if ((strTemp != null) && (!(strTemp.trim().equals(""))) && (!(strTemp.trim().equalsIgnoreCase("null")))) {
			b = strTemp;
		}
		return b;
	}

	public static String cutEnd(String strTemp, String strCut) {
		String b = "";
		if ((strTemp != null) && (!(strTemp.trim().equals(""))) && (!(strTemp.trim().equalsIgnoreCase("null")))) {
			if ((strTemp.substring(strTemp.length() - 1)).equals(strCut)) {
				b = strTemp.substring(0, strTemp.length() - 1);
			} else {
				b = strTemp;
			}
		}
		return b;
	}

	public static String cutBegin(String strTemp, String strCut) {
		String b = "";
		if ((strTemp != null) && (!(strTemp.trim().equals(""))) && (!(strTemp.trim().equalsIgnoreCase("null")))) {
			if ((strTemp.substring(0, strCut.length())).equals(strCut)) {
				b = strTemp.substring(strCut.length(), strTemp.length());
			} else {
				b = strTemp;
			}
		}
		return b;
	}

	/**
	 * 从当前字符串中某个字符开始截取字符串
	 *
	 * @param str
	 *            String
	 * @param singleChar
	 *            String字符标记
	 * @param front
	 *            boolean 如果值为true表式截取标记字符前面的字符，反之相反
	 * @return 截取后字符串
	 */
	public static String cutString(String str, String singleChar, boolean front) {
		if (!isValidateString(str)) {
			return "";
		}
		if (!isValidateString(singleChar)) {
			return "";
		}
		str = str.trim();
		singleChar = singleChar.trim();
		if (str.contains(singleChar)) {
			int index = str.indexOf(singleChar);
			if (front) {
				return str.substring(0, index);
			} else {
				return str.substring(index + 1, str.length());
			}
		} else {
			return str;
		}
	}

	public static boolean beginWith(String strWhole, String strSub) {
		if (StringUtil.isValidateString(strWhole) && (StringUtil.isValidateString(strSub))) {
			if ((StringUtil.validateString(strWhole).indexOf(StringUtil.validateString(strSub))) == 0) {
				return true;
			}
		}
		return false;
	}

	public static boolean endWith(String strWhole, String strSub) {
		if (StringUtil.isValidateString(strWhole) && (StringUtil.isValidateString(strSub))) {
			if ((StringUtil.validateString(strWhole)
					.lastIndexOf(StringUtil.validateString(strSub))) == ((StringUtil.validateString(strWhole).length()
							- (StringUtil.validateString(strSub)).length()))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 转换编码
	 *
	 * @param str
	 * @return
	 */
	public static String iso2gb(String str) {
		String result = "";
		try {
			byte[] tmp = str.getBytes("ISO8859_1");
			result = new String(tmp, "GBK");
		} catch (Exception e) {
			System.out.println("convert iso2gb error: " + e.getLocalizedMessage());
		}

		return result;
	}

	/**
	 * 获得最大值
	 *
	 * @param int1
	 * @param int2
	 * @param int3
	 * @param int4
	 * @return
	 */
	public static int maxInt(int int1, int int2, int int3, int int4) {
		int result = int1;
		if (int2 > result) {
			result = int2;
		}
		if (int3 > result) {
			result = int3;
		}
		if (int4 > result) {
			result = int4;
		}

		return result;
	}

	/**
	 * 获得最大值
	 *
	 * @param int1
	 * @param int2
	 * @return
	 */
	public static int maxSignInt(int int1, int int2) {
		int result = int1;
		if (int2 > result) {
			result = int2;
		}

		return result;
	}

	public static String validateString(String str1, String str2) {
		String b = "";
		String b1 = "";
		String b2 = "";
		if ((str1 != null) && (!(str1.trim().equals(""))) && (!(str1.trim().equalsIgnoreCase("null")))) {
			b1 = str1;
		}
		if ((str2 != null) && (!(str2.trim().equals(""))) && (!(str2.trim().equalsIgnoreCase("null")))) {
			b2 = str2;
		}
		if (isValidateString(b2)) {
			b = b2;
		}
		if (isValidateString(b1)) {
			b = b1;
		}
		return b;
	}

	public static String validateString(String str1, String str2, String str3) {
		String b = "";
		String b1 = "";
		String b2 = "";
		String b3 = "";
		if ((str1 != null) && (!(str1.trim().equals(""))) && (!(str1.trim().equalsIgnoreCase("null")))) {
			b1 = str1;
		}
		if ((str2 != null) && (!(str2.trim().equals(""))) && (!(str2.trim().equalsIgnoreCase("null")))) {
			b2 = str2;
		}
		if ((str3 != null) && (!(str3.trim().equals(""))) && (!(str3.trim().equalsIgnoreCase("null")))) {
			b3 = str3;
		}
		if (isValidateString(b3)) {
			b = b3;
		}
		if (isValidateString(b2)) {
			b = b2;
		}
		if (isValidateString(b1)) {
			b = b1;
		}
		return b;
	}

	public static String validateString(String str1, String str2, String str3, String str4) {
		String b = "";
		String b1 = "";
		String b2 = "";
		String b3 = "";
		String b4 = "";
		if ((str1 != null) && (!(str1.trim().equals(""))) && (!(str1.trim().equalsIgnoreCase("null")))) {
			b1 = str1;
		}
		if ((str2 != null) && (!(str2.trim().equals(""))) && (!(str2.trim().equalsIgnoreCase("null")))) {
			b2 = str2;
		}
		if ((str3 != null) && (!(str3.trim().equals(""))) && (!(str3.trim().equalsIgnoreCase("null")))) {
			b3 = str3;
		}
		if ((str4 != null) && (!(str4.trim().equals(""))) && (!(str4.trim().equalsIgnoreCase("null")))) {
			b4 = str4;
		}
		if (isValidateString(b4)) {
			b = b4;
		}
		if (isValidateString(b3)) {
			b = b3;
		}
		if (isValidateString(b2)) {
			b = b2;
		}
		if (isValidateString(b1)) {
			b = b1;
		}
		return b;
	}

	public static String validateString(String str1, String str2, String str3, String str4, String str5) {
		String b = "";
		String b1 = "";
		String b2 = "";
		String b3 = "";
		String b4 = "";
		String b5 = "";
		if ((str1 != null) && (!(str1.trim().equals(""))) && (!(str1.trim().equalsIgnoreCase("null")))) {
			b1 = str1;
		}
		if ((str2 != null) && (!(str2.trim().equals(""))) && (!(str2.trim().equalsIgnoreCase("null")))) {
			b2 = str2;
		}
		if ((str3 != null) && (!(str3.trim().equals(""))) && (!(str3.trim().equalsIgnoreCase("null")))) {
			b3 = str3;
		}
		if ((str4 != null) && (!(str4.trim().equals(""))) && (!(str4.trim().equalsIgnoreCase("null")))) {
			b4 = str4;
		}
		if ((str5 != null) && (!(str5.trim().equals(""))) && (!(str5.trim().equalsIgnoreCase("null")))) {
			b5 = str5;
		}
		if (isValidateString(b5)) {
			b = b5;
		}
		if (isValidateString(b4)) {
			b = b4;
		}
		if (isValidateString(b3)) {
			b = b3;
		}
		if (isValidateString(b2)) {
			b = b2;
		}
		if (isValidateString(b1)) {
			b = b1;
		}
		return b;
	}

	public static String validateString(String str1, String str2, String str3, String str4, String str5, String str6) {
		String b = "";
		String b1 = "";
		String b2 = "";
		String b3 = "";
		String b4 = "";
		String b5 = "";
		String b6 = "";
		if ((str1 != null) && (!(str1.trim().equals(""))) && (!(str1.trim().equalsIgnoreCase("null")))) {
			b1 = str1;
		}
		if ((str2 != null) && (!(str2.trim().equals(""))) && (!(str2.trim().equalsIgnoreCase("null")))) {
			b2 = str2;
		}
		if ((str3 != null) && (!(str3.trim().equals(""))) && (!(str3.trim().equalsIgnoreCase("null")))) {
			b3 = str3;
		}
		if ((str4 != null) && (!(str4.trim().equals(""))) && (!(str4.trim().equalsIgnoreCase("null")))) {
			b4 = str4;
		}
		if ((str5 != null) && (!(str5.trim().equals(""))) && (!(str5.trim().equalsIgnoreCase("null")))) {
			b5 = str5;
		}
		if ((str6 != null) && (!(str6.trim().equals(""))) && (!(str6.trim().equalsIgnoreCase("null")))) {
			b6 = str6;
		}
		if (isValidateString(b6)) {
			b = b6;
		}
		if (isValidateString(b5)) {
			b = b5;
		}
		if (isValidateString(b4)) {
			b = b4;
		}
		if (isValidateString(b3)) {
			b = b3;
		}
		if (isValidateString(b2)) {
			b = b2;
		}
		if (isValidateString(b1)) {
			b = b1;
		}
		return b;
	}

	public static String validateString(String str1, String str2, String str3, String str4, String str5, String str6,
			String str7) {
		String b = "";
		String b1 = "";
		String b2 = "";
		String b3 = "";
		String b4 = "";
		String b5 = "";
		String b6 = "";
		String b7 = "";
		if ((str1 != null) && (!(str1.trim().equals(""))) && (!(str1.trim().equalsIgnoreCase("null")))) {
			b1 = str1;
		}
		if ((str2 != null) && (!(str2.trim().equals(""))) && (!(str2.trim().equalsIgnoreCase("null")))) {
			b2 = str2;
		}
		if ((str3 != null) && (!(str3.trim().equals(""))) && (!(str3.trim().equalsIgnoreCase("null")))) {
			b3 = str3;
		}
		if ((str4 != null) && (!(str4.trim().equals(""))) && (!(str4.trim().equalsIgnoreCase("null")))) {
			b4 = str4;
		}
		if ((str5 != null) && (!(str5.trim().equals(""))) && (!(str5.trim().equalsIgnoreCase("null")))) {
			b5 = str5;
		}
		if ((str6 != null) && (!(str6.trim().equals(""))) && (!(str6.trim().equalsIgnoreCase("null")))) {
			b6 = str6;
		}
		if ((str7 != null) && (!(str7.trim().equals(""))) && (!(str7.trim().equalsIgnoreCase("null")))) {
			b7 = str7;
		}
		if (isValidateString(b7)) {
			b = b7;
		}
		if (isValidateString(b6)) {
			b = b6;
		}
		if (isValidateString(b5)) {
			b = b5;
		}
		if (isValidateString(b4)) {
			b = b4;
		}
		if (isValidateString(b3)) {
			b = b3;
		}
		if (isValidateString(b2)) {
			b = b2;
		}
		if (isValidateString(b1)) {
			b = b1;
		}
		return b;
	}

	public static String validateString(String str1, String str2, String str3, String str4, String str5, String str6,
			String str7, String str8) {
		String b = "";
		String b1 = "";
		String b2 = "";
		String b3 = "";
		String b4 = "";
		String b5 = "";
		String b6 = "";
		String b7 = "";
		String b8 = "";
		if ((str1 != null) && (!(str1.trim().equals(""))) && (!(str1.trim().equalsIgnoreCase("null")))) {
			b1 = str1;
		}
		if ((str2 != null) && (!(str2.trim().equals(""))) && (!(str2.trim().equalsIgnoreCase("null")))) {
			b2 = str2;
		}
		if ((str3 != null) && (!(str3.trim().equals(""))) && (!(str3.trim().equalsIgnoreCase("null")))) {
			b3 = str3;
		}
		if ((str4 != null) && (!(str4.trim().equals(""))) && (!(str4.trim().equalsIgnoreCase("null")))) {
			b4 = str4;
		}
		if ((str5 != null) && (!(str5.trim().equals(""))) && (!(str5.trim().equalsIgnoreCase("null")))) {
			b5 = str5;
		}
		if ((str6 != null) && (!(str6.trim().equals(""))) && (!(str6.trim().equalsIgnoreCase("null")))) {
			b6 = str6;
		}
		if ((str7 != null) && (!(str7.trim().equals(""))) && (!(str7.trim().equalsIgnoreCase("null")))) {
			b7 = str7;
		}
		if ((str8 != null) && (!(str8.trim().equals(""))) && (!(str8.trim().equalsIgnoreCase("null")))) {
			b8 = str8;
		}
		if (isValidateString(b8)) {
			b = b8;
		}
		if (isValidateString(b7)) {
			b = b7;
		}
		if (isValidateString(b6)) {
			b = b6;
		}
		if (isValidateString(b5)) {
			b = b5;
		}
		if (isValidateString(b4)) {
			b = b4;
		}
		if (isValidateString(b3)) {
			b = b3;
		}
		if (isValidateString(b2)) {
			b = b2;
		}
		if (isValidateString(b1)) {
			b = b1;
		}
		return b;
	}

	public static String validateString(String str1, String str2, String str3, String str4, String str5, String str6,
			String str7, String str8, String str9) {
		String b = "";
		String b1 = "";
		String b2 = "";
		String b3 = "";
		String b4 = "";
		String b5 = "";
		String b6 = "";
		String b7 = "";
		String b8 = "";
		String b9 = "";
		if ((str1 != null) && (!(str1.trim().equals(""))) && (!(str1.trim().equalsIgnoreCase("null")))) {
			b1 = str1;
		}
		if ((str2 != null) && (!(str2.trim().equals(""))) && (!(str2.trim().equalsIgnoreCase("null")))) {
			b2 = str2;
		}
		if ((str3 != null) && (!(str3.trim().equals(""))) && (!(str3.trim().equalsIgnoreCase("null")))) {
			b3 = str3;
		}
		if ((str4 != null) && (!(str4.trim().equals(""))) && (!(str4.trim().equalsIgnoreCase("null")))) {
			b4 = str4;
		}
		if ((str5 != null) && (!(str5.trim().equals(""))) && (!(str5.trim().equalsIgnoreCase("null")))) {
			b5 = str5;
		}
		if ((str6 != null) && (!(str6.trim().equals(""))) && (!(str6.trim().equalsIgnoreCase("null")))) {
			b6 = str6;
		}
		if ((str7 != null) && (!(str7.trim().equals(""))) && (!(str7.trim().equalsIgnoreCase("null")))) {
			b7 = str7;
		}
		if ((str8 != null) && (!(str8.trim().equals(""))) && (!(str8.trim().equalsIgnoreCase("null")))) {
			b8 = str8;
		}
		if ((str9 != null) && (!(str9.trim().equals(""))) && (!(str9.trim().equalsIgnoreCase("null")))) {
			b9 = str9;
		}
		if (isValidateString(b9)) {
			b = b9;
		}
		if (isValidateString(b8)) {
			b = b8;
		}
		if (isValidateString(b7)) {
			b = b7;
		}
		if (isValidateString(b6)) {
			b = b6;
		}
		if (isValidateString(b5)) {
			b = b5;
		}
		if (isValidateString(b4)) {
			b = b4;
		}
		if (isValidateString(b3)) {
			b = b3;
		}
		if (isValidateString(b2)) {
			b = b2;
		}
		if (isValidateString(b1)) {
			b = b1;
		}
		return b;
	}

	public static Double getDoubleFromString(String str) {
		Double returnDB = new Double(0);
		String strDB = validateString(str);
		if (("").equals(strDB)) {
			return returnDB;
		} else {
			try {
				returnDB = new Double(strDB);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return returnDB;
	}

	public static ArrayList<String> getPSValueByString(String strFormula, HashMap<String, String> strlist) {
		ArrayList<String> returnList = new ArrayList<String>();
		String[] sFormula = strFormula.split("=");
		String strRightFormula = sFormula[1];
		System.out.println(strRightFormula);
		System.out.println("====================");
		while (strRightFormula.indexOf("]") != -1) {
			String strFlag = "";
			strFlag = strRightFormula.substring(strRightFormula.indexOf("[") + 1, strRightFormula.indexOf("]"));
			returnList.add(strlist.get(strFlag));
			strRightFormula = strRightFormula.substring(strRightFormula.indexOf("]") + 1, strRightFormula.length());
		}

		return returnList;
	}

	public static String getPSBySQL(String strFormula, String strReplace) {
		String[] sFormula = strFormula.split("=");
		String strRightFormula = sFormula[1];
		System.out.println(strRightFormula);
		String endStr = "";
		String sReturn = "";
		while (strRightFormula.indexOf("]") != -1) {
			String strFlag = "";
			strFlag = strRightFormula.substring(0, strRightFormula.indexOf("["));
			sReturn = sReturn + strFlag + strReplace;
			strRightFormula = strRightFormula.substring(strRightFormula.indexOf("]") + 1, strRightFormula.length());
			endStr = strRightFormula;
		}
		return sReturn + endStr;
	}

	public static String getDecimalFormat(int iZeroNum, double dbAmount) {
		String sFormat = "#0";
		if (iZeroNum > 0) {
			sFormat = "";
			for (int i = 0; i < iZeroNum; i++) {
				sFormat = sFormat + "0";
			}
			sFormat = "#0." + sFormat;
		}
		java.text.DecimalFormat myformat = new java.text.DecimalFormat(sFormat);

		return myformat.format(dbAmount);
	}

	/**
	 * 如果小数点后面的位数大于0,就将传进来的对象格式化成指定格式 例如 iZeroNum=3 dbAmount=2.96 格式化后就是：2.960
	 * iZeroNum=1 dbAmount=2.96 格式化后就是：3.0
	 *
	 * @param iZeroNum
	 *            小数点后面的位数
	 * @param dbAmount
	 *            需要格式化的double值
	 * @return
	 */
	public static String getDecimalFormat(int iZeroNum, Object dbAmount) {
		String sFormat = "#0";
		if (iZeroNum > 0) {
			sFormat = "";
			for (int i = 0; i < iZeroNum; i++) {
				sFormat = sFormat + "0";
			}
			sFormat = "#0." + sFormat;
		}
		java.text.DecimalFormat myformat = new java.text.DecimalFormat(sFormat);

		return myformat.format(dbAmount);
	}

/*	public static String getDecimalFormat(int iZeroNum, String NumberSplit, double dbAmount) {
		String sReturn = "";
		String sFormat = "";
		String sLength = "10";

		sFormat = NumberSplit + sLength + "." + iZeroNum;

		sReturn = cutEnd(NumberOutUtils.format(dbAmount, sFormat), ".");

		return sReturn;
	}*/

/*	public static String getDecimalFormat(int iZeroNum, String NumberSplit, Object dbAmount) {
		String sReturn = "";
		String sFormat = "";
		String sLength = "10";

		sFormat = NumberSplit + sLength + "." + iZeroNum;

		sReturn = cutEnd(NumberOutUtils.format((Double) dbAmount, sFormat), ".");

		return sReturn;
	}*/

	public static String getTotalCountBlank(int iIndex, int iTotalCount, int iDefaultLineNumber,
			String sDefaultLineAlign, String sDefaultLineBlank) {
		String sReturn = String.valueOf(iIndex);

		int iTotalReturn = 0;
		while (iTotalCount > 1) {
			iTotalReturn = iTotalReturn + 1;
			iTotalCount = iTotalCount / 10;
		}
		if (iDefaultLineNumber > iTotalReturn) {
			iTotalReturn = iDefaultLineNumber;
		}

		int iIndexReturn = 0;
		while (iIndex > 0) {
			iIndexReturn = iIndexReturn + 1;
			iIndex = iIndex / 10;
		}
		for (int i = iIndexReturn; i < iTotalReturn; i++) {
			sReturn = sDefaultLineBlank + sReturn;
		}

		return sReturn;
	}



	public static boolean validateEmail(String inputEmail, boolean canBlank) {
		boolean bReturn = false;
		if (!canBlank) {
			if (isValidateString(inputEmail)) {
				String REGEX = "^[^@]([a-zA-Z_0-9.])+@([a-zA-Z_0-9.])+[^@]$";
				bReturn = inputEmail.matches(REGEX);
				return bReturn;
			}
		} else {
			bReturn = true;
		}
		return bReturn;
	}

	public static String convertMapToSQLString(HashMap<String, String> convertMap) {
		String tmpString = "";
		if (convertMap != null) {
			for (Iterator it = convertMap.entrySet().iterator(); it.hasNext();) {
				Map.Entry e = (Map.Entry) it.next();
				tmpString = "'" + e.getValue() + "'," + tmpString;
			}
		}
		return cutEnd(tmpString, ",");
	}

	public static ArrayList<Object> convertMapToList(Map<Object, Object> convertMap) {
		ArrayList<Object> mList = null;
		if (convertMap != null) {
			mList = new ArrayList<Object>();
			for (Iterator it = convertMap.entrySet().iterator(); it.hasNext();) {
				Map.Entry e = (Map.Entry) it.next();
				mList.add(e.getValue());
			}
		}
		return mList;
	}

	public static Double convertStringToDouble(String inStr) {
		double dbReturn = 0;
		if ((StringUtil.isValidateString(inStr))) {
			dbReturn = Double.valueOf(inStr).doubleValue();
		}
		return dbReturn;
	}

	/**
	 * 将整数字符串转化为整数
	 *
	 * @param str
	 *            数字字符串
	 * @return 转化后的Int类型
	 * @throws NumberFormatException
	 */
	public static int convertInteger(String str) throws NumberFormatException {
		int number = 0;
		if (!isValidateString(str)) {
			return number;
		}
		str = str.trim();
		try {
			number = Integer.parseInt(str);
		} catch (NumberFormatException e) {

			number = 0;
			throw e;
		}
		return number;
	}

	public static String getVoucherName(String voucherId, String subject) {
		String strReturn = "";
		if ((StringUtil.isValidateString(voucherId)) || (StringUtil.isValidateString(subject))) {
			strReturn = StringUtil.validateString(voucherId) + (StringUtil.isValidateString(voucherId) ? "/" : "")
					+ StringUtil.validateString(subject);
		}
		return strReturn;
	}

	public static String repalceString(String str, String oldStr, String newStr) {
		String strReturn = "";
		strReturn = StringUtil.validateString(str).replaceAll(oldStr, newStr);
		return strReturn;
	}

	public static boolean checkEmail(String mail) {
		String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mail);
		return m.find();
	}

	/**
	 * 判断是否包含子字符串 有则返回true 没有则返回false
	 *
	 * @param allStr
	 * @param subStr
	 * @return
	 */
	public static boolean isIncludeSubStr(String allStr, String subStr) {
		if ((StringUtil.isValidateString(allStr)) && (StringUtil.isValidateString(subStr))) {
			int flag = allStr.lastIndexOf(subStr);
			if (flag == -1) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}

	}

	public static String upFirstChar(String str) {
		String first = (str.substring(0, 1)).toUpperCase();
		String other = str.substring(1);
		return first + other;
	}

	/**
	 * 将字符串转化为double
	 *
	 * @param inStr
	 * @return
	 */
	public static double str2double(String inStr) {
		try {
			return new Double(StringUtil.validateString(inStr)).doubleValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static String[] initArrString(String[] inArrStr, String defaultValue) {
		if (inArrStr != null) {
			for (int i = 0; i < inArrStr.length; i++) {
				inArrStr[i] = StringUtil.validateString(defaultValue);
			}
		}
		return inArrStr;
	}

	/**
	 * 判断是否是奇数偶数 false 奇数 true 偶数 如果输入的不是一个字符串，则返回true
	 *
	 * @param strInput
	 * @return
	 */
	public static boolean validateParity(String strInput) {
		if (!StringUtil.isValidateString(strInput)) {
			return true;
		} else {
			int i = StringUtil.str2int(strInput);

			if (i / 2 * 2 == i) {
				System.out.println("它为偶数");
				return true;
			} else {
				System.out.println("它为奇数");
				return false;
			}
		}
	}

	/**
	 * 将数组根据iFlag长度进行分割，转成mList
	 *
	 * @param strContext
	 * @param iFlag
	 * @return
	 */
	public static ArrayList<String[]> arrStringSplitByiFlag(String[] strContext, int iFlag) {
		ArrayList<String[]> mList = new ArrayList<String[]>();
		if (strContext != null) {
			String[] arrString = null;
			for (int i = 0; i < strContext.length; i++) {
				if (i % iFlag == 0) {
					arrString = new String[iFlag];
				}

				arrString[i % iFlag] = strContext[i];
				if (i % iFlag == iFlag - 1) {
					mList.add(arrString);
				}
			}
		}
		return mList;
	}

	// subStr 在 allStr出现的次数
	public static int strConstantCount(String allStr, String subStr) {
		int count = 0;
		int m = StringUtil.validateString(allStr).indexOf(StringUtil.validateString(subStr));

		while (m != -1) {
			m = StringUtil.validateString(allStr).indexOf(StringUtil.validateString(subStr), m + 1);
			count++;
		}

		return count;
	}

	public static boolean includeStr(String allStr, String subStr) {
		boolean bReturn = false;
		if (allStr.indexOf(subStr) > -1)
			bReturn = true;
		return bReturn;
	}

	/**
	 * 判断String是否相同,大小写敏感
	 *
	 * @param str1
	 * @param str2
	 * @return
	 *
	 * 		备注：==和equals的区别
	 *         一、比较对象为基本数据类型（byte,short,char,int,long,float,double,boolean）
	 *         比较两个基本数据类型是否相等用==，因为只有类才会有equals方法。
	 *
	 *         备注：String不是基本数据类型
	 *
	 *         二、比较对象为引用数据类型
	 *
	 *         euqals和==本质上都是比较比较的是两个对象的引用（内存地址）是否相同。equals()是Object类的方法
	 *         ，object类是所有类的基类，所以每个类都会继承equals()方法。
	 *         但在String,Integer,Date在这些类当中重写了equals方法，而不再是比较对象在堆内存中的存放地址了，
	 *         而是比较它们指向的实体（内容）是否相同。
	 *
	 *
	 */
	public static boolean equalsString(String str1, String str2) {
		boolean bReturn = false;

		if ((!StringUtil.isValidateString(str1)) && (!StringUtil.isValidateString(str2))) {
			return false;
		} else {
			if (StringUtil.validateString(str1).equals(StringUtil.validateString(str2))) {
				return true;
			}
		}

		return bReturn;
	}

	public static boolean equalsString(Object obj, String str2) {
		boolean bReturn = false;

		if ((obj == null)
				|| ((!StringUtil.isValidateString(obj.toString())) && (!StringUtil.isValidateString(str2)))) {
			return false;
		} else {
			if (StringUtil.validateString(obj.toString()).equals(StringUtil.validateString(str2))) {
				return true;
			}
		}

		return bReturn;
	}

	/**
	 * 判断String是否相同,大小写不敏感
	 *
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean equalsIgnoreCaseString(String str1, String str2) {
		boolean bReturn = false;

		if ((!StringUtil.isValidateString(str1)) && (!StringUtil.isValidateString(str2))) {
			return false;
		} else {
			if (StringUtil.validateString(str1).equalsIgnoreCase(StringUtil.validateString(str2))) {
				return true;
			}
		}

		return bReturn;
	}

	/**
	 * 判断String是否相同,大小写不敏感
	 *
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean equalsIgnoreCaseString(String str1, int str2) {
		boolean bReturn = false;

		if ((!StringUtil.isValidateString(str1)) && (!StringUtil.isValidateString(String.valueOf(str2)))) {
			return false;
		} else {
			if (StringUtil.validateString(str1).equalsIgnoreCase(StringUtil.validateString(String.valueOf(str2)))) {
				return true;
			}
		}

		return bReturn;
	}

	/**
	 * 合并两个String[]
	 *
	 * @param sourceByte1
	 * @param sourceByte2
	 * @return
	 */
	public static String[] mergeArrayString(String[] sourceByte1, String[] sourceByte2) {
		int targetLength = 0;
		int souceArg1Length = 0;
		int souceArg2Length = 0;
		if (sourceByte1 != null) {
			souceArg1Length = sourceByte1.length;
			targetLength = targetLength + souceArg1Length;
		}
		if (sourceByte2 != null) {
			souceArg2Length = sourceByte2.length;
			targetLength = targetLength + souceArg2Length;
		}
		String[] targetArg = new String[targetLength];
		if (sourceByte1 != null) {
			System.arraycopy(sourceByte1, 0, targetArg, 0, souceArg1Length);
		}
		if (sourceByte1 != null) {
			System.arraycopy(sourceByte2, 0, targetArg, souceArg1Length, souceArg2Length);
		}
		return targetArg;
	}

	public static String[] getArrBySpace(String str) {
		String[] arrStr = null;
		if (StringUtil.isValidateString(str)) {
			arrStr = str.split(" ");
		}
		return arrStr;
	}

	// 把a,b,c,d 按照 strSplit 做 split 转成 string数组
	public static String[] getArrBySpace(String strTemp, String strSplit) {
		String[] arrStr = null;
		if (StringUtil.isValidateString(strTemp)) {
			arrStr = strTemp.split(StringUtil.validateString(strSplit));
		}
		return arrStr;
	}

	public static String[] getArrByEqual(String strTemp) {
		String[] arrStr = null;
		if (StringUtil.isValidateString(strTemp)) {
			arrStr = strTemp.split(StringUtil.validateString("="));
		}
		return arrStr;
	}

	// public static String getSetMethodName(String strPropertyName) {
	// return "set" +
	// toUpperCaseFirstLetter(StringUtil.validateString(strPropertyName));
	// }

	public static String getSetMethodName(String strPropertyName) {
		return (StringUtil.validateString(strPropertyName));
	}

	public static String toUpperCaseFirstLetter(String name) {
		if (!isValidateString(name)) {
			return "";
		}
		name = name.trim();
		if (name.length() > 0) {
			return name.substring(0, 1).toUpperCase() + name.substring(1);
		}
		return "";
	}

	// public static String getSFAPage(String strComponentID, String strID,
	// UserCommon userCommon) {
	// String sfalistUrl =
	// "../sfalist/sfalist_component_to_link.jsp?componentid="
	// + strComponentID + "&objectid=" + strID;
	// StringBuffer strBF = new StringBuffer();
	// strBF.append("<TR style=\"HEIGHT: 25px\">");
	// strBF
	// .append("<TD class=\"bpDvtCellLabel\" align=\"right\"
	// width=\"20%\"><bean:message");
	// strBF.append("key=\"usersfa\" bundle=\"" + userCommon.getBundle()
	// + "\" /></TD>");
	// strBF
	// .append("<TD class=\"bpDvtCellInfo\" align=\"left\" width=\"80%\"
	// colspan=\"3\" >");
	// strBF.append("<jsp:include page=\"" + sfalistUrl
	// + "\" flush=\"true\" />");
	// strBF.append("</TD>");
	// strBF.append("</TR> ");
	//
	// return strBF.toString();
	// }
	//
	// public static int getIteratorCount(Iterator it) {
	// if (it == null) {
	// return 0;
	// }
	// int iCount = 0;
	// while (it.hasNext()) {
	// TableSettingForm tsValue = (TableSettingForm) it.next();
	// if (tsValue != null)
	// iCount++;
	// }
	// return iCount;
	// }

	public static String getStringFromLinkedList(LinkedList<String> mList, String strSplit) {
		if (mList == null)
			return "";

		strSplit = StringUtil.isValidateString(strSplit) ? StringUtil.validateString(strSplit) : ",";
		StringBuffer strBF = new StringBuffer();
		for (int i = 0; i < mList.size(); i++) {
			strBF.append((mList.get(i)).toString());
			strBF.append(strSplit);
		}
		String strReturn = strBF.toString();
		return StringUtil.cutEnd(strReturn, strSplit);
	}

	//

	/**
	 * gbk转utf
	 */
	public static String gbk2utf8(String strTemp) {
		String strReturn = "";
		try {
			byte[] fullByte = initGbk2Utf8(strTemp);
			strReturn = new String(fullByte, "UTF-8");
			System.out.println(strReturn);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return strReturn;
	}

	private static byte[] initGbk2Utf8(String strTemp) {
		char c[] = strTemp.toCharArray();
		byte[] fullByte = new byte[3 * c.length];
		for (int i = 0; i < c.length; i++) {
			int m = (int) c[i];
			String word = Integer.toBinaryString(m);
			// System.out.println(word);

			StringBuffer sb = new StringBuffer();
			int len = 16 - word.length();
			// 补零
			for (int j = 0; j < len; j++) {
				sb.append("0");
			}
			sb.append(word);
			sb.insert(0, "1110");
			sb.insert(8, "10");
			sb.insert(16, "10");

			// System.out.println(sb.toString());

			String s1 = sb.substring(0, 8);
			String s2 = sb.substring(8, 16);
			String s3 = sb.substring(16);

			byte b0 = Integer.valueOf(s1, 2).byteValue();
			byte b1 = Integer.valueOf(s2, 2).byteValue();
			byte b2 = Integer.valueOf(s3, 2).byteValue();
			byte[] bf = new byte[3];
			bf[0] = b0;
			fullByte[i * 3] = bf[0];
			bf[1] = b1;
			fullByte[i * 3 + 1] = bf[1];
			bf[2] = b2;
			fullByte[i * 3 + 2] = bf[2];

		}
		return fullByte;
	}

	/**
	 * 在strInput前补零
	 *
	 * @param iTotalLenght
	 * @param strInput
	 */
	public static String getZeroString(int iTotalLenght, String strInput) {

		if (!StringUtil.isValidateString(strInput)) {
			strInput = "";
		}
		if (strInput.length() > iTotalLenght) {
			return strInput;
		} else {
			for (int i = strInput.length(); i < iTotalLenght; i++) {
				strInput = "0" + strInput;
			}
			return strInput;
		}
	}

	

	// public static String getGridCaption(BaseComponentForm mainForm, int
	// width,
	// UserCommon userCommon) throws Exception {
	// // StringBuffer sbReturn = new StringBuffer();
	// // SelectorUtil SRU = new SelectorUtil();
	// // if (mainForm.getUserColumnDetailList() != null) {
	// // ArrayList<UserColumnDetailForm> tmList = (ArrayList) mainForm
	// // .getUserColumnDetailList();
	// // for (int i = 0; i < tmList.size(); i++) {
	// // UserColumnDetailForm capValue = tmList.get(i);
	// // BaseForm value = SRU.getDifModuleFormBean(StringUtil
	// // .checkString(capValue.getColumn_id()),
	// // new ComponentColumnForm().getComponentId(), userCommon);
	// // HashMap map = BeanUtil.objectToMap(value);
	// // String strColumn = " {display: '"
	// // + StringUtil.checkString(userCommon.getResources()
	// // .getMessage(userCommon.getLocale(),
	// // capValue.getColumn_name()))
	// // + "', name : '"
	// // + StringUtil.validateString(String.valueOf(map
	// // .get("columnid")))
	// // + "', width : "
	// // + NumberUtil.truncateDouble(capValue.getColumn_width()
	// // * 1.0 / 100
	// // * (userCommon.getScreenWidth() - width) - 10,
	// // "0") + ", sortable : true, align: 'left'} ";
	// // if (i < tmList.size() - 1) {
	// // strColumn += ",";
	// // }
	// // sbReturn.append(strColumn);
	// // }
	// // }
	// // return sbReturn.toString();
	//
	// StringBuffer sbReturn = new StringBuffer();
	// SelectorUtils SRU = new SelectorUtils();
	// if ((mainForm != null) && (mainForm.getUserColDtlList() != null)) {
	// ArrayList<U25200Form> tmList = (ArrayList) mainForm
	// .getUserColDtlList();
	// if (tmList != null) {
	// for (int i = 0; i < tmList.size(); i++) {
	// U25200Form capValue = tmList.get(i);
	// // BaseForm value = SRU.getDifModuleFormBean(StringUtil
	// // .checkString(capValue.getColumn_id()),
	// // new SComponentColumnForm().getComponentId(), userCommon);
	// // HashMap map = BeanUtil.objectToMap(value);
	// String strColumn = " {name: '"
	// + StringUtil.validateString(SRU
	// .getGlobalMessageValue(capValue
	// .getC_S04100_C_ID()))
	// // + " ID "
	// + "', index : '"
	// + StringUtil.validateString(
	// capValue.getC_S04100_C_ID()).replaceAll(
	// "\\.", "")
	// // + " c_id "
	// + "', width : "
	// + NumberUtils.truncateDouble(
	// capValue.getI_WIDTH() * 1.0
	// // / 100
	// // * (userCommon.getIScreenWidth() - width)
	// // - 10, "0")
	// , "0")
	// + ", sortable : true, align: 'left'} ";
	// if (i < tmList.size() - 1) {
	// strColumn += ",";
	// }
	// sbReturn.append(strColumn);
	// }
	// }
	// }
	// return sbReturn.toString();
	// }


	public static String getTableNameByComponentID(String componentID) {
		if (StringUtil.isValidateString(componentID)) {
			if (StringUtil.validateString(componentID).length() == 6) {
				return StringUtil.validateString(componentID).substring(0, 4);
			}
		}
		return "";
	}

	/**
	 * <p>
	 * 获得一个整数位数
	 * </p>
	 *
	 * @param number
	 * @return
	 */
	public static int getNumberDigit(int number) {
		int i = 1;
		while (number >= 10) {
			i++;
			number = number / 10;
		}
		return i;
	}

	/**
	 * <p>
	 * 将数字转换含有0的数字字符串
	 * </p>
	 * <p>
	 * 例如：将"1"转换4位数字字符串,结果为:"0001"
	 * </p>
	 *
	 * @param number
	 * @param digit
	 * @return
	 */
	public static String getStringNum(int number, int digit) {
		int c = number + 1;

		int n = getNumberDigit(c);

		if (n >= digit) {
			return int2str(c);
		} else {
			String temp = "";
			for (int i = 0; i < (digit - n); i++) {
				temp += "0";
			}
			return temp + c;
		}
	}

	/**
	 * 将数字转换为字符串
	 *
	 * @param number
	 * @return
	 */
	public static String int2str(Integer number) {
		return String.valueOf(number);
	}

	/**
	 * 将数字转换为字符串
	 *
	 * @param number
	 * @return
	 */
	public static String long2str(Long number) {
		return String.valueOf(number);
	}

	/**
	 * hashmap转成string
	 *
	 * @param inMap
	 * @param strPrefix
	 * @return
	 */
	public static String map2Str(HashMap<String, String> inMap, String strPrefix) {
		String strReturn = "";
		if ((inMap != null)) {
			Set entrys = inMap.entrySet();
			Iterator it = entrys.iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				if (StringUtil.isValidateString((String) entry.getKey())) {
					strReturn = strReturn + strPrefix + (StringUtil.validateString((String) entry.getKey()));
				}
			}
		}
		// return cutBegin(cutEnd(strReturn, strPrefix), strPrefix);
		return cutEnd(strReturn, strPrefix);
	}

	/**
	 *
	 * @param inMap
	 * @param strPrefix
	 * @return
	 */
	public static String mapValue2Str(HashMap<String, String> inMap, String strPrefix) {
		String strReturn = "";
		if ((inMap != null)) {
			Set entrys = inMap.entrySet();
			Iterator it = entrys.iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				if (StringUtil.isValidateString((String) entry.getKey())) {
					strReturn = strReturn

							+ (StringUtil.validateString((String) entry.getValue()) + strPrefix);
				}
			}
		}
		// return cutBegin(cutEnd(strReturn, strPrefix), strPrefix);
		return cutEnd(strReturn, strPrefix);
	}

	/**
	 * 取得hashmap的长度
	 *
	 * @param inMap
	 * @return
	 */
	public static int getHashMapLength(HashMap<String, String> inMap) {
		int i = 0;
		if ((inMap != null)) {
			Set entrys = inMap.entrySet();
			Iterator it = entrys.iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				if (StringUtil.isValidateString((String) entry.getKey())) {
					i++;
				}
			}
			return i;
		} else {
			return 0;
		}
	}

	/**
	 * 判断两个map是否相同
	 *
	 * @param fromMap
	 * @param toMap
	 * @return
	 */
	public static boolean compareHashMap(HashMap<String, String> fromMap, HashMap<String, String> toMap) {
		boolean bReturn = false;
		if (getHashMapLength(fromMap) != getHashMapLength(toMap)) {
			return false;
		} else {
			Set entrys = fromMap.entrySet();
			Iterator itFrom = entrys.iterator();
			while (itFrom.hasNext()) {
				Map.Entry entryFrom = (Map.Entry) itFrom.next();
				if ((fromMap.get((String) entryFrom.getKey())) != null) {
					toMap.remove(entryFrom.getKey());
				}
			}
		}
		if ((toMap.isEmpty())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获得字符串第一个字母
	 *
	 * @return
	 */
	public static String getFirstLetter(String str, String strDefaultValue) {
		if (!isValidateString(str)) {
			return isValidateString(strDefaultValue) ? strDefaultValue.substring(0, 1) : "";
		}
		return str.substring(0, 1);
	}

	/**
	 * 从字符串数组中安全获得数组中某个元素的值(String 类型)
	 *
	 * @param str
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public static String getStringArrayValue(String[] str, int index) throws Exception {
		if (!isValidateStringArray(str)) {
			return "";
		}
		if (index < 0 || index >= getStringArrayLength(str)) {
			throw new Exception("数组下标越界");
		}

		return str[index].trim();
	}

	/**
	 * 获得string 数组长度
	 *
	 * @param str
	 * @return
	 */
	public static int getStringArrayLength(String[] str) {
		if (!isValidateStringArray(str)) {
			return 0;
		}
		return str.length;
	}

	/**
	 *
	 * 忽略大小写 判断数组里的所有字符串和第二个字符串参数是否相同 如果都是非空并且所有字符串相同返回true，否则返回false
	 *
	 * @param str
	 * @param inStr
	 * @return
	 */
	public static boolean isArrContainsString(String[] str, String inStr) {
		if (str == null || str.length <= 0) {
			return false;
		}
		if (!StringUtil.isValidateString(inStr)) {
			return false;
		}
		for (String tmpStr : str) {
			if (equalsIgnoreCaseString(tmpStr, inStr)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 检验第一个字符串是否包含第二个字符串 如果有 返回true 如果没有返回false
	 *
	 * @param allStr
	 * @param subStr
	 * @return
	 */
	public static boolean isContainsString(String allStr, String subStr) {

		int m = StringUtil.validateString(allStr).indexOf(StringUtil.validateString(subStr));

		if (m > -1) {
			return true;
		}

		return false;
	}

	/**
	 * 参数小于2返回true,大于2返回false
	 *
	 * @param para
	 * @return
	 */
	public boolean isOddEven(int para) {
		int i = para / 2;
		if (i == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 将传进来的日期类型转换为字符串类型
	 *
	 * @param t
	 * @return
	 */
	public static String validateTimestamp(Timestamp t) {

		if (t == null) {
			return "";
		} else {
			return t.toString();
		}
	}

	/**
	 * 将传进来的日期类型转换为字符串类型
	 *
	 * @param
	 * @return
	 */
	public static String validateInteger(Integer i) {

		if (i == null) {
			return "";
		} else {
			return i.toString();
		}
	}

	/**
	 * 根据参数值返回不同的src属性值
	 *
	 * @param t
	 * @return
	 */
	public static String getsrcbystateid(int t) {
		String src = "";
		if (t == 1) {
			src = "../test/zuoxi_files/red.jpg";
		} else if (t == 2) {
			src = "../test/zuoxi_files/yellow.jpg";
		} else if (t == 3) {
			src = "../test/zuoxi_files/gry.jpg";
		} else if (t == 4) {
			src = "../test/zuoxi_files/green.jpg";
		} else if (t == 0) {
			src = "../test/zuoxi_files/gry.jpg";
		} else if (t == 5) {
			src = "../test/zuoxi_files/gry.jpg";
		}

		return src;
	}

	/**
	 * 取随机数字
	 *
	 * @param i
	 *            位数
	 * @return
	 */
	public static final String randomIntNumber(int i) {
		if (i < 1)
			return "0";
		if (randGen == null)
			synchronized (initLock) {
				if (randGen == null) {
					randGen = new Random();
					numbersAndLetters = "123456789".toCharArray();
				}
			}
		char ac[] = new char[i];
		for (int j = 0; j < ac.length; j++)
			ac[j] = numbersAndLetters[randGen.nextInt(numbersAndLetters.length)];
		System.out.println("----" + new String(ac));
		return (new String(ac));
	}

	/**
	 * double转string
	 *
	 * @param num
	 * @param format
	 * @return
	 */
	public static String truncateDouble(double num, String format) {
		if (!StringUtil.isValidateString(format)) {
			return "";
		}
		NumberFormat doubleFormat = new DecimalFormat(format);

		return doubleFormat.format(num);
	}

	/**
	 * subtring
	 *
	 * @param str
	 * @param begin
	 * @param end
	 * @return
	 */
	public static String subString(String str, int begin, int end) {
		if (!StringUtil.isValidateString(str)) {
			return "";
		} else {
			if (str.length() < end) {
				return str.substring(begin, str.length());
			} else {
				return str.substring(begin, end);
			}
		}

	}

	/**
	 * @Title: getRandom @Description: TODO(随机获取0到i之间的数字) @param: @param
	 *         i @param: @return @return: int @throws
	 */
	public static int getRandom(int i) {
		java.util.Random random = new java.util.Random();// 定义随机类
		int result = random.nextInt(i);// 返回[0,10)集合中的整数，注意不包括10
		return result + 1; // +1后，[0,10)集合变为[1,11)集合，满足要求
	}

	/** charCount 为 随机数 */
	public static String getRandNum(int charCount) {
		String charValue = "";
		for (int i = 0; i < charCount; i++) {
			char c = (char) (randomInt(0, 10) + '0');
			charValue += String.valueOf(c);
		}
		return charValue;
	}

	public static int randomInt(int from, int to) {
		Random r = new Random();
		return from + r.nextInt(to - from);
	}

	/**
	 * 计算地球上任意两点(经纬度)距离
	 *
	 * @param long1
	 *            第一点经度
	 * @param lat1
	 *            第一点纬度
	 * @param long2
	 *            第二点经度
	 * @param lat2
	 *            第二点纬度
	 * @return 返回距离 单位：米
	 */
	public static double Distance(double long1, double lat1, double long2, double lat2) {
		double a, b, R;
		R = 6378137; // 地球半径
		lat1 = lat1 * Math.PI / 180.0;
		lat2 = lat2 * Math.PI / 180.0;
		a = lat1 - lat2;
		b = (long1 - long2) * Math.PI / 180.0;
		double d;
		double sa2, sb2;
		sa2 = Math.sin(a / 2.0);
		sb2 = Math.sin(b / 2.0);
		d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
		return d;
	}	
	
    //private static final Log LOG = LogFactory.getLog(StringUtil.class);

    /**
     * 私有构造方法,将该工具类设为单例模式.
     */
    private StringUtil() {
    }

    /**
     * 函数功能说明 ： 判断字符串是否为空 . 修改者名字： 修改日期： 修改内容：
     * 
     * @参数： @param str
     * @参数： @return
     * @return boolean
     * @throws
     */
    public static boolean isEmpty(String str) {
        return null == str || "".equals(str);
    }

    /**
     * 函数功能说明 ： 判断对象数组是否为空. 修改者名字： 修改日期： 修改内容：
     * 
     * @参数： @param obj
     * @参数： @return
     * @return boolean
     * @throws
     */
    public static boolean isEmpty(Object[] obj) {
        return null == obj || 0 == obj.length;
    }

    /**
     * 函数功能说明 ： 判断对象是否为空. 修改者名字： 修改日期： 修改内容：
     * 
     * @参数： @param obj
     * @参数： @return
     * @return boolean
     * @throws
     */
    public static boolean isEmpty(Object obj) {
        if (null == obj) {
            return true;
        }
        if (obj instanceof String) {
            return ((String) obj).trim().isEmpty();
        }
        return !(obj instanceof Number) ? false : false;
    }

    /**
     * 函数功能说明 ： 判断集合是否为空. 修改者名字： 修改日期： 修改内容：
     * 
     * @参数： @param obj
     * @参数： @return
     * @return boolean
     * @throws
     */
    public static boolean isEmpty(List<?> obj) {
        return null == obj || obj.isEmpty();
    }

    /**
     * 函数功能说明 ： 判断Map集合是否为空. 修改者名字： 修改日期： 修改内容：
     * 
     * @参数： @param obj
     * @参数： @return
     * @return boolean
     * @throws
     */
    public static boolean isEmpty(Map<?, ?> obj) {
        return null == obj || obj.isEmpty();
    }

    /**
     * 函数功能说明 ： 获得文件名的后缀名. 修改者名字： 修改日期： 修改内容：
     * 
     * @参数： @param fileName
     * @参数： @return
     * @return String
     * @throws
     */
    public static String getExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * 获取去掉横线的长度为32的UUID串.
     * 
     * @author WuShuicheng.
     * @return uuid.
     */
    public static String get32UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取带横线的长度为36的UUID串.
     * 
     * @author WuShuicheng.
     * @return uuid.
     */
    public static String get36UUID() {
        return UUID.randomUUID().toString();
    }


    /**isNumeric
     * 计算采用utf-8编码方式时字符串所占字节数
     * 
     * @param content
     * @return
     */
    public static int getByteSize(String content) {
        int size = 0;
        if (null != content) {
            try {
                // 汉字采用utf-8编码时占3个字节
                size = content.getBytes("utf-8").length;
            } catch (UnsupportedEncodingException e) {
                //LOG.error(e);
            }
        }
        return size;
    }

    /**
     * 函数功能说明 ： 截取字符串拼接in查询参数. 修改者名字： 修改日期： 修改内容：
     * 
     * @参数： @param ids
     * @参数： @return
     * @return String
     * @throws
     */
    public static List<String> getInParam(String param) {
        boolean flag = param.contains(",");
        List<String> list = new ArrayList<String>();
        if (flag) {
            list = Arrays.asList(param.split(","));
        } else {
            list.add(param);
        }
        return list;
    }

}
