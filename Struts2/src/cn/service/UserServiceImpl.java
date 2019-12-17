package cn.service;


import java.util.List;

import cn.dao.UserDao;
import cn.entity.User;
import cn.util.MybatisUtil;

public class UserServiceImpl implements UserService {
	// 用户注册
	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		
				UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
				userDao.registerUser(user);
				MybatisUtil.commit();
	}
	//用户登录
	@Override
	public User loginUser(String name,String pwd) {
		// TODO Auto-generated method stub
		UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		User user = userDao.loginUser(name,pwd);
		MybatisUtil.close();
		return user;
	}
	//	查询该用户名是否存在
	@Override
	public boolean selectName(String name) {
		boolean isExist;
		UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		User user = userDao.selectName(name);
		if(user != null) {
			isExist = true;
		}else {
			isExist = false;
		}
		MybatisUtil.close();
		return isExist;
	}
	//查询所有用户信息
	@Override
	public List<User> selectUsers() {
		// TODO Auto-generated method stub
		UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		List<User> list = userDao.selectUsers();
		MybatisUtil.close();
		return list;
	}
	//删除用户
	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		try {
			UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
			userDao.deleteUser(id);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
		}
	}
	//修改用户信息
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
			userDao.updateUser(user);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
		}
	}
	//根据id查询该用户信息
	@Override
	public User selectUser(int id) {
		// TODO Auto-generated method stub
		UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		User user = userDao.selectUser(id);
		MybatisUtil.close();
		return user;
	}

}
