package com.zhaowei.genshin.pojo;

public class Item {
	private Integer id;
	private String itemName;
	private Integer type;
	private Integer grade;
	private String img;
	private Integer required;
	private Integer hold = 0;
	
	public Item() {}

	public Item(Integer id, String itemName, Integer type, Integer grade, String img, Integer required, Integer hold) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.type = type;
		this.grade = grade;
		this.img = img;
		this.required = required;
		this.hold = hold;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getRequired() {
		return required;
	}

	public void setRequired(Integer required) {
		this.required = required;
	}

	public Integer getHold() {
		return hold;
	}

	public void setHold(Integer hold) {
		this.hold = hold;
	}
	
}
