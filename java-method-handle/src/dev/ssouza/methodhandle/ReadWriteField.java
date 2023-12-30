package dev.ssouza.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

public class ReadWriteField {
	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
		Lookup lookup = MethodHandles.lookup();
		
		MethodHandle nameReader = lookup.findGetter(Person.class, "name", String.class);
		MethodHandle nameWriter = lookup.findSetter(Person.class, "name", String.class);
	}
}
