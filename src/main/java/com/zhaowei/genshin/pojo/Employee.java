package com.zhaowei.genshin.pojo;

public class Employee {
	private Integer eid;
	private String empName;
	private Integer age;
	private String gender;
	private String email;
	
	public Employee() {}

	public Employee(Integer eid, String empName, Integer age, String gender, String email) {
		super();
		this.eid = eid;
		this.empName = empName;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", empName=" + empName + ", age=" + age + ", gender=" + gender + ", email="
				+ email + "]";
	}
	
}
