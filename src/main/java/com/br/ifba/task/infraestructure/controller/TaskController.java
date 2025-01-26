package com.br.ifba.task.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ifba.task.infraestructure.entity.Task;
import com.br.ifba.task.infraestructure.service.TaskService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/findall")
    public List<Task> findall(){
        return taskService.findall();
    }
    
    @PostMapping("/save")
    public ResponseEntity<Task> save(@RequestBody Task task){
       taskService.save(task);
       return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task) {

        Task taskReturned = taskService.update(task, id);
        
        return ResponseEntity.status(HttpStatus.OK).body(taskReturned);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Task>> delete(@PathVariable Long id){
        Optional<Task> taskReturned = taskService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(taskReturned);
    }


}
