package web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import base.dao.DaoSupport;
import model.PageData;
import util.PublicUtil;

@Repository("userDao")
public class UserDao {

	@Autowired
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	public List<PageData> findAll()throws Exception{
		return (List<PageData>) dao.findForList("userMapper.findAll", null);
	}

	@SuppressWarnings("unchecked")
	public List<PageData> findPage(String page, String pageSize) throws Exception {
		PageData pd = new PageData();
		pd.put("startIndex", PublicUtil.getPageStartIndex(page, pageSize));
		pd.put("pageSize", pageSize);
		return (List<PageData>) dao.findForList("userMapper.findPage", pd);
	}
	
	public PageData findById(String id) throws Exception{
		PageData pd = new PageData();
		pd.put("id", id);
		return (PageData) dao.findForObject("userMapper.findById", pd);
	}

	public void save(String username, String password) throws Exception {
		PageData pd = new PageData();
		pd.put("id", PublicUtil.get32UUID());
		pd.put("username", username);
		pd.put("password", password);
		dao.save("userMapper.save", pd);
	}

	public void update(String id, String username, String password) throws Exception {
		PageData pd = new PageData();
		pd.put("id", id);
		pd.put("username", username);
		pd.put("password", password);
		dao.update("userMapper.update", pd);
	}

	public void delete(String id) throws Exception {
		PageData pd = new PageData();
		pd.put("id", id);
		dao.update("userMapper.delete", pd);
	}
}