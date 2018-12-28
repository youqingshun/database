package vo;

import base.Vobase;

public class Blog extends Vobase {
//	private int id;
    private String title;        //ук╨е
    private String infos;
    private String  time;
    private int itid;
    private String type;
    private String zhaiyao;
    private String picurls;
    
    public Blog() {}
    
    public Blog(int id, String title, String infos, String time, int itid, String type, String zhaiyao,
			String picurls) {
		super();
		this.id = id;
		this.title = title;
		this.infos = infos;
		this.time = time;
		this.itid = itid;
		this.type = type;
		this.zhaiyao = zhaiyao;
		this.picurls = picurls;
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

	public String getZhaiyao() {
		return zhaiyao;
	}

	public void setZhaiyao(String zhaiyao) {
		this.zhaiyao = zhaiyao;
	}

	public String getPicurls() {
		return picurls;
	}

	public void setPicurls(String picurls) {
		this.picurls = picurls;
	}
	
    
	
}
