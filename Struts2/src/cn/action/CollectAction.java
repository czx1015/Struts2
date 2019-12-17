package cn.action;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.entity.Collect;
import cn.service.CollectService;
import cn.service.CollectServiceImpl;
public class CollectAction extends ActionSupport{

	/**11.1
	 *陈贞校
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collect collect;
	private List<Collect> collects;
	private int id;
	//添加收藏
	public String addCollect(){
		CollectService cs = new CollectServiceImpl();
		boolean is = cs.exist(collect.getUs_id(), collect.getTy_id());
		//查询收藏是否存在
		if(!is) {
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		collect.setDate(df.format(day));
		cs.addCollect(collect);	
		}
		JOptionPane.showMessageDialog(null, "收藏成功！", "提示信息", 1);
		return SUCCESS;
	} 
	//查询所有用户的收藏
	public String selectCollect(){
		CollectService cs = new CollectServiceImpl();
		collects = cs.selectCollect();
		ActionContext.getContext().getValueStack().setValue("#session.collects", collects);
		return SUCCESS;
	}
	//根据用户id和商品id去删除相应的收藏
	public String deleteCollect(){
		int res=JOptionPane
				.showConfirmDialog(null, "取消收藏？", "是否继续", JOptionPane.YES_NO_OPTION);
			if(res==JOptionPane.YES_OPTION){  //点击“是”后执行这个代码块
				CollectService cs = new CollectServiceImpl();
				cs.deleteCollect(collect.getUs_id(),collect.getTy_id());    
			}
		return SUCCESS;
	}
	//根据自己的id查询自己的收藏
	public String selectMyCollect(){
		CollectService cs = new CollectServiceImpl();
		collects = cs.selectMyCollect(id);
		ActionContext.getContext().getValueStack().setValue("#session.collects", collects);
		return SUCCESS;
	}
	public Collect getCollect() {
		return collect;
	}
	public void setCollect(Collect collect) {
		this.collect = collect;
	}
	public List<Collect> getCollects() {
		return collects;
	}
	public void setCollects(List<Collect> collects) {
		this.collects = collects;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}