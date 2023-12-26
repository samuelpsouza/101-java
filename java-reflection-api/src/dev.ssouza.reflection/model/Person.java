package dev.ssouza.reflection.model;

public class Person {
    private String name;
    private Integer age;

    public Person() {
    }

    private Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static Person of(String name, Integer age) {
        return new Person(name, age);
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
