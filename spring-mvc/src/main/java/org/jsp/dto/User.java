package org.jsp.dto;

public class User 
{
	private int id;
	private String nm;
	private long ph;
	private String pswd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public long getPh() {
		return ph;
	}
	public void setPh(long ph) {
		this.ph = ph;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
}
