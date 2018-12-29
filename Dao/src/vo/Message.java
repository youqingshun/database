package vo;

import base.Vobase;

public class Message extends Vobase {
	private String infos;
	private String state;
	private String reply;
	private int uid;
	
	public Message() {}
	
	public Message(int id,String infos, String state, String reply, int uid) {
		super();
		this.id=id;
		this.infos = infos;
		this.state = state;
		this.reply = reply;
		this.uid = uid;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
}
