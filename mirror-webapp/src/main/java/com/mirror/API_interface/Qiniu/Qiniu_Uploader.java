/**
 * 
 */
package com.mirror.API_interface.Qiniu;

import java.io.File;

import com.mirror.util.StringUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * @author ShaoyiDuan
 */
public class Qiniu_Uploader {

	private static final String ACCESS_KEY = "2RI_6FfJDyrXak6Z1LLR1uqIIarS3JEBRdvHVlNP";
	private static final String SECRET_KEY = "igdpaFrIWjkmBAfUGlxLMEfJLSGwLPe4Jj_LDmMR";
	private static final String BUCKET = "demomy";

	private UploadManager uploadManager = new UploadManager();
	private Auth auth = null;
	private BucketManager bucketManager = null;

	public Qiniu_Uploader() {
		this.auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		this.bucketManager = new BucketManager(this.auth);
	}

	public String getAK() {
		return ACCESS_KEY;
	}

	public String getSK() {
		return SECRET_KEY;
	}

	private String getUpToken0() {
		return auth.uploadToken("demomy");
	}

	private String getUpToken1() {
		return auth.uploadToken("bucket", "key");
	}

	private String getUpToken2() {
		return auth.uploadToken(
				"bucket",
				null,
				3600,
				new StringMap().put("callbackUrl", "call back url")
						.putNotEmpty("callbackHost", "")
						.put("callbackBody", "key=$(key)&hash=$(etag)"));
	}

	private String getUpToken3(String fileName) {
		return auth.uploadToken(
				"demomy",
				null,
				3600,
				new StringMap().putNotEmpty("persistentOps", "")
						.putNotEmpty("persistentNotifyUrl", "")
						.putNotEmpty("persistentPipeline", ""), true);
	}

	public int upload(byte[] data, String key) {
		try {
			
//			String upToken=getUpToken0();
			String upToken=getUpToken3(key);
			Response res = uploadManager.put(data, key, upToken);
			// log.info(res);
			// log.info(res.bodyString());
			// Ret ret = res.jsonToObject(Ret.class);
			if (res.isOK()) {
				return 1;
			} else {
				return 0;
			}
		} catch (QiniuException e) {
			Response r = e.response;
			System.out.println(r.toString());
			try {
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				return 0;
			}
			
			return 0;
		}
	}

	public void uploadFile(File file) {
		try {
			Response res = uploadManager.put(file, "test_key", getUpToken0());
			// log.info(res);
			// log.info(res.bodyString());
			// Ret ret = res.jsonToObject(Ret.class);
			System.out.println(res.bodyString());
		} catch (QiniuException e) {
			Response r = e.response;
			System.out.println(r.toString());
			try {
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
	}//upload file

	//É¾³ýÆßÅ£´æ´¢µÄÎÄ¼þ
	public void	deleteWork(String key) throws QiniuException{
		this.bucketManager.delete(this.BUCKET, key);
	}
	/**for test
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test qiniu uploader");
		
		File image=new File("D:\\Image\\IMG_test.jpg");
		
		Qiniu_Uploader qt=new Qiniu_Uploader();
		
		qt.uploadFile(image);
				
	}

}
