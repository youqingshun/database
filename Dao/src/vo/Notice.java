package vo;

import base.Vobase;

public class Notice extends Vobase {
	private String title;
	private String infos;
	private String time;
	public Notice() {}
	public Notice(int id,String title, String infos, String time) {
		super();
		this.id=id;
		this.title = title;
		this.infos = infos;
		this.time = time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
