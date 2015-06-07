/**
 * 
 */
package com.mirror.API_interface.Qiniu;

import java.io.File;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * @author ShaoyiDuan ��ţAPI����
 */
public class Qiniu_Uploader {

	private String ACCESS_KEY = "2RI_6FfJDyrXak6Z1LLR1uqIIarS3JEBRdvHVlNP";
	private String SECRET_KEY = "igdpaFrIWjkmBAfUGlxLMEfJLSGwLPe4Jj_LDmMR";
	private String domain = "7xisij.com1.z0.glb.clouddn.com";

	private UploadManager uploadManager = new UploadManager();
	private Auth auth = null;

	Qiniu_Uploader() {
		this.auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	}

	public String getAK() {
		return ACCESS_KEY;
	}

	public String getSK() {
		return SECRET_KEY;
	}

	// ���ϴ���ʹ��Ĭ�ϲ���
	private String getUpToken0() {
		return auth.uploadToken("mirrorwebapp");
	}

	// �����ϴ�
	private String getUpToken1() {
		return auth.uploadToken("bucket", "key");
	}

	// ����ָ���ϴ�����
	private String getUpToken2() {
		return auth.uploadToken(
				"bucket",
				null,
				3600,
				new StringMap().put("callbackUrl", "call back url")
						.putNotEmpty("callbackHost", "")
						.put("callbackBody", "key=$(key)&hash=$(etag)"));
	}

	// ����Ԥ����ȥ�����޶��Ĳ����ֶ�
	private String getUpToken3() {
		return auth.uploadToken(
				"bucket",
				null,
				3600,
				new StringMap().putNotEmpty("persistentOps", "")
						.putNotEmpty("persistentNotifyUrl", "")
						.putNotEmpty("persistentPipeline", ""), true);
	}

	// �ϴ��ڴ�������
	public void upload(byte[] data, String key, String upToken) {
		try {
			Response res = uploadManager.put(data, key, upToken);
			// log.info(res);
			// log.info(res.bodyString());
			// Ret ret = res.jsonToObject(Ret.class);
			if (res.isOK()) {
				// success
			} else {
				//
			}
		} catch (QiniuException e) {
			Response r = e.response;
			// ����ʧ��ʱ��״̬��Ϣ
			System.out.println(r.toString());
			try {
				// ��Ӧ���ı���Ϣ
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
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
			// ����ʧ��ʱ��״̬��Ϣ
			System.out.println(r.toString());
			try {
				// ��Ӧ���ı���Ϣ
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				//
			}
		}
	}//upload file

	/**
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
