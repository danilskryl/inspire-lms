package com.danilskryl.petprojects.inspire.exception;

public class ModuleNotFoundException extends RuntimeException {
    public ModuleNotFoundException(Long id) {
        super("Module not found: " + id);
    }
}
