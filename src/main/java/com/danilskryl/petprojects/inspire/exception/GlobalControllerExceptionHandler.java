package com.danilskryl.petprojects.inspire.exception;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    @ExceptionHandler(CourseNotFoundException.class)
    public String courseNotFoundException(CourseNotFoundException ex, Model model, HttpServletRequest request) {
        model.addAttribute("errorMessage", ex.getMessage());
        int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, statusCode);
        return "error-page";
    }
}
