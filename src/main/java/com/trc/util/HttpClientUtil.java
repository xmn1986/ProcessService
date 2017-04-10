package com.trc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.trc.exception.BizException;

public class HttpClientUtil {

	private static Log log = LogFactory.getLog(HttpClientUtil.class);

	/**
	 * httpClient客户端post方式请求
	 * 
	 * @Title: postMethod
	 * @Description:
	 * @param @param url 接口地址
	 * @param @param paramMap 参数： 如：[{"aaa", "bbb"},{"data":{"test":"123"}}]
	 *        表示2个参数aaa=bbb和data={"test":"123"}
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String postMethod(String url, Map<String, String> paramMap) {
		Date dateStart = new Date();
		long start = System.nanoTime();
		log.warn("http调用开始时间:" + DateUtils.dateToNormalFullString(dateStart)
				+ ">>>>>>>>>>>>>>>>>");
		if (StringUtils.isEmpty(url)) {
			throw new BizException("http接口调用地址参数url不能为空");
		}
		if (null == paramMap) {
			throw new BizException("http接口调用参数paramMap不能为空");
		}
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setContentCharset("UTF-8");
		PostMethod postMethod = new PostMethod(url);
		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> entry : paramMap.entrySet()) {
			NameValuePair nameValuePair = new NameValuePair(entry.getKey(),
					entry.getValue());
			paramList.add(nameValuePair);
		}
		NameValuePair[] data = paramList.toArray(new NameValuePair[paramList
				.size()]);
		postMethod.setRequestBody(data);
		JSONObject paramObj = JSONObject.fromObject(paramMap);
		String responseMsg = "";
		try {
			log.warn("Http接口POST调用请求：" + url + "，调用参数：" + paramObj.toString());
			httpClient.executeMethod(postMethod);
			responseMsg = postMethod.getResponseBodyAsString().trim();
			log.warn("Http接口调用返回结果：" + responseMsg);
		} catch (HttpException e) {
			log.warn("Http接口调用异常：" + e);
		} catch (IOException e) {
			log.warn("Http接口调用IO异常：" + e);
		} finally {
			postMethod.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
		Date dateEnd = new Date();
		long end = System.nanoTime();
		log.warn("http调用返回结果:" + responseMsg);
		log.warn("http调用结束时间:" + DateUtils.dateToNormalFullString(dateEnd)
				+ ", 耗时" + DateUtils.getMilliSecondBetween(start, end)
				+ "毫秒<<<<<<<<<<<<<<<<");
		return responseMsg;
	}

	/**
	 * httpClient客户端post方式请求
	 * 
	 * @Title: postMethod
	 * @Description:
	 * @param @param url 接口地址
	 * @param @param paramMap 参数： 如：[{"aaa", "bbb"},{"data":{"test":"123"}}]
	 *        表示2个参数aaa=bbb和data={"test":"123"}
	 * @param @return
	 * @return String
	 * @throws
	 */
	public AppResult getMethod(String url, Map<String, String> paramMap) {
		if (StringUtils.isEmpty(url)) {
			throw new BizException("http接口调用地址参数url不能为空");
		}
		if (null == paramMap) {
			throw new BizException("http接口调用参数paramMap不能为空");
		}
		Date dateStart = new Date();
		long start = System.nanoTime();
		log.warn("http调用开始时间:" + DateUtils.dateToNormalFullString(dateStart)
				+ ">>>>>>>>>>>>>>>>>");
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setContentCharset("UTF-8");
		StringBuilder stringBuilder = new StringBuilder();
		for (Map.Entry<String, String> entry : paramMap.entrySet()) {
			stringBuilder.append(entry.getKey());
			stringBuilder.append("=");
			if(null != entry.getValue())
				stringBuilder.append(String.valueOf(entry.getValue()));
			else{
				stringBuilder.append("");
			}
			stringBuilder.append("&");
		}
		String paramStr = stringBuilder.toString();
		if (paramStr.length() > 0) {
			paramStr = paramStr.substring(0, paramStr.length() - 1);
		}
		String invokeUrl = url + "?" + paramStr;
		GetMethod getMethod = new GetMethod(invokeUrl);
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		BufferedReader br = null;
		String responseMsg = "";
		try {
			JSONObject paramObj = JSONObject.fromObject(paramMap);
			log.warn("Http接口GET调用请求url：" + invokeUrl + "请求参数："
					+ paramObj.toString());
			httpClient.executeMethod(getMethod);
			InputStream ins = getMethod.getResponseBodyAsStream();
			br = new BufferedReader(new InputStreamReader(ins, "UTF-8"));
			StringBuffer sbf = new StringBuffer();
			while ((responseMsg = br.readLine()) != null) {
				sbf.append(responseMsg);
			}
			responseMsg = sbf.toString();
			log.warn("Http接口调用返回结果：" + responseMsg);
		} catch (HttpException e) {
			log.warn("Http接口调用异常：" + e);
		} catch (IOException e) {
			log.warn("Http接口调用IO异常：" + e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				log.warn("关闭Http返回结果流异常", e);
			}
			// 6.释放连接
			getMethod.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
		Date dateEnd = new Date();
		long end = System.nanoTime();
		log.warn("http调用返回结果:" + responseMsg);
		log.warn("http调用结束时间:" + DateUtils.dateToNormalFullString(dateEnd)
				+ ", 耗时" + DateUtils.getMilliSecondBetween(start, end)
				+ "毫秒<<<<<<<<<<<<<<<<");
		return (AppResult)JSONObject.toBean(JSONObject.fromObject(responseMsg), AppResult.class);
	}

	public static void main(String[] args) {
		HttpClientUtil clientUtil = new HttpClientUtil();
		String json = "{\"certId\":\"330721198807012444\",\"jzxh\":\"251334\",\"treateType\":\"2\"}";

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("sendto", "15068839416");
		paramMap.put("params", "[111,222,333,444,5555]");
		// String result =
		// clientUtil.postMethod("http://127.0.0.1:8888/TrcOA/services/",
		// paramMap);
		AppResult appResult = clientUtil.getMethod(
				"http://127.0.0.1:8080/TrcOA/leave/employeApply.do",
				paramMap);
		System.out.println("###=" + appResult.getResult());
	}

}
