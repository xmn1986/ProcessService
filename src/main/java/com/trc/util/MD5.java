/**  
 * @Title:  MD5.java   
 * @Package com.hoo.util   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author libin 
 * @date:   2016年7月20日 下午4:48:43   
 * Copyright (c) 2016, 杭州海适云承科技有限公司 All Rights Reserved. 
 * @version V1.0
 */
package com.trc.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @ClassName: MD5
 * @Description: md5加密算法
 * @author libin
 * @date 2016年7月20日 下午4:48:43
 * 
 */
public class MD5 {

	/**
	* @Title: encryption 
	* @Description: 32位密文
	* @param @param plainText
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String encryption(String plainText) {
		String re_md5 = new String();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

			re_md5 = buf.toString();
			//System.out.println("md5 16bit: " + buf.toString().substring(8, 24));
			//System.out.println("md5 32bit: " + buf.toString());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return re_md5;
	}

	public static void main(String[] args) {
		//String date = DateUtils.formatDateTime(new Date());
		String date = "12345678";
		System.out.println("date="+date);
		System.out.println("MD5 32Bit : " + encryption(date));
	}

}
