package base.dao;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

public class DaoSupport implements DAO {

	private SqlSessionTemplate sqlSessionTemplate;

	public Object save(String str, Object obj) throws Exception {
		return Integer.valueOf(this.sqlSessionTemplate.insert(str, obj));
	}

	public Object batchSave(String str, List<Object> objs) throws Exception {
		return Integer.valueOf(this.sqlSessionTemplate.insert(str, objs));
	}

	public Object update(String str, Object obj) throws Exception {
		return Integer.valueOf(this.sqlSessionTemplate.update(str, obj));
	}

	public void batchUpdate(String str, List<Object> objs) throws Exception {
		SqlSessionFactory sqlSessionFactory = this.sqlSessionTemplate.getSqlSessionFactory();

		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
		try {
			if (objs != null) {
				int i = 0;
				for (int size = objs.size(); i < size; i++) {
					sqlSession.update(str, objs.get(i));
				}
				sqlSession.flushStatements();
				sqlSession.commit();
				sqlSession.clearCache();
			}
		} finally {
			sqlSession.close();
		}
	}

	public Object batchDelete(String str, List<Object> objs) throws Exception {
		return Integer.valueOf(this.sqlSessionTemplate.delete(str, objs));
	}

	public Object delete(String str, Object obj) throws Exception {
		return Integer.valueOf(this.sqlSessionTemplate.delete(str, obj));
	}

	public Object findForObject(String str, Object obj) throws Exception {
		try {
			return this.sqlSessionTemplate.selectOne(str, obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Object findForList(String str, Object obj) throws Exception {
		return this.sqlSessionTemplate.selectList(str, obj);
	}

	public Object findForMap(String str, Object obj, String key, String value) throws Exception {
		return this.sqlSessionTemplate.selectMap(str, obj, key);
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}