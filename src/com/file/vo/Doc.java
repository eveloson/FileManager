package com.file.vo;

import java.io.Serializable;

public class Doc implements Serializable {
	private static final long serialVersionUID = 4622175477130843004L;
	private int doc_id;
	private String doc_name_o;
	private String doc_name_n;
	private String doc_dtime;
	private String doc_ctime;
	private String doc_size;
	private int user_id;
	
	public Doc() {
		super();
		// TODO Auto-generated constructor stub
	}
	





	@Override
	public String toString() {
		return "Doc [doc_id=" + doc_id + ", doc_name_o=" + doc_name_o + ", doc_name_n=" + doc_name_n + ", doc_dtime="
				+ doc_dtime + ", doc_ctime=" + doc_ctime + ", doc_size=" + doc_size + ", user_id=" + user_id + "]";
	}


	public Doc(String doc_name_o, String doc_name_n, String doc_ctime, String doc_size, int user_id) {
		super();
		this.doc_name_o = doc_name_o;
		this.doc_name_n = doc_name_n;
		this.doc_ctime = doc_ctime;
		this.doc_size = doc_size;
		this.user_id = user_id;
	}


	public Doc(String doc_name_o, String doc_name_n, String doc_dtime, String doc_ctime, String doc_size,
			int user_id) {
		super();
		this.doc_name_o = doc_name_o;
		this.doc_name_n = doc_name_n;
		this.doc_dtime = doc_dtime;
		this.doc_ctime = doc_ctime;
		this.doc_size = doc_size;
		this.user_id = user_id;
	}


	public Doc(int doc_id, String doc_name_o, String doc_name_n, String doc_dtime, String doc_ctime, String doc_size,
			int user_id) {
		super();
		this.doc_id = doc_id;
		this.doc_name_o = doc_name_o;
		this.doc_name_n = doc_name_n;
		this.doc_dtime = doc_dtime;
		this.doc_ctime = doc_ctime;
		this.doc_size = doc_size;
		this.user_id = user_id;
	}


	public int getDoc_id() {
		return doc_id;
	}


	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}


	public String getDoc_name_o() {
		return doc_name_o;
	}


	public void setDoc_name_o(String doc_name_o) {
		this.doc_name_o = doc_name_o;
	}


	public String getDoc_name_n() {
		return doc_name_n;
	}


	public void setDoc_name_n(String doc_name_n) {
		this.doc_name_n = doc_name_n;
	}


	public String getDoc_dtime() {
		return doc_dtime;
	}


	public void setDoc_dtime(String doc_dtime) {
		this.doc_dtime = doc_dtime;
	}


	public String getDoc_ctime() {
		return doc_ctime;
	}


	public void setDoc_ctime(String doc_ctime) {
		this.doc_ctime = doc_ctime;
	}


	public String getDoc_size() {
		return doc_size;
	}


	public void setDoc_size(String doc_size) {
		this.doc_size = doc_size;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	
}
