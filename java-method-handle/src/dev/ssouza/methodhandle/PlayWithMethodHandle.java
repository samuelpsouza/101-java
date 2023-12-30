package dev.ssouza.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

public class PlayWithMethodHandle {

	public static void main(String[] args) throws Throwable {
		final Lookup lookup = MethodHandles.lookup();
		final MethodType emptyConstructorMethodType = MethodType.methodType(void.class);
		final MethodHandle emptyConstructorMethodHandle =  lookup.findConstructor(Person.class, emptyConstructorMethodType);
		
		Person person = (Person) emptyConstructorMethodHandle.invoke();
		System.out.println(person.toString());
		
		final MethodType constructorMethodType = MethodType.methodType(void.class, String.class);
		final MethodHandle constructorMethodHandle = lookup.findConstructor(Person.class, constructorMethodType);
		
		Person ssouza = (Person) constructorMethodHandle.invoke("Samuel Souza");
		System.out.println(ssouza.toString());
	}

}
