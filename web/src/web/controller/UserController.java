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

	@RequestMapping({ "/findAll" })
	@ResponseBody
	public Json findAll() throws Exception {
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
	
	@RequestMapping({ "/findById" })
	@ResponseBody
	public Json findById() throws Exception {
		Json json = new Json();
		try {
			PageData pd = getPageData();
			json.setSuccess(true);
			json.setObj(userService.findById(pd));
		} catch (Exception e) {
			json.setSuccess(false);
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping({ "/save" })
	@ResponseBody
	public Json save() throws Exception {
		Json json = new Json();
		try {
			PageData pd = getPageData();
			userService.save(pd);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping({ "/update" })
	@ResponseBody
	public Json update() throws Exception {
		Json json = new Json();
		try {
			PageData pd = getPageData();
			userService.update(pd);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping({ "/delete" })
	@ResponseBody
	public Json delete() throws Exception {
		Json json = new Json();
		try {
			PageData pd = getPageData();
			userService.delete(pd);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			e.printStackTrace();
		}
		return json;
	}
}