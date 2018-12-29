package vo;

import base.Vobase;

public class Wish extends Vobase {
	private int uid;
	private String name;
	private double price;
	private String urls;
	private int itid;
	
	
	
	public Wish(int id,int uid, String name, double price, String urls, int itid) {
		super();
		this.id=id;
		this.uid = uid;
		this.name = name;
		this.price = price;
		this.urls = urls;
		this.itid = itid;
	}
	public Wish() {
		// TODO Auto-generated constructor stub
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUrls() {
		return urls;
	}
	public void setUrls(String urls) {
		this.urls = urls;
	}
	public int getItid() {
		return itid;
	}
	public void setItid(int itid) {
		this.itid = itid;
	}
	
	
}
