package dev.ssouza.methodhandle;

import java.lang.invoke.MethodHandles;

public class GetClassReference {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
		Class<?> personClass = MethodHandles
				.lookup()
				.findClass(Person.class.getName());
		
		System.out.println(personClass.getCanonicalName());
	}

}
