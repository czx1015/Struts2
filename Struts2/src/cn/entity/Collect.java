package cn.entity;

import java.io.Serializable;

public class Collect implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ty_id;
	private int me_id;
	private int us_id;
	private String imageFileName;
	private String introduction;
	private String ty_name;
	private int price;
	private String date;
	public Collect() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collect(int ty_id, int me_id, int us_id, String imageFileName, String introduction, String ty_name,
			int price, String date) {
		super();
		this.ty_id = ty_id;
		this.me_id = me_id;
		this.us_id = us_id;
		this.imageFileName = imageFileName;
		this.introduction = introduction;
		this.ty_name = ty_name;
		this.price = price;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Collect [ty_id=" + ty_id + ", me_id=" + me_id + ", us_id=" + us_id + ", imageFileName=" + imageFileName
				+ ", introduction=" + introduction + ", ty_name=" + ty_name + ", price=" + price + ", date=" + date
				+ "]";
	}

	public int getTy_id() {
		return ty_id;
	}
	public void setTy_id(int ty_id) {
		this.ty_id = ty_id;
	}
	public int getMe_id() {
		return me_id;
	}
	public void setMe_id(int me_id) {
		this.me_id = me_id;
	}
	public int getUs_id() {
		return us_id;
	}
	public void setUs_id(int us_id) {
		this.us_id = us_id;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getTy_name() {
		return ty_name;
	}
	public void setTy_name(String ty_name) {
		this.ty_name = ty_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
}
