package cn.dao;

import java.util.List;

import cn.entity.Order;
import cn.entity.Type;
public interface TypeDao {
		//查询所有商品
		List<Type> selectTypes();
		//根据商家id查询自己所有的商品
		List<Type> selectMerchantsTypes(int us_id);
		//根据id删除商品
		void deleteType(int id);
		//根据id查询商品信息
		Type selectType(int id);
		//根据id查询商品信息和店铺信息
		Type selectUserType(int id);
		//修改商品信息
		void updateType(Type type);
		//入库，添加相应的商品数量
		void addnumber(Order order);
		//出库，减少相应的商品数量
		void diminishednumber(Order order);
		//添加商品
		void addType(Type type);
		//根据输入的字符串进行模糊查询
		List<Type> search(Type type);
}
