package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.PageData;
import web.dao.UserDao;

@Service("userService")
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<PageData> findAll(PageData pd)throws Exception{
		return userDao.findAll(pd);
	}

	public void save(PageData pd) throws Exception {
		userDao.save(pd);
	}

	public void update(PageData pd) throws Exception {
		userDao.update(pd);
	}

	public void delete(PageData pd) throws Exception {
		userDao.delete(pd);
	}
}

