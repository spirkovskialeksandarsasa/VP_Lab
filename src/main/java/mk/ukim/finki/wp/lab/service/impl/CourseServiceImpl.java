package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.enumerations.Type;
import mk.ukim.finki.wp.lab.repository.impl.CourseRepository;
import mk.ukim.finki.wp.lab.repository.jpa.JpaCourseRepository;
import mk.ukim.finki.wp.lab.repository.jpa.JpaStudentRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
   private final JpaCourseRepository courseRepository;
   private final StudentService studentService;
   private final TeacherService teacherService;

    public CourseServiceImpl(JpaCourseRepository courseRepository, StudentService studentService, TeacherService teacherService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            return Collections.emptyList();
        }
        return course.getStudents();
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Student student = studentService.listAll()
                .stream().filter(s->s.getUsername().equals(username))
                .findFirst()
                .orElse(null);

        if(student==null){return null;}

        else{
            Course course = courseRepository.findById(courseId).orElse(null);
            if(course==null){
                return null;
            }
            course.getStudents().add(student);
            courseRepository.save(course);
            return course;
        }
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    @Override
    public Course addCourse(String name, String description, Long teacher, String type) {
        Course course = new Course(name, description, teacherService.findById(teacher), Type.valueOf(type));
        if (getCourses()
                .stream()
                .filter(c -> c.getName().equals(course.getName()))
                .findFirst()
                .orElse(null) != null) {
            return null;
        }
        return courseRepository.save(course);
    }

    @Override
    public void editCourse(Long id, String name, String description, Long teacher, String type) {
        Course course = courseRepository.findById(id).orElse(null);
        course.setName(name);
        course.setDescription(description);
        course.setTeacher(teacherService.findById(teacher));
        course.setType(Type.valueOf(type));

        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
