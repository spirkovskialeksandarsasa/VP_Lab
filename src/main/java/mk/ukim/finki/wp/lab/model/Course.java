package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import mk.ukim.finki.wp.lab.model.enumerations.Type;
import org.hibernate.annotations.Fetch;
import org.springframework.data.repository.cdi.Eager;


@Data
@Entity
public class Course implements Comparable<Course>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Student> students;

    @ManyToOne
    private Teacher teacher;

    @Enumerated(EnumType.STRING)
    public Type type;


    public Course(String name, String description, Teacher teacher, Type type) {
        this.name = name;
        this.description = description;
        this.students = new ArrayList<>();
        this.teacher = teacher;
        this.type = type;
    }
    public Course() {
    }

    @Override
    public int compareTo(Course o) {
        return name.compareTo(o.name);
    }

}