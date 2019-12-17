package cn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.entity.Collect;

public interface CollectDao {
	//添加收藏
	void addCollect(Collect collect);
	//查询所有的收藏
	List<Collect> selectCollect();
	//查询该用户是否已收藏该商品
	Collect exist(@Param("us_id")int us_id,@Param("ty_id")int ty_id);
	//根据用户ID和商品id删除相应的收藏
	void deleteCollect(@Param("us_id")int us_id,@Param("ty_id")int ty_id);
	//根据id查询自己的收藏
	List<Collect> selectMyCollect(int us_id);
}
