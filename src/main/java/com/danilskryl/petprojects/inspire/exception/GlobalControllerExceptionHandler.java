package com.danilskryl.petprojects.inspire.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    @ExceptionHandler(CourseNotFoundException.class)
    public ModelAndView courseNotFoundException(CourseNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("/error-page");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(ModuleNotFoundException.class)
    public ModelAndView moduleNotFoundException(ModuleNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("/error-page");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("/error-page");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }
}
