package com.pop136.customerservice.utils;

/**********************************************************************
 *
 *   File StringUtils.java
 *
 *
 *   Description
 *	(Function Provided)
 *	String replace(String s, String s1, String s2)
 *	String replaceIgnoreCase(String s, String s1, String s2)
 *	String replace(String s, String s1, String s2, int ai[])
 *	String escapeHTMLTags(String s)
 *	String hash(String s)
 *	String encodeHex(byte abyte0[])
 *	byte[] decodeHex(String s)
 *	byte hexCharToByte(char c)
 *	String encodeBase64(String s)
 *	String encodeBase64(byte abyte0[])
 *	String decodeBase64(String s)
 *	String decodeBase64(byte abyte0[])
 *	String[] toLowerCaseWordArray(String s)
 *	String toUpperCaseWord(String s)
 *	String[] removeCommonWords(String as[])
 *	String randomString(int i)
 *	String chopAtWord(String s, int i)
 *	String highlightWords(String s, String as[], String s1, String s2)
 *	String escapeForXML(String s)
 *	String unescapeFromXML(String s)
 *	String zeroPadString(String s, int i)
 *	String dateToMillis(Date date)
 * 	String[] parseString(String s,String de)
 *	String convertArrayToSQLString(String[] convertArray)
 *   String unitArray(String src[],String de)
 *   String convHTMLUni(String langCode, String langStr)
 *	String revHTMLUni(String langCode, String langStr)
 *	String convJavaUni(String langCode, String langStr)
 *	String charToHex(char c)
 *	String byteToHex(byte b)
 *	String encodeIsoString(String langCode, String langStr)
 *
 *
 *   CopyRight
 *
 **********************************************************************/

