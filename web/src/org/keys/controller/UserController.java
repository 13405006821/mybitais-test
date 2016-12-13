package org.keys.controller;

import org.keys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import base.controller.BaseController;
import model.Json;
import model.PageData;

@Controller
@RequestMapping({ "/user" })
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;

	/**
	 * 用户注册
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/getUser" })
	@ResponseBody
	public Json register() throws Exception {
		Json json = new Json();
		try {
			PageData pd = getPageData();
			json.setSuccess(true);
			json.setObj(userService.findUserByToken(pd));
		} catch (Exception e) {
			json.setSuccess(false);
			e.printStackTrace();
		}
		return json;
	}
}