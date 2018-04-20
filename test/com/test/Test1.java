package com.test;

import java.util.ArrayList;
import java.util.List;

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
//		Test1 bean = new Test1();
//		bean.setName("xiaoming");
//		bean.setAge("11");
//		Field[] fields = bean.getClass().getDeclaredFields();
//		
//		for(Field field : fields){
//			System.out.println("name :" + field.getName() + ",val :" + field.get(bean));
//		}
		
		List<String> list = new ArrayList<>();
		
		list.add("1");
		list.add("5");
		list.add("4");
		list.add("2");
		
		for(String s : list){
			System.out.println(s);
		}
	}
}
