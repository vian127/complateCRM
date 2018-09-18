package com.pop136.customerservice.utils;



/**
 * Panding remove
 * @author kimmy.yang
 *
 */
public class GetRID {

	private static final int MAX_LENGTH = 64;

	private String prefix = "";

	private long lastTime = 0;

	private int increase = 1;


	public GetRID(String strCompCode, String strUserID, String strModuleID) {
		if ((StringUtils.isValidateString(strCompCode))
				&& (strCompCode.length() >= 10)) {
			strCompCode = strCompCode.substring(0, 10);
		}
		if ((StringUtils.isValidateString(strModuleID))
				&& (strModuleID.length() >= 10)) {
			strModuleID = strModuleID.substring(0, 10);
		}
		if ((StringUtils.isValidateString(strUserID))
				&& (strUserID.length() >= 10)) {
			strUserID = strUserID.substring(0, 10);
		}
		prefix = StringUtils.validateString(strCompCode)
				+ StringUtils.validateString(strModuleID)
				+ StringUtils.validateString(strUserID);
		lastTime = System.currentTimeMillis();
	}


	public synchronized String getId() {
		StringBuffer sb = new StringBuffer(prefix);
		sb.append("-");
		long thisTime = System.currentTimeMillis();

		if (thisTime == lastTime) {
			increase++;
			thisTime = thisTime + increase;
		} else {
			lastTime = thisTime;
		}

		sb.append(Long.toHexString(thisTime));
		sb.append(makeRandom(22));
		String strID = StringUtils.validateString(sb.toString());
		if (strID.length() > MAX_LENGTH) {
			strID = strID
					.substring(strID.length() - MAX_LENGTH, strID.length());
		}
		return strID.toUpperCase();
	}


	public synchronized String getId(int factor) {
		StringBuffer sb = new StringBuffer(prefix);
		sb.append("-");
		long thisTime = System.currentTimeMillis();

		if (thisTime == lastTime) {
			increase++;
			thisTime = thisTime + increase;
		} else {
			lastTime = thisTime;
		}
		String factor_16 = Integer.toHexString(factor);
		if ((factor_16.length() == 1)) {
			factor_16 = "0" + factor_16;
		}

		sb.append(Long.toHexString(thisTime));
		sb.append(makeRandom(10));
		sb.append(String.valueOf(factor_16));
		String strID = StringUtils.validateString(sb.toString());
		if (strID.length() > MAX_LENGTH) {
			strID = strID
					.substring(strID.length() - MAX_LENGTH, strID.length());
		}
		return strID.toUpperCase();
	}


	public synchronized String getNumId() {
		StringBuffer sb = new StringBuffer(prefix);
		sb.append("-");
		long thisTime = System.currentTimeMillis();

		if (thisTime == lastTime) {
			increase++;
			thisTime = thisTime + increase;
		} else {
			lastTime = thisTime;
		}

		sb.append(Long.toString(thisTime));
		sb.append(getMathRandon());
		return sb.toString().toUpperCase();
	}


	public String randomString(int numCharacters) {
		return makeRandom(numCharacters);
	}

	private String getMathRandon() {
		StringBuffer tmpStr = new StringBuffer();
		for (int i = 0; i < 1; i++) {
			int d1 = (int) (Math.random() * 10);
			tmpStr.append(Integer.toString(d1));
		}
		return tmpStr.toString();
	}

	private String makeRandom(int numChars) {
		String s = "";
		int d1, d2;
		char[] letters = initLetters();
		for (int i = 0; i < numChars; i++) {
			d1 = ((int) (Math.random() * 10) % 2);
			if (d1 == 0) { // use a letter
				d2 = ((int) (Math.random() * 100) % 26);
				s += letters[d2];
			} else if (d1 == 1) { // use a number
				s += (int) (Math.random() * 10);
			}
		}
		return s;
	}

	private char[] initLetters() {
		char[] ca = new char[26];
		for (int i = 0; i < 26; i++)
			ca[i] = (char) (65 + i);
		return ca;
	}

	public static void main(String args[]) {
		// String newid=new GetRID("abcd").getId();
		String newid = "";
		// for (int i = 0; i < 10000; i++) {
		newid = new GetRID("sdahjghjgxvcx", "dfgdfyuytfghgf",
				"iuuouiowqeqasdas").getId();
		System.out.println("newid--->" + newid);
		System.out.println(newid.length());
		// }
	}

}
