package com.zhaowei.genshin.pojo;

import java.util.List;

public class Employee {
	private Integer id;
	private String name;
	private String gender;
	private String attribute;
	private String country;
	private String profile;
	private Integer status = -1;
	private Integer level;
	private List<Item> itemList;
	
	public Employee() {}

	public Employee(Integer id, String name, String gender, String attribute, String country, String profile,
			Integer status, Integer level) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.attribute = attribute;
		this.country = country;
		this.profile = profile;
		this.status = status;
		this.level = level;
	}

	public Integer getId() {
		return id;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

}
