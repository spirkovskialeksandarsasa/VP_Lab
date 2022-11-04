package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    List<Course> listaK = new ArrayList<Course>(5);
    {
        List<Student> studentiVIS = new ArrayList<Student>();
        Course course1 = new Course(123L,"Verojatnost i Statistika", "Matematika 2 god", studentiVIS);
        listaK.add(course1);

        List<Student> studentiVP = new ArrayList<>();
        Course course2 = new Course(234L,"Veb Programiranje", "predmet", studentiVP);
        listaK.add(course2);

        List<Student> studentiKE = new ArrayList<Student>();
        Course course3 = new Course(345L,"Kompjuterska etika", "etika!", studentiKE);
        listaK.add(course3);

        List<Student> studentiAPS = new ArrayList<Student>();
        Course course4 = new Course(456L,"Algoritmi", "algoritmi strukturi itn", studentiAPS);
        listaK.add(course4);

        List<Student> studentiDM = new ArrayList<Student>();
        Course course5 = new Course(567L,"Diskretna matematika", "Matematika 1 god", studentiDM);
        listaK.add(course5);
    }
    public List<Course> findAllCourses(){
        return listaK;
    }
    public Course findById(Long courseId){
        return (listaK.getCourseId())
    }
    public List<Student> findAllStudentsByCourse(Long courseId){
        // кој ќе врати листа од студенти кои слушаат одреден курс.
    }
    public Course addStudentToCourse(Student student, Course course){
        //кој ќе направи додавање на нов студент во листата од студенти.
    }
}
