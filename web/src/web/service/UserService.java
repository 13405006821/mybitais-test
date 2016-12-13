package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.PageData;
import util.UuidUtil;
import web.dao.UserDao;
import web.entity.User;

@Service("userService")
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> findAll(PageData pd)throws Exception{
		return userDao.findAll(pd);
	}

	public void saveUser(PageData pd) throws Exception {
		pd.put("id", UuidUtil.get32UUID());
		userDao.save(pd);
	}

	public void updateUser(PageData pd) throws Exception {
		userDao.update(pd);
	}
}
