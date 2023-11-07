package com.danilskryl.petprojects.inspire.service;

import com.danilskryl.petprojects.inspire.entity.Module;
import com.danilskryl.petprojects.inspire.repository.CourseRepository;
import com.danilskryl.petprojects.inspire.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseModuleService {
    private final CourseRepository courseRepository;
    private final ModuleRepository moduleRepository;

    @Autowired
    public CourseModuleService(CourseRepository courseRepository, ModuleRepository moduleRepository) {
        this.courseRepository = courseRepository;
        this.moduleRepository = moduleRepository;
    }

    public Module getModuleById(Long id) {
        return moduleRepository.getReferenceById(id);
    }
}
