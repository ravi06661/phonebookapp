package com.dollop.entity;

public class Contact {

	private Integer id;
	private String name;
	private String email;
	private String phone;
	public Contact() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public Contact(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public Contact(Integer id, String name, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
}
