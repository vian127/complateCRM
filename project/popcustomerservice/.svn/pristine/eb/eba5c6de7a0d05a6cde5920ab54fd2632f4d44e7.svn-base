package com.pop136.customerservice.utils;

import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class FileUtil {
	
	@SuppressWarnings("finally")
	public static String uploadImg(byte[] img) 
	{
		String imgurl = "";
		//构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());
		//...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);
		
		//...生成上传凭证，然后准备上传
		String accessKey = Constants.qiniu_ak;
		String secretKey = Constants.qiniu_sk;
		String bucket = Constants.qiniu_bucket;
		//默认不指定key的情况下，以文件内容的hash值作为文件名
		String key = null;
		try {
		    byte[] uploadBytes = img;
		    Auth auth = Auth.create(accessKey, secretKey);
		    String upToken = auth.uploadToken(bucket);
		    try {
		        Response response = uploadManager.put(uploadBytes, key, upToken);
		        //解析上传成功的结果
		        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
		        imgurl = Constants.qiniu_url + putRet.key;
		        //System.out.println(putRet.key);
		        //System.out.println(putRet.hash);
		    } catch (QiniuException ex) {
		        Response r = ex.response;
		        System.err.println(r.toString());
		        try {
		            System.err.println(r.bodyString());
		        } catch (QiniuException ex2) {
		            //ignore
		        }
		    }
		}finally 
		{
			return imgurl;	
		} 

	}
		
}
