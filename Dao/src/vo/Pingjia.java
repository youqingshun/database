package vo;

import base.Vobase;

public class Pingjia extends Vobase {
//	private int id;
	private String name;
	private String infos;
	private String addtime;
	private int uid;
	private int itid;
	private String type;
	private int grade;
	
	public Pingjia() {}
	public Pingjia(int id,String name,String infos,String addtime,int uid,int itid,String type,int grade) {
		this.id=id;
		this.name=name;
		this.infos=infos;
		this.addtime=addtime;
		this.uid=uid;
		this.itid=itid;
		this.type=type;
		this.grade=grade;
	
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getItid() {
		return itid;
	}
	public void setItid(int itid) {
		this.itid = itid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
