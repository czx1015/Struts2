package cn.service;

import java.util.List;
import cn.dao.OrderDao;
import cn.entity.Order;
import cn.util.MybatisUtil;

public class OrderServiceImpl implements OrderService {
	//提交订单，并根据标签判断是出库还是入库
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
	//查询所有的订单信息
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
	//根据用户id查询订单
	@Override
	public List<Order> selectTypeOrders(int us_id) {
		// TODO Auto-generated method stub
		OrderDao dao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		List<Order> orders = dao.selectTypeOrders(us_id);
		MybatisUtil.close();
		return orders;
	}
	//根据商家id查询该商家店铺出入库情况
	@Override
	public List<Order> storerooms(int us_id) {
		// TODO Auto-generated method stub
		OrderDao dao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		List<Order> orders = dao.storerooms(us_id);
		MybatisUtil.close();
		return orders;
	}
	//根据商家id对该商家出入库情况进行统计
	@Override
	public List<Order> statistics(int us_id) {
		// TODO Auto-generated method stub
		OrderDao dao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		List<Order> orders = dao.statistics(us_id);
		MybatisUtil.close();
		return orders;
	}
	//查询所有的商家的出入库情况
	@Override
	public List<Order> adminstorerooms() {
		// TODO Auto-generated method stub
		OrderDao dao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		List<Order> orders = dao.adminstorerooms();
		MybatisUtil.close();
		return orders;
	}
	//对所有的商家出入库情况进行统计
	@Override
	public List<Order> adminstatistics() {
		// TODO Auto-generated method stub
		OrderDao dao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		List<Order> orders = dao.adminstatistics();
		MybatisUtil.close();
		return orders;
	}
	//查询销售总金额
		@Override
		public List<Order> tagprice() {
			// TODO Auto-generated method stub
			OrderDao dao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
			List<Order> orders = dao.tagprice();
			MybatisUtil.close();
			return orders;
		}
		//删除订单
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
