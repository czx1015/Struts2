package cn.service;


import java.util.List;

import cn.dao.UserDao;
import cn.entity.User;
import cn.util.MybatisUtil;

public class UserServiceImpl implements UserService {
	// �û�ע��
	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		
				UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
				userDao.registerUser(user);
				MybatisUtil.commit();
	}
	//�û���¼
	@Override
	public User loginUser(String name,String pwd) {
		// TODO Auto-generated method stub
		UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		User user = userDao.loginUser(name,pwd);
		MybatisUtil.close();
		return user;
	}
	//	��ѯ���û����Ƿ����
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
	//��ѯ�����û���Ϣ
	@Override
	public List<User> selectUsers() {
		// TODO Auto-generated method stub
		UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		List<User> list = userDao.selectUsers();
		MybatisUtil.close();
		return list;
	}
	//ɾ���û�
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
	//�޸��û���Ϣ
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
	//����id��ѯ���û���Ϣ
	@Override
	public User selectUser(int id) {
		// TODO Auto-generated method stub
		UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		User user = userDao.selectUser(id);
		MybatisUtil.close();
		return user;
	}

}
