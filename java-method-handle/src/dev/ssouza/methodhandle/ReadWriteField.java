package dev.ssouza.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

public class ReadWriteField {
	public static void main(String[] args) throws Throwable {
		Person ssouza = new Person("Samuel");
		Lookup lookup = MethodHandles.lookup();
/*  
 * It throws a java.lang.IllegalAccessException because the field is private.
 * 
 		MethodHandle nameReader = lookup.findGetter(Person.class, "name", String.class);
		MethodHandle nameWriter = lookup.findSetter(Person.class, "name", String.class);

		String name = (String) nameReader.invoke(ssouza);
		System.out.println("My name is " + name);
		
		nameWriter.invoke(ssouza, "Samuel Souza");
		name = (String) nameReader.invoke(ssouza);
		System.out.println("My name is " + name);
*/

		Lookup privateLookup = MethodHandles.privateLookupIn(Person.class, lookup);
		MethodHandle privateNameReader = privateLookup.findGetter(Person.class, "name", String.class);
		MethodHandle privateNameWriter = privateLookup.findSetter(Person.class, "name", String.class);
		
		
		String name = (String) privateNameReader.invoke(ssouza);
		System.out.println("My name is " + name);
		
		privateNameWriter.invoke(ssouza, "Samuel Souza");
		name = (String) privateNameReader.invoke(ssouza);
		System.out.println("My name is " + name);
	}
}
