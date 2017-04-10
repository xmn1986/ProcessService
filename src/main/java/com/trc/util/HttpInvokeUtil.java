package com.trc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.trc.exception.BizException;

public class HttpInvokeUtil {

	private static Log log = LogFactory.getLog(HttpInvokeUtil.class);
	/**
	 * http服务地址
	 */
	private String url;
	/**
	 * 调用参数map
	 */
	private Map<String, String> paramMap;
	
	public void setUrl(String url) {
		this.url = url;
	}
	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}

	public AppResult httpInvoke() {
		if (StringUtils.isEmpty(url)) {
			throw new BizException("http接口调用地址参数url不能为空");
		}
		if (null == paramMap) {
			throw new BizException("http接口调用参数paramMap不能为空");
		}
		Date dateStart = new Date();
		long start = System.nanoTime();
		log.info("http调用开始时间:" + DateUtils.dateToNormalFullString(dateStart)
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
			log.info("Http接口GET调用请求url：" + invokeUrl + "请求参数："
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
			log.error("Http接口调用异常：" + e);
		} catch (IOException e) {
			log.error("Http接口调用IO异常：" + e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				log.error("关闭Http返回结果流异常", e);
			}
			// 6.释放连接
			getMethod.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
		Date dateEnd = new Date();
		long end = System.nanoTime();
		log.info("http调用返回结果:" + responseMsg);
		log.info("http调用结束时间:" + DateUtils.dateToNormalFullString(dateEnd)
				+ ", 耗时" + DateUtils.getMilliSecondBetween(start, end)
				+ "毫秒<<<<<<<<<<<<<<<<");
		return (AppResult)JSONObject.toBean(JSONObject.fromObject(responseMsg), AppResult.class);
	}
	
}
