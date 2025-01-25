package com.br.ifba.task.infraestructure.service;

import org.springframework.stereotype.Service;

import com.br.ifba.task.infraestructure.entity.Task;
import com.br.ifba.task.infraestructure.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task save(Task task){
        return taskRepository.save(task);

    }

}
