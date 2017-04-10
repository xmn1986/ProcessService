package com.trc.dao.util;

import java.util.HashMap;
import java.util.Map;

public class SqlMapUtils {

	public static Map<String, String> mapsMap = new HashMap<String, String>();

	static{
		mapsMap.put("cn.resoft.dmps.dao.domain.EtlJob", "ETL_JOB");
		mapsMap.put("cn.resoft.dmps.dao.domain.EtlUser", "ETL_USER");
	}
}
