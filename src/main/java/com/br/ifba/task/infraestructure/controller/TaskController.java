package com.br.ifba.task.infraestructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ifba.task.infraestructure.entity.Task;
import com.br.ifba.task.infraestructure.service.TaskService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/save")
    public ResponseEntity<Task> save(@RequestBody Task task){
       taskService.save(task);
       return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

}
