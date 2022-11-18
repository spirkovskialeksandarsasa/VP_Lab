package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;
import mk.ukim.finki.wp.lab.model.Teacher;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    public List<Teacher> listaT = new ArrayList<Teacher>(5);

    {
        Teacher teacher1 = new Teacher(123L,"David", "Stojanovski");
        listaT.add(teacher1);

        Teacher teacher2 = new Teacher(123L,"test", "testovski");
        listaT.add(teacher2);

        Teacher teacher3 = new Teacher(123L,"Ana", "Todorovska");
        listaT.add(teacher3);

        Teacher teacher4 = new Teacher(123L,"Riste", "Stojanov");
        listaT.add(teacher4);

        Teacher teacher5 = new Teacher(123L,"Kostadin", "Misev");
        listaT.add(teacher5);
    }
    public List<Course> listaK = new ArrayList<Course>(5);
    {
        Course course1 = new Course("Verojatnost i Statistika", "Matematika 2 god", listaT.get(0));
        listaK.add(course1);

        Course course2 = new Course("Veb Programiranje", "predmet", listaT.get(1));
        listaK.add(course2);

        Course course3 = new Course("Kompjuterska etika", "etika!", listaT.get(2));
        listaK.add(course3);

        Course course4 = new Course("Algoritmi", "algoritmi strukturi itn", listaT.get(3));
        listaK.add(course4);

        Course course5 = new Course("Diskretna matematika", "Matematika 1 god", listaT.get(4));
        listaK.add(course5);
    }
    public List<Course> findAllCourses(){
        return listaK;
    }
    public Course findById(Long courseId){
        for(int i=0;i<5;i++){
            if(listaK.get(i).getCourseId().equals(courseId)){
                return listaK.get(i);
            }
        }
        return listaK.get(0);
    }
    public List<Student> findAllStudentsByCourse(Long courseId){
        for(int i=0;i<5;i++){
            if(listaK.get(i).getCourseId().equals(courseId)){
                return listaK.get(i).getStudents();
            }
        }
        return listaK.get(0).getStudents();
        // кој ќе врати листа од студенти кои слушаат одреден курс.
    }
    public Course addStudentToCourse(Student student, Course course){
        //кој ќе направи додавање на нов студент во листата од студенти.
         course.getStudents().add(student);
         return course;
    }

    public Course addCourse(Course course) {
        listaK.add(course);
        return course;
    }

    public void deleteCourse(Long id) {
        Course course = findById(id);
        listaK.remove(course);
    }
}