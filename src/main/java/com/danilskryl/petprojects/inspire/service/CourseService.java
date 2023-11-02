package com.danilskryl.petprojects.inspire.service;

import com.danilskryl.petprojects.inspire.entity.Course;
import com.danilskryl.petprojects.inspire.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repository;

    @Autowired
    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> findAll() {
        return repository.findAll();
    }

    public Course findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Course course) {
        repository.save(course);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
