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
	
	public PageData findById(String id)throws Exception{
		return userDao.findById(id);
	}

	public void save(String username, String password) throws Exception {
		userDao.save(username, password);
	}

	public void update(String id, String username, String password) throws Exception {
		userDao.update(id, username, password);
	}

	public void delete(String id) throws Exception {
		userDao.delete(id);
	}
}

