package com.test;

public class Test1 {
	public String name;
	public String age;
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
	public static void main(String[] args) throws Exception {
		String s = "b9fce523af834989a97acdd2c991787c-->3debf1be7b9940ceb62d149561afd267,107e80b2c938466ea3cb16e20ec47e86";
		
		System.out.println(s.indexOf("-->"));
	}
}
