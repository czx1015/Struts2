package cn.service;

import java.util.List;

import cn.entity.Collect;

public interface CollectService {
	//����ղ�
	void addCollect(Collect collect);
	//��ѯ�����û����ղ�
	List<Collect> selectCollect();
	//��ѯ���û��Ƿ����ղظ���Ʒ
	boolean exist(int us_id,int ty_id);
	//�����û�id����Ʒidɾ����Ӧ���ղ�
	void deleteCollect(int us_id,int ty_id);
	//�����û�id��ѯ�Լ����ղ�
	List<Collect> selectMyCollect(int us_id);
}
