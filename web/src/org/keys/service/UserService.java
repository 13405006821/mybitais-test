package org.keys.service;

import org.keys.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.PageData;

@Service("userService")
public class UserService {

	@Autowired
	private UserDao userDao;

	public PageData findUserByToken(PageData pd)throws Exception{
		return userDao.findUserByToken(pd);
	}
}

