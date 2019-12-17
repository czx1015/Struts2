package cn.service;

import java.util.List;

import cn.entity.User;

public interface UserService {
	//�û���¼
	User loginUser(String name,String pwd);
	//��ѯ�Ƿ���ڸ��û���
	boolean selectName(String name); 
	//�û�ע��
	void registerUser(User User);
	//��ѯ�����û���Ϣ
	List<User> selectUsers();
	//ɾ���û�
	void deleteUser(int id);
	//����id��ѯ�û�
	User selectUser(int id);
	//�޸��û���Ϣ
	void updateUser(User user);
}
