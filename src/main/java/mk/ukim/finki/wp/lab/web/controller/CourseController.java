package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final TeacherService teacherService;
    private final CourseService courseService;

    public CourseController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }


    @GetMapping
    public String getCoursesPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("courses", courseService.getCourses().stream().toList());

        return "/listCourses";
    }

    @PostMapping("/courses/add")
    public String saveCourse(@RequestParam String name, @RequestParam String description, @RequestParam Long teacher, @RequestParam(required = false) Long course) {
        if (course == null) {
            courseService.addCourse(name, description, teacher);
        } else {
            courseService.editCourse(course, name, description, teacher);
        }
        return "redirect:/courses";
    }

@DeleteMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        this.courseService.deleteCourse(id);
        return "redirect:/courses";
    }
}
