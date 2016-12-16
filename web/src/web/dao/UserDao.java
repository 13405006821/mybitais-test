package web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import base.dao.DaoSupport;
import model.PageData;
import util.UuidUtil;

@Repository("userDao")
public class UserDao {

	@Autowired
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	public List<PageData> findAll(PageData pd)throws Exception{
		return (List<PageData>) dao.findForList("userMapper.findAll", pd);
	}

	public void save(PageData pd) throws Exception {
		pd.put("id", UuidUtil.get32UUID());
		dao.save("userMapper.save", pd);
	}

	public void update(PageData pd) throws Exception {
		dao.update("userMapper.update", pd);
	}

	public void delete(PageData pd) throws Exception {
		dao.update("userMapper.delete", pd);
	}
}

