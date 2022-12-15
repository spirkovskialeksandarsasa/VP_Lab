package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Student {
    @Id
    private String username;

    private String password;

    private String name;

    private String surname;

    public Student() {
    }


}
