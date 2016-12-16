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

	public List<PageData> findAll()throws Exception{
		return userDao.findAll();
	}
	
	public PageData findById(PageData pd)throws Exception{
		return userDao.findById(pd);
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

