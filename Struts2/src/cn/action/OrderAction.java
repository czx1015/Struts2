package cn.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.swing.JOptionPane;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.entity.Order;
import cn.entity.Type;
import cn.service.OrderService;
import cn.service.OrderServiceImpl;
import cn.service.TypeService;
import cn.service.TypeServiceImpl;

public class OrderAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Order order;
	private Type type;
	private int id;
	private int role;
	private List<Type> types;
	private List<Order> orders;
	//查询所有的订单信息
	public String selectOrders(){
		OrderService os = new OrderServiceImpl();
		orders = os.selectOrders();
		ActionContext.getContext().getValueStack().setValue("#session.orders", orders);
		return SUCCESS;
	}

	/*
	 * //根据id public String selectMerchantsOrders(){ OrderService os = new
	 * OrderServiceImpl(); orders = os.selectMerchantsOrders(id);
	 * ActionContext.getContext().getValueStack().setValue("#session.orders",
	 * orders); System.out.print(orders); return SUCCESS; }
	 */
	//根据用户id查询订单
	public String selectTypeOrders(){
		OrderService os = new OrderServiceImpl();
		orders = os.selectTypeOrders(id);
		ActionContext.getContext().getValueStack().setValue("#session.orders", orders);
		return SUCCESS;
	}
	//根据商家id查询该商家店铺出入库情况
	public String storerooms(){
		OrderService os = new OrderServiceImpl();
		orders = os.storerooms(id);
		ActionContext.getContext().getValueStack().setValue("#session.orders", orders);
		return SUCCESS;
	}
	//根据商家id对该商家出入库情况进行统计
	public String statistics(){
		OrderService os = new OrderServiceImpl();
		orders = os.tagprice();
		ActionContext.getContext().getValueStack().setValue("#session.orders1", orders);
		orders = os.statistics(id);
		ActionContext.getContext().getValueStack().setValue("#session.orders", orders);
		return SUCCESS;
	}
	//查询所有的商家的出入库情况
	public String adminstorerooms(){
		OrderService os = new OrderServiceImpl();
		orders = os.adminstorerooms();
		ActionContext.getContext().getValueStack().setValue("#session.orders", orders);
		return SUCCESS;
	}
	//对所有的商家出入库情况进行统计
	public String adminstatistics(){
		OrderService os = new OrderServiceImpl();
		orders = os.tagprice();
		ActionContext.getContext().getValueStack().setValue("#session.orders1", orders);
		orders = os.adminstatistics();
		ActionContext.getContext().getValueStack().setValue("#session.orders", orders);
		return SUCCESS;
	}
	//查询所需要购买的该商品的详细信息
	public String buyData() {
		TypeService ts = new TypeServiceImpl();
		type = ts.selectType(type.getId());
		ActionContext.getContext().getValueStack().setValue("#session.type", type);
		return SUCCESS;
	}
	public String order() {
		order.setTotalPrice(order.getNumber()*order.getTy_price());
		ActionContext.getContext().getValueStack().setValue("#session.order", order);
		return SUCCESS;
	}
	//提交订单，并根据标签判断是出库还是入库
	public String submitOrder() {
		order.setId(UUID.randomUUID().toString());
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		order.setDate(df.format(day));
		OrderService os = new OrderServiceImpl();
		TypeService ts = new TypeServiceImpl();
		if (order.getTag() != 0) {
			os.submitOrder(order);
			ts.addnumber(order);
			JOptionPane.showMessageDialog(null, "进货成功，祝你生活愉快", "提示信息",1);
		}else {
			type = ts.selectType(order.getTy_id());
			if(order.getNumber() <= type.getNumber()) {
			os.submitOrder(order);
			ts.diminishednumber(order);
			JOptionPane.showMessageDialog(null, "出货成功，祝你生活愉快", "提示信息",2);
			}else {
				JOptionPane.showMessageDialog(null, "提交失败，库存不足！", "错误信息",3);
			}
		}
		return SUCCESS;
	}
	//删除订单
	public String deleteOrdert(){
		int res=JOptionPane.showConfirmDialog(null, "取消订单？", "是否继续", JOptionPane.YES_NO_OPTION);
		OrderService os = new OrderServiceImpl();
		TypeService ts = new TypeServiceImpl();
			if(res==JOptionPane.YES_OPTION){  //点击“是”后执行这个代码块
				if (order.getTag() != 0) {
					type = ts.selectType(order.getTy_id());
					if(order.getNumber() <= type.getNumber()) {
					os.deleteOrder(order.getId());
					ts.diminishednumber(order);   
					JOptionPane.showMessageDialog(null, "取消成功，祝你生活愉快", "提示信息",1);
					}else {
						JOptionPane.showMessageDialog(null, "取消进货订单失败！", "错误信息",3);
					}
				}else {
					type = ts.selectType(order.getTy_id());
						os.deleteOrder(order.getId());
						ts.addnumber(order);   
					JOptionPane.showMessageDialog(null, "取消成功，祝你生活愉快", "提示信息",2);
					}
			}
		return SUCCESS;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Type> getTypes() {
		return types;
	}
	public void setTypes(List<Type> types) {
		this.types = types;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
}