package com.pop136.customerservice.utils;

public class Constants {
	
	public final static String TAB_TYPE_MATERIAL = "0";
	public final static String TAB_TYPE_PRODUCT = "1";
	public final static String TAB_TYPE_VIDEO = "2";
	
	public final static String C_TYPE_MATERIAL = "0";
	public final static String C_TYPE_VIDEO = "1";
	
	public final static String A47800_C_TYPE_0000 = "A47800_C_TYPE_0000"; //产品 用remark和show_picurl
	public final static String A47800_C_TYPE_0001 = "A47800_C_TYPE_0001"; //图片 用remark和show_picurl
	public final static String A47800_C_TYPE_0002 = "A47800_C_TYPE_0002"; //视频 用remark和mediaurl
	public final static String A47800_C_TYPE_0003 = "A47800_C_TYPE_0003"; //外链 用remark和url
	public final static String A47800_C_TYPE_0004 = "A47800_C_TYPE_0004"; //活动l	
	

	//缓存redis
	public final static String REDIS_ACCOUNT_PREFIX ="USER_";
	
	//we chat appid
	public static final String appid = "wx58233ac296c3e76b";
	//we chat app secret
	public static final String secret = "7470e80a85602bb775e1bb88769190d0";	
	
	public static final String qiniu_ak = "9T7zmo64OytxPc_7IwyH80LT5LnnWsWsg4NrzlJ2";
	public static final String qiniu_sk = "CQ6u5rAzj4rqYN_o9AfQV1rx9-aP4Hghrh3uFhaU";
	public static final String qiniu_bucket = "match-mcr";	
	public static final String qiniu_url = "http://7xt9pc.com1.z0.glb.clouddn.com/";
	
	public static int qrcode_height = 300;
	public static int qrcode_width = 300;

	public static final String select_type_customer = "customer";
	public static final String select_type_contact = "contact";

	public static final String select_category_sel = "select";
	public static final String select_category_mul = "mulselect";

	// 系统设置
	// 部门管理120
	public static final String CRT_FRAMEWORK = "5141";

	// gp_framework
	public static final String TAB_FRAMEWORK = " gp_framework ";

}
