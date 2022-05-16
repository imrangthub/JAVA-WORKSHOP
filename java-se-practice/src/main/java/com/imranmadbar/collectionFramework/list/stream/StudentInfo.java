package com.imranmadbar.collectionFramework.list.stream;

public class StudentInfo {

	
	private String id;
	private String name;
	private String gender;
	private String age;
	
	
	
	
	public StudentInfo() {}

	
	public StudentInfo(String info, String id, String name, String gender, String age) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}




	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	
	
	
	
	

}
