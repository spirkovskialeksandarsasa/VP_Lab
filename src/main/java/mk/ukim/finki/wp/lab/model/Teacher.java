package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Random;

@Data
@Entity
public class Teacher {
    @Id
    private Long id;

    private String name;

    private String surname;

    private LocalDate dateOfEmployment;


    public Teacher() {
    }

}
