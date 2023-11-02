package com.danilskryl.petprojects.inspire.repository;

import com.danilskryl.petprojects.inspire.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
