package cn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.entity.User;

public interface UserDao {
	//用户登录,接口方法里包含多个参数时，使用@Param注解进行标识
	User loginUser(@Param("name")String name,@Param("pwd")String pwd);
	//查询是否存在该用户名称
	User selectName(String name);
	//用户注册
	void registerUser(User user);
	//查下所有用户
	List<User> selectUsers();
	//删除用户
	void deleteUser(int id);
	//根据id查询用户
	User selectUser(int id);
	//更新用户信息
	void updateUser(User user);
}
