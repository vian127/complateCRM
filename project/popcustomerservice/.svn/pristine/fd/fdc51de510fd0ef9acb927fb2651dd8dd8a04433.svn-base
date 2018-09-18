package com.pop136.customerservice.utils;

/**
 * Created by XH on 2018-8-14.
 */
import java.security.MessageDigest;

abstract public class MD5 {

    private static final String SYN_PARA = "?synflag=";

    private static final String SYN_FLAG = "01111110";

    public static String byte2hex(byte[] b) // 二进制转字符串
    {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;

        }
        return hs.toUpperCase();
    }

    public static String GetMD5(String sInput) throws Exception {

        MessageDigest alga = MessageDigest.getInstance("MD5");
        alga.update(sInput.getBytes());
        byte[] digesta = alga.digest();
        return byte2hex(digesta);

    }

    public static boolean validateSynFlag(String strSynFlag) throws Exception {
        String strLocalFlag = getSynFlag("");
        if ((strLocalFlag).equalsIgnoreCase(strSynFlag)) {
            return true;
        } else {
            return false;
        }
    }

    public static String getSynFlag(String strUrl) throws Exception {
        return  StringUtils.validateString(strUrl) +SYN_PARA
                + MD5.GetMD5(SystemDate.getCurDate() + SYN_FLAG);
    }

    public static void main(String[] a) {
        try {
            System.out.print("--------------");
            System.out.print(MD5.GetMD5("2010-03-1001111110"));
            // 900150983cd24fb0d6963f7d28e17f72 //abc
            for (int i = 1; i < 2000; i++) {
                // System.out.print(MD5.GetMD5(Integer.toString(i)));
            }

        } catch (Exception e) {
        }
    }
}