package util;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class PublicUtil {

	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}

	public static int getPageStartIndex(String page, String pageSize) {
		return (Integer.valueOf(page) - 1) * Integer.valueOf(pageSize);
	}
	
	/**
	 * 将对象转换成JSON字符串，并响应回前台
	 * 
	 * @param object
	 * @throws IOException
	 */
	public static void writeJson(Object object, HttpServletResponse response) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}