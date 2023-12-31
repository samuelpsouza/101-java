package dev.ssouza.metamodels.model;

import dev.ssouza.metamodels.annotation.*;

public class Person {
    @PrimaryKey(name = "k_id")
    private long id;
    @Column(name = "c_age")
    private int age;
    @Column(name = "c_name")
    private String name;

    public Person() {

    }

    public Person(String name, int age) {
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", age=" + age + ", name=" + name + "]";
    }
    
}
