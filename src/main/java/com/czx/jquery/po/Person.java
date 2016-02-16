package com.czx.jquery.po;

import org.springframework.web.multipart.MultipartFile;

public class Person {

	private String name;
	private String age;
	private MultipartFile headFile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public MultipartFile getHeadFile() {
		return headFile;
	}
	public void setHeadFile(MultipartFile headFile) {
		this.headFile = headFile;
	}
	
	
}
