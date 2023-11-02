package com.danilskryl.petprojects.inspire.repository;

import com.danilskryl.petprojects.inspire.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
