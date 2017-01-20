package util;

import java.util.UUID;

public class PublicUtil {

	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}

	public static int getPageStartIndex(String page, String pageSize) {
		return (Integer.valueOf(page) - 1) * Integer.valueOf(pageSize);
	}
}