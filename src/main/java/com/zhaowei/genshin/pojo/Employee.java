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
	private Integer currLevel = 0;
	private Integer tarLevel = 0;
	private Integer currSkill1Level = 1;
	private Integer tarSkill1Level = 1;
	private Integer currSkill2Level = 1;
	private Integer tarSkill2Level = 1;
	private Integer currSkill3Level = 1;
	private Integer tarSkill3Level = 1;
	
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

	public Integer getCurrLevel() {
		return currLevel;
	}

	public void setCurrLevel(Integer currLevel) {
		this.currLevel = currLevel;
	}

	public Integer getTarLevel() {
		return tarLevel;
	}

	public void setTarLevel(Integer tarLevel) {
		this.tarLevel = tarLevel;
	}

	public Integer getCurrSkill1Level() {
		return currSkill1Level;
	}

	public void setCurrSkill1Level(Integer currSkill1Level) {
		this.currSkill1Level = currSkill1Level;
	}

	public Integer getTarSkill1Level() {
		return tarSkill1Level;
	}

	public void setTarSkill1Level(Integer tarSkill1Level) {
		this.tarSkill1Level = tarSkill1Level;
	}

	public Integer getCurrSkill2Level() {
		return currSkill2Level;
	}

	public void setCurrSkill2Level(Integer currSkill2Level) {
		this.currSkill2Level = currSkill2Level;
	}

	public Integer getTarSkill2Level() {
		return tarSkill2Level;
	}

	public void setTarSkill2Level(Integer tarSkill2Level) {
		this.tarSkill2Level = tarSkill2Level;
	}

	public Integer getCurrSkill3Level() {
		return currSkill3Level;
	}

	public void setCurrSkill3Level(Integer currSkill3Level) {
		this.currSkill3Level = currSkill3Level;
	}

	public Integer getTarSkill3Level() {
		return tarSkill3Level;
	}

	public void setTarSkill3Level(Integer tarSkill3Level) {
		this.tarSkill3Level = tarSkill3Level;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", attribute=" + attribute
				+ ", country=" + country + ", profile=" + profile + ", status=" + status + ", currLevel=" + currLevel
				+ ", tarLevel=" + tarLevel + ", currSkill1Level=" + currSkill1Level + ", tarSkill1Level="
				+ tarSkill1Level + ", currSkill2Level=" + currSkill2Level + ", tarSkill2Level=" + tarSkill2Level
				+ ", currSkill3Level=" + currSkill3Level + ", tarSkill3Level=" + tarSkill3Level + ", itemList="
				+ itemList + "]";
	}
}
