package com.hf.ioc.life;

public class Person {
	
	private Integer id;
	
	private String name;
	
	private String sex;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		System.out.println("Two: 依赖注入");
		this.id =  id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Four::Person [id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}

	public Person() {
		System.out.println("One: 初始化");
	}
	
	public void init(){
		System.out.println("Three:初始化");
	}
	
	public void destory() {
		System.out.println("Five:销毁了");
	}
	
}
