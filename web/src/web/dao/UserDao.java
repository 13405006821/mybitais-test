package web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import base.dao.DaoSupport;
import model.PageData;
import web.entity.User;

@Repository("userDao")
public class UserDao {

	@Autowired
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	public List<User> findAll(PageData pd)throws Exception{
		return (List<User>) dao.findForList("userMapper.findAll", pd);
	}
}

