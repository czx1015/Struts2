package cn.service;

import java.util.List;

import cn.dao.CollectDao;
import cn.entity.Collect;
import cn.util.MybatisUtil;

public class CollectServiceImpl implements CollectService {
//����ղ�
	@Override
	public void addCollect(Collect collect) {
		// TODO Auto-generated method stub
		try {
			CollectDao collectDao = MybatisUtil.getSqlSession().getMapper(CollectDao.class);
			collectDao.addCollect(collect);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
		}
	}
//��ѯ�����û����ղ�
	@Override
	public List<Collect> selectCollect() {
		CollectDao dao = MybatisUtil.getSqlSession().getMapper(CollectDao.class);
		List<Collect> collect = dao.selectCollect();
		MybatisUtil.close();
		return collect;
	}
//��ѯ���û��Ƿ����ղظ���Ʒ
	@Override
	public boolean exist(int us_id,int ty_id) {
		// TODO Auto-generated method stub
		boolean isExist;
		CollectDao dao =  MybatisUtil.getSqlSession().getMapper(CollectDao.class);
		Collect collect = dao.exist(us_id,ty_id);
		if(collect != null) {
			isExist = true;
		}else {
			isExist = false;
		}
		MybatisUtil.close();
		return isExist;
	}
//�����û�id����Ʒidɾ����Ӧ���ղ�
	@Override
	public void deleteCollect(int us_id, int ty_id) {
		// TODO Auto-generated method stub
		
		try {
			CollectDao dao = MybatisUtil.getSqlSession().getMapper(CollectDao.class);
			dao.deleteCollect(us_id, ty_id);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
		}
	}
	//�����û�id��ѯ�Լ����ղ�
	@Override
	public List<Collect> selectMyCollect(int us_id) {
		// TODO Auto-generated method stub
		CollectDao dao = MybatisUtil.getSqlSession().getMapper(CollectDao.class);
		List<Collect> collects = dao.selectMyCollect(us_id);
		MybatisUtil.close();
		return collects;
	}
	
	
}
