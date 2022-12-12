package mk.ukim.finki.wp.lab.web.controller;

import com.sun.istack.NotNull;
import lombok.Getter;
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
    @GetMapping("/add")
    public String getAddCoursePage(@NotNull Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "add-course";
    }

    @PostMapping("/add")
    public String saveCourse(@RequestParam String name, @RequestParam String description, @RequestParam Long teacher, @RequestParam(required = false) Long course) {
        if (course == null) {
            courseService.addCourse(name, description, teacher);
        } else {
            courseService.editCourse(course, name, description, teacher);
        }
        return "redirect:/courses";
    }

    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        this.courseService.deleteCourse(id);
        return "redirect:/courses";
    }
    @GetMapping("/edit/{id}")
    public String getEditCoursePage(@PathVariable Long id, Model model){
        if (courseService.getCourseById(id) == null) {
            return "redirect:/courses?error=Course Not Found";
        }

        model.addAttribute("course", courseService.getCourseById(id));
        model.addAttribute("teachers", teacherService.findAll());
        return "add-course";
    }

}

