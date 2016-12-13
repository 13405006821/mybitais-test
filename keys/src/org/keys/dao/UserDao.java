package org.keys.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import base.dao.DaoSupport;
import model.PageData;

@Repository("userDao")
public class UserDao {

	@Autowired
	private DaoSupport dao;

	/**
	 * 根据token，返回userid
	 */
	public PageData findUserByToken(PageData pd)throws Exception{
		return (PageData) dao.findForObject("", pd);
	}
}

