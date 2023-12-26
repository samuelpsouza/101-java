package dev.ssouza.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PlayWithReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        String personClassName = "dev.ssouza.reflection.model.Person";

        Class<?> personClass = Class.forName(personClassName);

        System.out.println("Person class = " + personClass);

        Field[] fields = personClass.getFields();

        System.out.println("Fields: ");
        System.out.println(Arrays.toString(fields));

        Field[] declaredFields = personClass.getDeclaredFields();


        System.out.println("Declared Fields: ");
        for (Field field : declaredFields) {
            System.out.println(field);            
        }

        Method[] methods = personClass.getMethods();

        System.out.println("Methods: ");
        for (Method method : methods) {
            System.out.println(method);
        }


        Method[] declaredMethods = personClass.getDeclaredMethods();

        System.out.println("Declared methods:");
        for (Method method : declaredMethods) {
            System.out.println(method);
        }

        System.out.println("Static methods");

        Arrays.stream(declaredMethods)
            .filter(m -> Modifier.isStatic(m.getModifiers()))
            .forEach(System.out::println);

    }
}
