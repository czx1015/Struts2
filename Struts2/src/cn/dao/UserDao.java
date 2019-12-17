package cn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.entity.User;

public interface UserDao {
	//�û���¼,�ӿڷ���������������ʱ��ʹ��@Paramע����б�ʶ
	User loginUser(@Param("name")String name,@Param("pwd")String pwd);
	//��ѯ�Ƿ���ڸ��û�����
	User selectName(String name);
	//�û�ע��
	void registerUser(User user);
	//���������û�
	List<User> selectUsers();
	//ɾ���û�
	void deleteUser(int id);
	//����id��ѯ�û�
	User selectUser(int id);
	//�����û���Ϣ
	void updateUser(User user);
}
