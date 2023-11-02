package com.danilskryl.petprojects.inspire.service;

import com.danilskryl.petprojects.inspire.entity.Module;
import com.danilskryl.petprojects.inspire.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModuleService {
    private final ModuleRepository repository;

    @Autowired
    public ModuleService(ModuleRepository repository) {
        this.repository = repository;
    }

    public Module getModuleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Module> getAllModules() {
        return repository.findAll();
    }

    @Transactional
    public Module saveModule(Module module) {
        return repository.save(module);
    }

    @Transactional
    public void deleteModuleById(Long id) {
        repository.deleteById(id);
    }
}
