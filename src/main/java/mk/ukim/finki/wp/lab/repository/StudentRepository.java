package mk.ukim.finki.wp.lab.repository;

import lombok.Data;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    public List<Student> listaS = new ArrayList<Student>(5);

    {
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
    }

    public List<Student> findAllStudents() {
        return listaS;
    }

    public List<Student> findAllByNameOrSurname(String text) {
        for (int i = 0; i < 5; i++) {
            if (listaS.get(i).getName().equals(text) || listaS.get(i).getSurname().equals(text)) {
                listaS.remove(i);
            }
        }
        return listaS;
    }

    public List<Student> save(Student student) {
        listaS.add(student);
        return listaS;
    }
}
