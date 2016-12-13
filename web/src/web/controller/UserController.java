package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import base.controller.BaseController;
import model.Json;
import model.PageData;
import web.service.UserService;

@Controller
@RequestMapping({ "/user" })
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;

	@RequestMapping({ "/getUsers" })
	@ResponseBody
	public Json getUsers() throws Exception {
		Json json = new Json();
		try {
			PageData pd = getPageData();
			json.setSuccess(true);
			json.setObj(userService.findAll(pd));
		} catch (Exception e) {
			json.setSuccess(false);
			e.printStackTrace();
		}
		return json;
	}
}