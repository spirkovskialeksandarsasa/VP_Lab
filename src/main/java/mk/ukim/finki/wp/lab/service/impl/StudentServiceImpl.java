package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.impl.StudentRepository;
import mk.ukim.finki.wp.lab.repository.jpa.JpaStudentRepository;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private final JpaStudentRepository studentRepository;

    public StudentServiceImpl(JpaStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> listAll(){
        return studentRepository.findAll();
    }

    @Override
    public List<Student> searchByNameOrSurname(String text, String text1){
        return studentRepository.findAllByNameLikeOrSurnameLike(text, text1);
    }

    @Override
    public Student save(String username, String password, String name, String surname){
        Student student = new Student(username, password, name, surname);
        studentRepository.save(student);
        return null;
    }

    @Override
    public Student getByUsername(String username) {
        return studentRepository.findByUsername(username);
    }

}
