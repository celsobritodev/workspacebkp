package main;

import java.util.Objects;

public class PersonClass {
	
	private final String name;
	private final int age;
	
	
	
	public PersonClass(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public int getAge() {
		return age;
	}


	
	
	@Override
	public String toString() {
		return "PersonClass [name=" + name + ", age=" + age + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonClass other = (PersonClass) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	
	

}
