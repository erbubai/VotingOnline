package cn.edu.fzu.sm.vot.entity;

public class role {
	private int id;
	private String role;
	private String rit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRit() {
		return rit;
	}
	public void setRit(String rit) {
		this.rit = rit;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	private String des;
}
