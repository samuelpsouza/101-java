package dev.ssouza.methodhandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.VarHandle;

public class ConcurrentFieldAccess {

	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
		Person person = new Person("Samuel");
		Lookup lookup = MethodHandles.lookup();
		
		VarHandle nameVarHandle = MethodHandles.privateLookupIn(Person.class, lookup)
				.findVarHandle(Person.class, "name", String.class);
		
		String name = (String) nameVarHandle.get(person);
		String volName = (String) nameVarHandle.getVolatile(person);
		
		VarHandle ageVarHandle = MethodHandles.privateLookupIn(Person.class, lookup)
				.findVarHandle(Person.class, "age", int.class);
		
		System.out.println("My name is " + volName + " and I'm " + person.getAge() + " years old");
		int age = (int) ageVarHandle.getAndAdd(person, 1);
		System.out.println("My name is " + volName + " and I'm " + age + " years old");
		System.out.println("My name is " + volName + " and I'm " + person.getAge() + " years old");
	}

}
