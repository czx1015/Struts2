package cn.service;

import java.util.List;
import cn.dao.TypeDao;
import cn.entity.Order;
import cn.entity.Type;
import cn.util.MybatisUtil;

public class TypeServiceImpl implements TypeService {
	//查询所有商品
	@Override
	public List<Type> selectTypes() {
		// TODO Auto-generated method stub
		TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		List<Type> list = typeDao.selectTypes();
		MybatisUtil.close();
		return list;
	}
	//根据商家id查询自己所有的商品
	@Override
	public List<Type> selectMerchantsTypes(int us_id) {
		// TODO Auto-generated method stub
		TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		List<Type> list = typeDao.selectMerchantsTypes(us_id);
		MybatisUtil.close();
		return list;
	}
	//根据id删除商品
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
	//修改商品信息
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
	//根据id查询商品信息
	@Override
	public Type selectType(int id) {
		// TODO Auto-generated method stub
		TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		Type type = typeDao.selectType(id);
		MybatisUtil.close();
		return type;
	}
	//根据id查询商品信息和店铺信息
	@Override
	public Type selectUserType(int id) {
		// TODO Auto-generated method stub
		TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		Type type = typeDao.selectUserType(id);
		MybatisUtil.close();
		return type;
	}
	//添加商品
	@Override
	public void addType(Type type) {
		// TODO Auto-generated method stub
		TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		typeDao.addType(type);
		MybatisUtil.commit();
	}
	//入库，添加相应的商品数量
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
	//出库，减少相应的商品数量
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
	//根据输入的字符串进行模糊查询
	@Override
	public List<Type> search(Type type){
		TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		List<Type> list = typeDao.search(type);
		MybatisUtil.close();
		return list;
	}
}
