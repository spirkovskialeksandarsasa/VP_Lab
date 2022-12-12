package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Student> listaS;
    public static List<Course> listaK;
    public static List<Teacher> listaT;

@PostConstruct
    public void init(){
      listaS = new ArrayList<Student>(10);
      listaT = new ArrayList<Teacher>(10);
      listaK = new ArrayList<Course>(10);
    Student student1 = new Student("studenteden", "lozinka1", "Aleksandar Sasa", "Spirkovski");
    Student student2 = new Student("studentdva", "lozinka2", "Boban", "Grncarov");
    Student student3 = new Student("studenttri", "lozinka3", "Lionel", "Pessi");
    Student student4 = new Student("studentcetiri", "lozinka4", "Test", "Testovski");
    Student student5 = new Student("studentpet", "lozinka5", "Kristijan", "Stojkovski");
    listaS.add(student1);
    listaS.add(student2);
    listaS.add(student3);
    listaS.add(student4);
    listaS.add(student5);

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
}
