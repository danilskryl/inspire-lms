package com.danilskryl.petprojects.inspire.controller;

import com.danilskryl.petprojects.inspire.entity.Course;
import com.danilskryl.petprojects.inspire.entity.Module;
import com.danilskryl.petprojects.inspire.exception.CourseNotFoundException;
import com.danilskryl.petprojects.inspire.service.CourseModuleService;
import com.danilskryl.petprojects.inspire.service.CourseService;
import com.danilskryl.petprojects.inspire.service.ModuleService;
import com.danilskryl.petprojects.inspire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final CourseService service;
    private final UserService userService;

    @Autowired
    public CourseController(CourseService service, CourseModuleService courseModuleService, UserService userService, ModuleService moduleService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping
    public String allCourses(Model model) {
//        Course course = service.findById(15L);
//        Module module = new Module();
//        module.setCourse(course);
//        module.setChapters(new HashSet<>());
//        module.setTitle("Java Core");
//        module.setDescription("В этом модуле пройдете основные тонкости Java Core");
//        moduleService.saveModule(module);
        model.addAttribute("allCourses", service.findAll());
        return "all-courses-page";
    }

    @GetMapping("/{id}")
    public String showCourse(@PathVariable Long id, Model model) {
        Course course = service.findById(id);
        if (course == null) throw new CourseNotFoundException(id);

        model.addAttribute("course", course);
        model.addAttribute("modules", course.getModules());
        return "course-page";
    }

    @GetMapping("/new")
    public String formNewCourse(Model model) {
        model.addAttribute("newCourse", new Course());
        return "form-new-course-page";
    }

    @GetMapping("/{id}/edit")
    public String formEditCourse(@PathVariable Long id, Model model) {
        model.addAttribute("course", service.findById(id));
        return "course-page-edit";
    }

    @PostMapping
    public String saveCourse(@ModelAttribute("course") Course course) {
        course.setAuthor(userService.getUserByEmail("restillbiz@gmail.com"));
        service.save(course);
        return "redirect:/courses";
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/courses";
    }

    @PatchMapping
    public String updateCourse(@ModelAttribute("course") Course course) {
        service.save(course);
        return "redirect:/courses";
    }
}
