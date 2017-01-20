package base.aop;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Json;
import util.SysConstants;

/**
 * 统一报错处理
 * @author liup
 *
 */
public class MyExceptionHandler {
	
	protected Logger logger = Logger.getLogger(getClass());
	
	@ExceptionHandler
	@ResponseBody
	public Json exceptionHandler(HttpServletRequest request, Exception ex) {
		logger.error(ex.getMessage());
		ex.printStackTrace();
		Json json = new Json();
		json.setSuccess(false);
		json.setMsg(SysConstants.SYS_ERROR);
		return json;
	}
}
