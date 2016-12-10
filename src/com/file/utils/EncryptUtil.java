package com.file.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * @ClassName: EncryptUtil 
 * @Description: 加密工具类
 * @author: LG
 * @date: 2016年11月26日 下午3:50:11
 */
public class EncryptUtil {
	/**
	 * @Title: getEncrypt 
	 * @Description: 根据不同的摘要策略（md5\sha）生成密文
	 * @param str 明文--被加密的字符串
	 * @param type	策略--加密的策略
	 * @return
	 * @return: String 密文
	 */
	public static String getEncrypt(String str , String type){
		String encode = null ;
		try {
			//获取消息摘要对象（根据不同的策略：md5、sha）
			MessageDigest digest = MessageDigest.getInstance(type);
			//使用摘要对象获取摘要 ， 从加密对象的字节数组中
			byte[] digest2 = digest.digest(str.getBytes("UTF-8"));
			//更新摘要
			digest.update(digest2);
			//获取编码对象
			BASE64Encoder base64Encoder = new BASE64Encoder();
			//对最终的摘要信息编码
			encode = base64Encoder.encode(digest2);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encode ;
	}
	public static void main(String[] args) {
		System.out.println(getEncrypt("123123", "MD5"));
		System.out.println(getEncrypt("123123", "MD5").length()); //24
		//Qpf0SxOVUjUkWySXOZ16kw==
		//Qpf0SxOVUjUkWySXOZ16kw==
		//char			定长字符串		查询效率高、占用空间较大
		//varchar		变长字符串
		
		
		System.out.println(getEncrypt("123123", "SHA"));
		System.out.println(getEncrypt("123123", "SHA").length()); //28
		//YB8YiWZ++uuzO4wSVyg12j8Cf3g=
		
	}
	
}
