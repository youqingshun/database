package vo;

import base.Vobase;

public class Order extends Vobase {
	private int uid;
	private String username;
	private int itid;
	private double price;
	private String address;
	private String state;
	private String postno;
	private String tel;
	private String paytype;
	private String infos;
	private String urls;
	private String province;
	private String city;
	
	
	public Order() {}
	public Order(int id,int uid, String username, int itid, double price, String address, String state, String postno,
			String tel, String paytype, String infos, String urls, String province, String city) {
		super();
		this.id=id;
		this.uid = uid;
		this.username = username;
		this.itid = itid;
		this.price = price;
		this.address = address;
		this.state = state;
		this.postno = postno;
		this.tel = tel;
		this.paytype = paytype;
		this.infos = infos;
		this.urls = urls;
		this.province = province;
		this.city = city;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostno() {
		return postno;
	}
	public void setPostno(String postno) {
		this.postno = postno;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
	}
	public String getUrls() {
		return urls;
	}
	public void setUrls(String urls) {
		this.urls = urls;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
