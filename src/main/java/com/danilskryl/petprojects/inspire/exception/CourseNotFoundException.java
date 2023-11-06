package com.danilskryl.petprojects.inspire.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(Long id) {
        super("Course not found: " + id);
    }
}
