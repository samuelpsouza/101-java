package dev.ssouza.javamodules.domain.entity;

public class Pokemon {
    private Integer id;
    private String name;

    public Pokemon(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
