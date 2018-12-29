package vo;

import base.Vobase;

public class Items extends Vobase {
	private String name;
	private String urls;
	private String type;
	private double price;
	private String infos;
	private String brand;
	private String no;
	private int sells;
	private String category;
	
	public Items() {}
	
	
	public int getSells() {
		return sells;
	}


	public void setSells(int sells) {
		this.sells = sells;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Items(String name, String urls, String type, double price, String infos, String brand, String no, int sells,
			String category) {
		super();
		this.name = name;
		this.urls = urls;
		this.type = type;
		this.price = price;
		this.infos = infos;
		this.brand = brand;
		this.no = no;
		this.sells = sells;
		this.category = category;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrls() {
		return urls;
	}
	public void setUrls(String urls) {
		this.urls = urls;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	
	
	
}
