package cn.service;

import java.util.List;
import cn.dao.OrderDao;
import cn.entity.Order;
import cn.util.MybatisUtil;

public class OrderServiceImpl implements OrderService {
	//�ύ�����������ݱ�ǩ�ж��ǳ��⻹�����
	@Override
	public void submitOrder(Order order) {
		// TODO Auto-generated method stub
		try {
			OrderDao orderDao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
			orderDao.submitOrder(order);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
		}
	}
	//��ѯ���еĶ�����Ϣ
	@Override
	public List<Order> selectOrders() {
		// TODO Auto-generated method stub
		OrderDao dao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		List<Order> orders = dao.selectOrders();
		MybatisUtil.close();
		return orders;
	}
//	@Override
//	public List<Order> selectMerchantsOrders(int us_id) {
//		// TODO Auto-generated method stub
//		OrderDao dao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
//		List<Order> orders = dao.selectMerchantsOrders(us_id);
//		MybatisUtil.close();
//		return orders;
//	}
	//�����û�id��ѯ����
	@Override
	public List<Order> selectTypeOrders(int us_id) {
		// TODO Auto-generated method stub
		OrderDao dao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		List<Order> orders = dao.selectTypeOrders(us_id);
		MybatisUtil.close();
		return orders;
	}
	//�����̼�id��ѯ���̼ҵ��̳�������
	@Override
	public List<Order> storerooms(int us_id) {
		// TODO Auto-generated method stub
		OrderDao dao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		List<Order> orders = dao.storerooms(us_id);
		MybatisUtil.close();
		return orders;
	}
	//�����̼�id�Ը��̼ҳ�����������ͳ��
	@Override
	public List<Order> statistics(int us_id) {
		// TODO Auto-generated method stub
		OrderDao dao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		List<Order> orders = dao.statistics(us_id);
		MybatisUtil.close();
		return orders;
	}
	//��ѯ���е��̼ҵĳ�������
	@Override
	public List<Order> adminstorerooms() {
		// TODO Auto-generated method stub
		OrderDao dao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		List<Order> orders = dao.adminstorerooms();
		MybatisUtil.close();
		return orders;
	}
	//�����е��̼ҳ�����������ͳ��
	@Override
	public List<Order> adminstatistics() {
		// TODO Auto-generated method stub
		OrderDao dao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		List<Order> orders = dao.adminstatistics();
		MybatisUtil.close();
		return orders;
	}
	//��ѯ�����ܽ��
		@Override
		public List<Order> tagprice() {
			// TODO Auto-generated method stub
			OrderDao dao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
			List<Order> orders = dao.tagprice();
			MybatisUtil.close();
			return orders;
		}
		//ɾ������
		@Override
		public void deleteOrder(String id) {
			// TODO Auto-generated method stub
			
			try {
				OrderDao dao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
				dao.deleteOrder(id);
				MybatisUtil.commit();
			} catch (Exception e) {
				e.printStackTrace();
				MybatisUtil.rollback();
			}
		}
}
