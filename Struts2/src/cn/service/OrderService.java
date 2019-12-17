package cn.service;

import java.util.List;

import cn.entity.Order;

public interface OrderService {
	//�ύ�����������ݱ�ǩ�ж��ǳ��⻹�����
	void submitOrder(Order order);
	//��ѯ���еĶ�����Ϣ
	List<Order> selectOrders();
//	List<Order> selectMerchantsOrders(int us_id);
	//�����û�id��ѯ����
	List<Order> selectTypeOrders(int us_id);
	//�����̼�id��ѯ���̼ҵ��̳�������
	List<Order> storerooms(int us_id);
	//�����̼�id�Ը��̼ҳ�����������ͳ��
	List<Order> statistics(int us_id);
	//��ѯ���е��̼ҵĳ�������
	List<Order> adminstorerooms();
	//�����е��̼ҳ�����������ͳ��
	List<Order> adminstatistics();
	//��ѯ�����ܽ��
	List<Order> tagprice();
	//ɾ������
	void deleteOrder(String id);
}
