package com.danilskryl.petprojects.inspire.controller;

import com.danilskryl.petprojects.inspire.entity.Module;
import com.danilskryl.petprojects.inspire.exception.ModuleNotFoundException;
import com.danilskryl.petprojects.inspire.service.CourseService;
import com.danilskryl.petprojects.inspire.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses/{idCourse}/modules")
public class ModuleController {
    private final ModuleService service;
    private final CourseService courseService;

    @Autowired
    public ModuleController(ModuleService service, CourseService courseService) {
        this.service = service;
        this.courseService = courseService;
    }

    @GetMapping("/{idModule}")
    public String showModule(@PathVariable Long idModule, Model model) {
        Module module = service.getModuleById(idModule);
        if (module == null) throw new ModuleNotFoundException(idModule);

        model.addAttribute("module", module);
        return "module-page";
    }

    @GetMapping("/new")
    public String formNewModule(@PathVariable Long idCourse, Model model) {
        Module module = new Module();
        model.addAttribute("newModule", module);
        model.addAttribute("idCourseModule", idCourse);
        return "form-new-module-page";
    }

    @PostMapping
    public String saveModule(@ModelAttribute("newModule") Module module, @PathVariable Long idCourse) {
        module.setCourse(courseService.findById(idCourse));
        service.saveModule(module);
        return "redirect:/courses/%d/modules/%d".formatted(idCourse, module.getId());
    }

    @DeleteMapping("/{idModule}")
    public String deleteModule(@PathVariable Long idModule, @PathVariable Long idCourse) {
        service.deleteModuleById(idModule);
        return "redirect:/courses/%d".formatted(idCourse);
    }
}
