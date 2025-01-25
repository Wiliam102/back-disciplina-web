package com.br.ifba.task.infraestructure.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.ifba.task.infraestructure.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
