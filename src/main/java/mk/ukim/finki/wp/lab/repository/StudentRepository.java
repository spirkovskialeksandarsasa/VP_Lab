package mk.ukim.finki.wp.lab.repository;

import lombok.Data;
import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {


    public List<Student> findAllStudents() {
        return DataHolder.listaS;
    }

    public List<Student> findAllByNameOrSurname(String text) {
        return DataHolder.listaS
                .stream()
                .filter(s->s.getName().equals(text) || s.getSurname().equals(text))
                .toList();
    }

    public List<Student> save(Student student) {
        DataHolder.listaS.add(student);
        return DataHolder.listaS;
    }

    public Student findByUsername(String username){
        return DataHolder.listaS
                .stream()
                .filter(s->s.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}
