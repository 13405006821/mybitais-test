package web.controller;

import java.util.List;

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

	@RequestMapping({ "/findPage" })
	public String findPage() throws Exception {
		PageData pd = getPageData();
		List<PageData> users = userService.findPage(pd.getString("page"), pd.getString("pageSize"));
		getRequest().setAttribute("users", users);
		return "";
	}
	
	@RequestMapping({ "/findById" })
	@ResponseBody
	public Json findById() throws Exception {
		Json json = new Json();
		PageData pd = getPageData();
		json.setSuccess(true);
		json.setObj(userService.findById(pd.getString("id")));
		return json;
	}
	
	@RequestMapping({ "/save" })
	@ResponseBody
	public Json save() throws Exception {
		Json json = new Json();
		PageData pd = getPageData();
		userService.save(pd.getString("username"), pd.getString("password"));
		json.setSuccess(true);
		return json;
	}
	
	@RequestMapping({ "/update" })
	@ResponseBody
	public Json update() throws Exception {
		Json json = new Json();
		PageData pd = getPageData();
		userService.update(pd.getString("id"), pd.getString("username"), pd.getString("password"));
		json.setSuccess(true);
		return json;
	}
	
	@RequestMapping({ "/delete" })
	@ResponseBody
	public Json delete() throws Exception {
		Json json = new Json();
		PageData pd = getPageData();
		userService.delete(pd.getString("id"));
		json.setSuccess(true);
		return json;
	}
}