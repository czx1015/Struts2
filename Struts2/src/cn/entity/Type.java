package cn.entity;

import java.io.Serializable;

public class Type implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String typename;
	private String name;
	private String introduction;
	private String imageFileName;
	private String date;
	private int number;
	private int price;
	private int us_id;
	private User user;
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Type(int id, String typename, String name, String introduction, String imageFileName, String date,
			int number, int price, int us_id, User user) {
		super();
		this.id = id;
		this.typename = typename;
		this.name = name;
		this.introduction = introduction;
		this.imageFileName = imageFileName;
		this.date = date;
		this.number = number;
		this.price = price;
		this.us_id = us_id;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", typename=" + typename + ", name=" + name + ", introduction=" + introduction
				+ ", imageFileName=" + imageFileName + ", date=" + date + ", number=" + number + ", price=" + price
				+ ", us_id=" + us_id + ", user=" + user + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	}