import com.google.gson.Gson;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

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

	private static Map commonWordsMap = null;

	private static Random randGen = null;

	private static char numbersAndLetters[] = null;

	private static final char zeroArray[] = "0000000000000000".toCharArray();

	public StringUtils() {
	}

	// 首字母大写
	public static String captureName(String name) {
		// name = name.substring(0, 1).toUpperCase() + name.substring(1);
		// return name;
		char[] cs = name.toCharArray();
		cs[0] -= 32;
		return String.valueOf(cs);

	}

    public static String getPercentage(Double x1){
        NumberFormat formatter = new DecimalFormat("0");
//        Double =new Double(34.0/55.0);
        String xx1 = formatter.format(x1*100);
        System.out.println(xx1+"%");
        return xx1+"%";
    }
	public static String BigDecimalToString(BigDecimal b) {
		return b != null ? b.setScale(2, BigDecimal.ROUND_HALF_UP).toString() : "0";
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
					commonWordsMap = new HashMap();
					for (int i = 0; i < commonWords.length; i++)
						commonWordsMap.put(commonWords[i], commonWords[i]);

				}
			}
		ArrayList arraylist = new ArrayList(as.length);
		for (int j = 0; j < as.length; j++)
			if (!commonWordsMap.containsKey(as[j]))
				arraylist.add(as[j]);

		return (String[]) arraylist.toArray(new String[arraylist.size()]);
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
		// langStr = emp.string.StringUtils.replace(langStr, "\'", "&acute;");
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
			if (obj.getClass() != String.class) {
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
	public static Vector DivStrByFlag(String str, String flag) {

		Vector v = new Vector();
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
		if (StringUtils.isValidateString(strWhole) && (StringUtils.isValidateString(strSub))) {
			if ((StringUtils.validateString(strWhole).indexOf(StringUtils.validateString(strSub))) == 0) {
				return true;
			}
		}
		return false;
	}

	public static boolean endWith(String strWhole, String strSub) {
		if (StringUtils.isValidateString(strWhole) && (StringUtils.isValidateString(strSub))) {
			if ((StringUtils.validateString(strWhole)
					.lastIndexOf(StringUtils.validateString(strSub))) == ((StringUtils.validateString(strWhole).length()
							- (StringUtils.validateString(strSub)).length()))) {
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

	public static ArrayList getPSValueByString(String strFormula, HashMap strlist) {
		ArrayList returnList = new ArrayList();
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
		DecimalFormat myformat = new DecimalFormat(sFormat);

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
		DecimalFormat myformat = new DecimalFormat(sFormat);

		return myformat.format(dbAmount);
	}


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

	public static String convertMapToSQLString(HashMap convertMap) {
		String tmpString = "";
		if (convertMap != null) {
			for (Iterator it = convertMap.entrySet().iterator(); it.hasNext();) {
				Map.Entry e = (Map.Entry) it.next();
				tmpString = "'" + e.getValue() + "'," + tmpString;
			}
		}
		return cutEnd(tmpString, ",");
	}

	public static ArrayList convertMapToList(Map convertMap) {
		ArrayList mList = null;
		if (convertMap != null) {
			mList = new ArrayList();
			for (Iterator it = convertMap.entrySet().iterator(); it.hasNext();) {
				Map.Entry e = (Map.Entry) it.next();
				mList.add(e.getValue());
			}
		}
		return mList;
	}

	public static Double convertStringToDouble(String inStr) {
		double dbReturn = 0;
		if ((StringUtils.isValidateString(inStr))) {
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
		if ((StringUtils.isValidateString(voucherId)) || (StringUtils.isValidateString(subject))) {
			strReturn = StringUtils.validateString(voucherId) + (StringUtils.isValidateString(voucherId) ? "/" : "")
					+ StringUtils.validateString(subject);
		}
		return strReturn;
	}

	public static String repalceString(String str, String oldStr, String newStr) {
		String strReturn = "";
		strReturn = StringUtils.validateString(str).replaceAll(oldStr, newStr);
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
		if ((StringUtils.isValidateString(allStr)) && (StringUtils.isValidateString(subStr))) {
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
			return new Double(StringUtils.validateString(inStr)).doubleValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static String[] initArrString(String[] inArrStr, String defaultValue) {
		if (inArrStr != null) {
			for (int i = 0; i < inArrStr.length; i++) {
				inArrStr[i] = StringUtils.validateString(defaultValue);
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
		if (!StringUtils.isValidateString(strInput)) {
			return true;
		} else {
			int i = StringUtils.str2int(strInput);

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
	public static ArrayList arrStringSplitByiFlag(String[] strContext, int iFlag) {
		ArrayList mList = new ArrayList();
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
		int m = StringUtils.validateString(allStr).indexOf(StringUtils.validateString(subStr));

		while (m != -1) {
			m = StringUtils.validateString(allStr).indexOf(StringUtils.validateString(subStr), m + 1);
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

		if ((!StringUtils.isValidateString(str1)) && (!StringUtils.isValidateString(str2))) {
			return false;
		} else {
			if (StringUtils.validateString(str1).equals(StringUtils.validateString(str2))) {
				return true;
			}
		}

		return bReturn;
	}

	public static boolean equalsString(Object obj, String str2) {
		boolean bReturn = false;

		if ((obj == null)
				|| ((!StringUtils.isValidateString(obj.toString())) && (!StringUtils.isValidateString(str2)))) {
			return false;
		} else {
			if (StringUtils.validateString(obj.toString()).equals(StringUtils.validateString(str2))) {
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

		if ((!StringUtils.isValidateString(str1)) && (!StringUtils.isValidateString(str2))) {
			return false;
		} else {
			if (StringUtils.validateString(str1).equalsIgnoreCase(StringUtils.validateString(str2))) {
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

		if ((!StringUtils.isValidateString(str1)) && (!StringUtils.isValidateString(String.valueOf(str2)))) {
			return false;
		} else {
			if (StringUtils.validateString(str1).equalsIgnoreCase(StringUtils.validateString(String.valueOf(str2)))) {
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
		if (StringUtils.isValidateString(str)) {
			arrStr = str.split(" ");
		}
		return arrStr;
	}

	// 把a,b,c,d 按照 strSplit 做 split 转成 string数组
	public static String[] getArrBySpace(String strTemp, String strSplit) {
		String[] arrStr = null;
		if (StringUtils.isValidateString(strTemp)) {
			arrStr = strTemp.split(StringUtils.validateString(strSplit));
		}
		return arrStr;
	}

	public static String[] getArrByEqual(String strTemp) {
		String[] arrStr = null;
		if (StringUtils.isValidateString(strTemp)) {
			arrStr = strTemp.split(StringUtils.validateString("="));
		}
		return arrStr;
	}

	// public static String getSetMethodName(String strPropertyName) {
	// return "set" +
	// toUpperCaseFirstLetter(StringUtils.validateString(strPropertyName));
	// }

	public static String getSetMethodName(String strPropertyName) {
		return (StringUtils.validateString(strPropertyName));
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

	public static String getStringFromLinkedList(LinkedList mList, String strSplit) {
		if (mList == null)
			return "";

		strSplit = StringUtils.isValidateString(strSplit) ? StringUtils.validateString(strSplit) : ",";
		StringBuffer strBF = new StringBuffer();
		for (int i = 0; i < mList.size(); i++) {
			strBF.append((mList.get(i)).toString());
			strBF.append(strSplit);
		}
		String strReturn = strBF.toString();
		return StringUtils.cutEnd(strReturn, strSplit);
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

		if (!StringUtils.isValidateString(strInput)) {
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



	public static String getTableNameByComponentID(String componentID) {
		if (StringUtils.isValidateString(componentID)) {
			if (StringUtils.validateString(componentID).length() == 6) {
				return StringUtils.validateString(componentID).substring(0, 4);
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
				if (StringUtils.isValidateString((String) entry.getKey())) {
					strReturn = strReturn + strPrefix + (StringUtils.validateString((String) entry.getKey()));
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
				if (StringUtils.isValidateString((String) entry.getKey())) {
					strReturn = strReturn

							+ (StringUtils.validateString((String) entry.getValue()) + strPrefix);
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
				if (StringUtils.isValidateString((String) entry.getKey())) {
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
		if (!StringUtils.isValidateString(inStr)) {
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

		int m = StringUtils.validateString(allStr).indexOf(StringUtils.validateString(subStr));

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
		if (!StringUtils.isValidateString(format)) {
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
		if (!StringUtils.isValidateString(str)) {
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
		Random random = new Random();// 定义随机类
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
}
