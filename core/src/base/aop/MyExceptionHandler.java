package base.aop;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import model.Json;
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
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().write(JSON.toJSONString(json));
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}