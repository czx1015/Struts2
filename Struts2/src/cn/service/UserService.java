package cn.service;

import java.util.List;

import cn.entity.User;

public interface UserService {
	//用户登录
	User loginUser(String name,String pwd);
	//查询是否存在该用户名
	boolean selectName(String name); 
	//用户注册
	void registerUser(User User);
	//查询所有用户信息
	List<User> selectUsers();
	//删除用户
	void deleteUser(int id);
	//根据id查询用户
	User selectUser(int id);
	//修改用户信息
	void updateUser(User user);
}
