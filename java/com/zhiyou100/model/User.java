package com.zhiyou100.model;

import java.sql.Timestamp;

public class User {
	
	private Integer id;
	
	private String phone;
	
	private Timestamp current;

	public User() {
		super();
	}

	public User(Integer id, String phone, Timestamp current) {
		super();
		this.id = id;
		this.phone = phone;
		this.current = current;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", phone=" + phone + ", current=" + current + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getCurrent() {
		return current;
	}

	public void setCurrent(Timestamp current) {
		this.current = current;
	}
}
