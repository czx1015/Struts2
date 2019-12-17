package cn.service;

import java.util.List;

import cn.entity.Collect;

public interface CollectService {
	//添加收藏
	void addCollect(Collect collect);
	//查询所有用户的收藏
	List<Collect> selectCollect();
	//查询该用户是否已收藏该商品
	boolean exist(int us_id,int ty_id);
	//根据用户id和商品id删除相应的收藏
	void deleteCollect(int us_id,int ty_id);
	//根据用户id查询自己的收藏
	List<Collect> selectMyCollect(int us_id);
}
