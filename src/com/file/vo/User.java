package com.file.vo;

/**
 * 
 * @ClassName: User
 * @Description: 用户实体类
 * @author wubin
 */
public class User {
	private int user_id;
	private String user_name;
	private String user_pwd;
	private String user_ctime;
	public User() {
	}
	public User(int user_id, String user_name, String user_pwd, String user_ctime) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_ctime = user_ctime;
	}
	public User(String user_name, String user_pwd, String user_ctime) {
		super();
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_ctime = user_ctime;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_ctime() {
		return user_ctime;
	}
	public void setUser_ctime(String user_ctime) {
		this.user_ctime = user_ctime;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_pwd=" + user_pwd + ", user_ctime="
				+ user_ctime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_ctime == null) ? 0 : user_ctime.hashCode());
		result = prime * result + user_id;
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_pwd == null) ? 0 : user_pwd.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (user_ctime == null) {
			if (other.user_ctime != null)
				return false;
		} else if (!user_ctime.equals(other.user_ctime))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (user_pwd == null) {
			if (other.user_pwd != null)
				return false;
		} else if (!user_pwd.equals(other.user_pwd))
			return false;
		return true;
	}
	
	
}
