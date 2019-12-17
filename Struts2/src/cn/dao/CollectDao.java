package cn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.entity.Collect;

public interface CollectDao {
	//����ղ�
	void addCollect(Collect collect);
	//��ѯ���е��ղ�
	List<Collect> selectCollect();
	//��ѯ���û��Ƿ����ղظ���Ʒ
	Collect exist(@Param("us_id")int us_id,@Param("ty_id")int ty_id);
	//�����û�ID����Ʒidɾ����Ӧ���ղ�
	void deleteCollect(@Param("us_id")int us_id,@Param("ty_id")int ty_id);
	//����id��ѯ�Լ����ղ�
	List<Collect> selectMyCollect(int us_id);
}
