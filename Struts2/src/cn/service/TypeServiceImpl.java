package cn.service;

import java.util.List;
import cn.dao.TypeDao;
import cn.entity.Order;
import cn.entity.Type;
import cn.util.MybatisUtil;

public class TypeServiceImpl implements TypeService {
	//��ѯ������Ʒ
	@Override
	public List<Type> selectTypes() {
		// TODO Auto-generated method stub
		TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		List<Type> list = typeDao.selectTypes();
		MybatisUtil.close();
		return list;
	}
	//�����̼�id��ѯ�Լ����е���Ʒ
	@Override
	public List<Type> selectMerchantsTypes(int us_id) {
		// TODO Auto-generated method stub
		TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		List<Type> list = typeDao.selectMerchantsTypes(us_id);
		MybatisUtil.close();
		return list;
	}
	//����idɾ����Ʒ
	@Override
	public void deleteType(int id) {
		// TODO Auto-generated method stub
		try {
			TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
			typeDao.deleteType(id);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
		}
	}
	//�޸���Ʒ��Ϣ
	@Override
	public void updateType(Type type) {
		// TODO Auto-generated method stub
		try {
			TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
			typeDao.updateType(type);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
		}
	}
	//����id��ѯ��Ʒ��Ϣ
	@Override
	public Type selectType(int id) {
		// TODO Auto-generated method stub
		TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		Type type = typeDao.selectType(id);
		MybatisUtil.close();
		return type;
	}
	//����id��ѯ��Ʒ��Ϣ�͵�����Ϣ
	@Override
	public Type selectUserType(int id) {
		// TODO Auto-generated method stub
		TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		Type type = typeDao.selectUserType(id);
		MybatisUtil.close();
		return type;
	}
	//�����Ʒ
	@Override
	public void addType(Type type) {
		// TODO Auto-generated method stub
		TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		typeDao.addType(type);
		MybatisUtil.commit();
	}
	//��⣬�����Ӧ����Ʒ����
	@Override
	public void addnumber(Order order) {
		// TODO Auto-generated method stub
		try {
			TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
			typeDao.addnumber(order);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
		}
	}
	//���⣬������Ӧ����Ʒ����
	@Override
	public void diminishednumber(Order order) {
		// TODO Auto-generated method stub
		try {
			TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
			typeDao.diminishednumber(order);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
		}
	}
	//����������ַ�������ģ����ѯ
	@Override
	public List<Type> search(Type type){
		TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		List<Type> list = typeDao.search(type);
		MybatisUtil.close();
		return list;
	}
}
