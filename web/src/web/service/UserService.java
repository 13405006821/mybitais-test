package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.PageData;
import web.dao.UserDao;
import web.entity.User;

@Service("userService")
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> findAll(PageData pd)throws Exception{
		return userDao.findAll(pd);
	}
}

