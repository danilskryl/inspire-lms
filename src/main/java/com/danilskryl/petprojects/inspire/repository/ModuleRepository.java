package com.danilskryl.petprojects.inspire.repository;

import com.danilskryl.petprojects.inspire.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}
