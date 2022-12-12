package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherRepository {

    public List<Teacher> findAll() {
        return DataHolder.listaT;
    }

    public Teacher findById(Long id) {
        return DataHolder.listaT
                .stream()
                .filter(t->t.getId().equals(id))
                .findFirst()
                .orElse(null);

    }
}
