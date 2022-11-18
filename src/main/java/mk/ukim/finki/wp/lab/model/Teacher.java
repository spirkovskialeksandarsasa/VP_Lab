package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.Random;

@Data
public class Teacher {
    private Long id;
    private String name;
    private String surname;

    public Teacher(Long id,String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
