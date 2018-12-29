package vo;

import base.Vobase;

public class Shopcar extends Vobase {
	private int uid;
	private int num;
	private String name;
	private int itid;
	private double price;
	private String state;
	private String urls;
	
	public Shopcar() {}
	
	public Shopcar(int uid, int num, String name, int itid, double price, String state, String urls) {
		super();
		this.uid = uid;
		this.num = num;
		this.name = name;
		this.itid = itid;
		this.price = price;
		this.state = state;
		this.urls = urls;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getItid() {
		return itid;
	}
	public void setItid(int itid) {
		this.itid = itid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUrls() {
		return urls;
	}
	public void setUrls(String urls) {
		this.urls = urls;
	}
	
	
}
