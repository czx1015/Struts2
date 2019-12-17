package cn.entity;

import java.io.Serializable;

public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int phone;
	private String address;
	private int number;
	private int ty_price;
	private int totalPrice;
	private String date;
	private int tag;
	private int sum;
	private int ty_id;
	private int us_id;
	private int me_id;
	private Type type;
	private User user;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String id, String name, int phone, String address, int number, int ty_price, int totalPrice,
			String date, int tag, int sum, int ty_id, int us_id, int me_id, Type type, User user) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.number = number;
		this.ty_price = ty_price;
		this.totalPrice = totalPrice;
		this.date = date;
		this.tag = tag;
		this.sum = sum;
		this.ty_id = ty_id;
		this.us_id = us_id;
		this.me_id = me_id;
		this.type = type;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", number=" + number
				+ ", ty_price=" + ty_price + ", totalPrice=" + totalPrice + ", date=" + date + ", tag=" + tag + ", sum="
				+ sum + ", ty_id=" + ty_id + ", us_id=" + us_id + ", me_id=" + me_id + ", type=" + type + ", user="
				+ user + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTy_id() {
		return ty_id;
	}
	public void setTy_id(int ty_id) {
		this.ty_id = ty_id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getUs_id() {
		return us_id;
	}

	public void setUs_id(int us_id) {
		this.us_id = us_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public int getMe_id() {
		return me_id;
	}
	public void setMe_id(int me_id) {
		this.me_id = me_id;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getTy_price() {
		return ty_price;
	}
	public void setTy_price(int ty_price) {
		this.ty_price = ty_price;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
