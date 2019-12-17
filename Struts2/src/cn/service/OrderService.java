package cn.service;

import java.util.List;

import cn.entity.Order;

public interface OrderService {
	//提交订单，并根据标签判断是出库还是入库
	void submitOrder(Order order);
	//查询所有的订单信息
	List<Order> selectOrders();
//	List<Order> selectMerchantsOrders(int us_id);
	//根据用户id查询订单
	List<Order> selectTypeOrders(int us_id);
	//根据商家id查询该商家店铺出入库情况
	List<Order> storerooms(int us_id);
	//根据商家id对该商家出入库情况进行统计
	List<Order> statistics(int us_id);
	//查询所有的商家的出入库情况
	List<Order> adminstorerooms();
	//对所有的商家出入库情况进行统计
	List<Order> adminstatistics();
	//查询销售总金额
	List<Order> tagprice();
	//删除订单
	void deleteOrder(String id);
}
