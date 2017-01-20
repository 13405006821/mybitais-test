package base.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import model.Json;
import util.PublicUtil;
import util.SysConstants;

/**
 * 统一报错处理
 * 
 * @author liup
 *
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) {
		exception.printStackTrace();
		Json json = new Json();
		json.setSuccess(false);
		json.setMsg(SysConstants.SYS_ERROR);
		PublicUtil.writeJson(json, response);
		return null;
	}
}