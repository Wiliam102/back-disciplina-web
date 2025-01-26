package com.br.ifba.task.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ifba.task.infraestructure.dto.TaskDto;
import com.br.ifba.task.infraestructure.entity.Task;
import com.br.ifba.task.infraestructure.service.TaskService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.br.ifba.task.infraestructure.modelmapper.TaskMapper;
@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/findall")
    public List<TaskDto> findall(){
        List<Task> listTask = taskService.findall();
        return TaskMapper.listExpenseToDto(listTask);
    }
    
    @PostMapping("/save")
    public ResponseEntity<TaskDto> save(@RequestBody TaskDto dto){
        Task task = TaskMapper.toTask(dto);
        Task taskreturned = taskService.save(task);
       return ResponseEntity.status(HttpStatus.CREATED).body(TaskMapper.toDto(taskreturned));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDto> update(@PathVariable Long id, @RequestBody TaskDto dto) {
        Task task = TaskMapper.toTask(dto);

        Task taskReturned = taskService.update(task, id);
        
        return ResponseEntity.status(HttpStatus.OK).body(TaskMapper.toDto(taskReturned));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Task>> delete(@PathVariable Long id){
        Optional<Task> taskReturned = taskService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(taskReturned);
    }


}
