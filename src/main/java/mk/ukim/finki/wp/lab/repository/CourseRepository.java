package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;
import mk.ukim.finki.wp.lab.model.Teacher;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {


    public List<Course> findAllCourses(){
        return DataHolder.listaK;
    }
    public Course findById(Long courseId){
        return DataHolder.listaK
                .stream()
                .filter(c->c.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);
    }
    public List<Student> findAllStudentsByCourse(Long courseId){
        Course course = DataHolder.listaK
                .stream()
                .filter(k->k.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);

        if (course == null) {
            return null;
        }

        return course.getStudents();
        // кој ќе врати листа од студенти кои слушаат одреден курс.
    }
    public Course addStudentToCourse(Student student, Course course){
        //кој ќе направи додавање на нов студент во листата од студенти.
         course.getStudents().add(student);
         return course;
    }

    public Course addCourse(Course course) {
        DataHolder.listaK.add(course);
        return course;
    }

    public boolean deleteCourse(Long id) {
        Course course = DataHolder.listaK.stream().filter(c -> c.getCourseId().equals(id)).findFirst().orElse(null);

        if (course == null) {
            return false;
        }

        DataHolder.listaK.remove(course);
        return true;
    }
}