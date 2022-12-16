package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import mk.ukim.finki.wp.lab.model.enumerations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Entity
public class Course implements Comparable<Course>{

    @Id
    private Long courseId;
    private String name;

    private String description;

    @ManyToMany
    private List<Student> students;

    @ManyToOne
    private Teacher teacher;

    @Enumerated(EnumType.STRING)
    private Type type;

    public Course() {
    }


    @Override
    public int compareTo(Course o) {
        return name.compareTo(o.name);
    }
}