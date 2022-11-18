package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class Course {
    private Teacher teacher;
    private Long courseId;

    private String name;

    private String description;

    private List<Student> students;


    public Course(String name, String description, Teacher teacher) {
        this.courseId = new Random().nextLong();
        this.name = name;
        this.description = description;
        this.students = students;
        this.teacher = teacher;
    }
}