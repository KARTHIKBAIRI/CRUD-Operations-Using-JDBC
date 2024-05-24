package models;

public class student {

	private int s_id;
	private String s_name;
	private String s_email;
	private long s_ph;
	private String s_branch;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_email() {
		return s_email;
	}
	public student(int s_id, String s_name, String s_email, long s_ph, String s_branch) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_email = s_email;
		this.s_ph = s_ph;
		this.s_branch = s_branch;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	public long getS_ph() {
		return s_ph;
	}
	public void setS_ph(long s_ph) {
		this.s_ph = s_ph;
	}
	public String getS_branch() {
		return s_branch;
	}
	public void setS_branch(String s_branch) {
		this.s_branch = s_branch;
	}
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
