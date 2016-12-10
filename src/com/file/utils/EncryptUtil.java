package com.file.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * @ClassName: EncryptUtil 
 * @Description: ���ܹ�����
 * @author: LG
 * @date: 2016��11��26�� ����3:50:11
 */
public class EncryptUtil {
	/**
	 * @Title: getEncrypt 
	 * @Description: ���ݲ�ͬ��ժҪ���ԣ�md5\sha����������
	 * @param str ����--�����ܵ��ַ���
	 * @param type	����--���ܵĲ���
	 * @return
	 * @return: String ����
	 */
	public static String getEncrypt(String str , String type){
		String encode = null ;
		try {
			//��ȡ��ϢժҪ���󣨸��ݲ�ͬ�Ĳ��ԣ�md5��sha��
			MessageDigest digest = MessageDigest.getInstance(type);
			//ʹ��ժҪ�����ȡժҪ �� �Ӽ��ܶ�����ֽ�������
			byte[] digest2 = digest.digest(str.getBytes("UTF-8"));
			//����ժҪ
			digest.update(digest2);
			//��ȡ�������
			BASE64Encoder base64Encoder = new BASE64Encoder();
			//�����յ�ժҪ��Ϣ����
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
		//char			�����ַ���		��ѯЧ�ʸߡ�ռ�ÿռ�ϴ�
		//varchar		�䳤�ַ���
		
		
		System.out.println(getEncrypt("123123", "SHA"));
		System.out.println(getEncrypt("123123", "SHA").length()); //28
		//YB8YiWZ++uuzO4wSVyg12j8Cf3g=
		
	}
	
}
