package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
public class Grade {

    @Id
    private Long id;

    private Character grade;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    private LocalDateTime timestamp;

    public Grade() {
    }
}
