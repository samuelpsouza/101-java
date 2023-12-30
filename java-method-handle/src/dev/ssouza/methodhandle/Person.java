package dev.ssouza.methodhandle;

public class Person {
	private String name;
	private int age = 31;
	
	public Person() {
		
	}
	
	public int getAge() {
		return age;
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
