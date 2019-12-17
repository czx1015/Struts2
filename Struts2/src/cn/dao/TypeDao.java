package cn.dao;

import java.util.List;

import cn.entity.Order;
import cn.entity.Type;
public interface TypeDao {
		//��ѯ������Ʒ
		List<Type> selectTypes();
		//�����̼�id��ѯ�Լ����е���Ʒ
		List<Type> selectMerchantsTypes(int us_id);
		//����idɾ����Ʒ
		void deleteType(int id);
		//����id��ѯ��Ʒ��Ϣ
		Type selectType(int id);
		//����id��ѯ��Ʒ��Ϣ�͵�����Ϣ
		Type selectUserType(int id);
		//�޸���Ʒ��Ϣ
		void updateType(Type type);
		//��⣬�����Ӧ����Ʒ����
		void addnumber(Order order);
		//���⣬������Ӧ����Ʒ����
		void diminishednumber(Order order);
		//�����Ʒ
		void addType(Type type);
		//����������ַ�������ģ����ѯ
		List<Type> search(Type type);
}
