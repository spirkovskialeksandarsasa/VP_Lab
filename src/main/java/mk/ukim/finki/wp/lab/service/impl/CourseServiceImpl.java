package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
   private final CourseRepository courseRepository;
   private final StudentService studentService;
   private final TeacherService teacherService;

    public CourseServiceImpl(CourseRepository courseRepository, StudentService studentService, TeacherService teacherService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.findAllStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Student student = (Student) studentService.listAll();
        Course course = courseRepository.findById(courseId);
            if (student.getUsername().equals(username)) {
                courseRepository.addStudentToCourse(student, course);
            }
      return course;
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAllCourses();
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public Course addCourse(String name, String description, Long teacherID) {
        Course course = new Course(name, description, teacherService.findById(teacherID));
        return courseRepository.addCourse(course);
    }

    @Override
    public void editCourse(Long id, String name, String description, Long teacher) {
        Course course = courseRepository.findById(id);
        course.setName(name);
        course.setDescription(description);
        course.setTeacher(teacherService.findById(teacher));
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteCourse(id);
    }
}
