package dev.ssouza.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

public class GetMethodReference {
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException {
		Lookup lookup = MethodHandles.lookup();
		
		// public String getName() { ... }
		
		MethodType getterType = MethodType.methodType(String.class);
		
		// public void setName(String name) { ... }
		
		MethodType setterType = MethodType.methodType(void.class, String.class);
		
		// public Person(String name) { ... }
		
		MethodType constructorType = MethodType.methodType(void.class, String.class);
		
		// public Person() { ... }
		
		MethodType emptyConstructorType = MethodType.methodType(void.class);
		
		// Getting MethodHandle
		
		MethodHandle getterHandle = lookup.findVirtual(Person.class, "getName", getterType);
		
		MethodHandle constructorHandle = lookup.findConstructor(Person.class, constructorType);
		
		
	}
}
