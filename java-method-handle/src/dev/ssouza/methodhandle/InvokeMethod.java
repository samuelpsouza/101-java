package dev.ssouza.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

public class InvokeMethod {

	public static void main(String[] args) throws Throwable {
		Person ssouza = new Person("Samuel");
		
		
		Lookup lookup = MethodHandles.lookup();
		MethodType getterType = MethodType.methodType(String.class);
		MethodHandle nameGetter = lookup.findVirtual(Person.class, "getName", getterType);
		
		String name = (String) nameGetter.invoke(ssouza);
		System.out.println("My name is " + name);
		
		MethodType setterType = MethodType.methodType(void.class, String.class);
		MethodHandle nameSetter = lookup.findVirtual(Person.class, "setName", setterType);
		nameSetter.invoke(ssouza, "Samuel Souza");
		
		String newName = (String) nameGetter.invoke(ssouza);
		System.out.println("My new name is " + newName);
	}

}
