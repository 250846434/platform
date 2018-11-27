package com.lc.platform.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonUtil {
	/**
	 * 都为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isAllEmpty(Object... objs) {
		for (Object obj : objs)
			if (isNotEmpty(obj))
				return false;
		return true;
	}

	/**
	 * 其中之一为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isOrEmpty(Object... objs) {
		for (Object obj : objs)
			if (isEmpty(obj))
				return true;
		return false;
	}

	/**
	 * 都不为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isAllNotEmpty(Object... objs) {
		for (Object obj : objs)
			if (isEmpty(obj))
				return false;
		return true;
	}

	/**
	 * 其中之一不为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isOrNotEmpty(Object... objs) {
		for (Object obj : objs)
			if (isNotEmpty(obj))
				return true;
		return false;
	}
	/**
	 * 是否为空
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;
		if (obj.toString().trim().length() == 0 || obj.toString().trim().equalsIgnoreCase("null"))
			return true;
		if (obj instanceof List) {
			return ((List<?>) obj).size() == 0;
		}
		if (obj instanceof Map) {
			return ((Map<?, ?>) obj).isEmpty();
		}
		return false;
	}
	/**
	 * 是否非空
	 * @param obj
	 * @return
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	public static String empty2Str(Object obj, String defaultStr) {
		return isEmpty(obj) ? defaultStr : obj.toString();
	}

	/**
	 * 校验是否有sql注入
	 * 
	 * @param params
	 * @return 有注入返回true
	 */
	public static boolean checkSqlInje(String... params) {
		for (String param : params) {
			if (!param.replaceAll(".*([';]+|(--)+).*", " ").equals(param)) {
				log.error("接收到疑似sql注入的请求!" + toStrPrint(params));
				return true;
			}
		}

		return false;
	}
	/**
	 * 数组转字符串.' '(空格链接)
	 * @param strs
	 * @return
	 */
	private static String toStrPrint(String... strs) {
		StringBuffer sb = new StringBuffer();
		for (String str : strs)
			sb.append(str).append(" ");
		return sb.toString();
	}
	/**
	 * 执行系统命令并返回结果
	 * @param command
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String exec(String command, String path) throws IOException {
		Runtime rt = Runtime.getRuntime();
		Process p = null;
		p = rt.exec(command, null, new File(path));

		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}
		p.destroy();
		br.close();
		return sb.toString();
	}
	/**
	 * 比较两个对象
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public static boolean equals(Object obj1, Object obj2) {
		if (obj1 == obj2)
			return true;
		if (obj1 == null || obj2 == null)
			return false;
		if (obj1.equals(obj2))
			return true;
		return false;
	}

}
