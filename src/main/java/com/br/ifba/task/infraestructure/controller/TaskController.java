package com.br.ifba.task.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ifba.task.infraestructure.dto.TaskDto;
import com.br.ifba.task.infraestructure.entity.Task;
import com.br.ifba.task.infraestructure.exception.TaskNotNullException;
import com.br.ifba.task.infraestructure.service.TaskService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.br.ifba.task.infraestructure.modelmapper.TaskMapper;
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/findall")
    public Page<TaskDto> findall(Pageable pageable){
        // aqui estou retornando uma lista objetos paginados de tarefas mapeada para dto
        Page<Task> taskPage = taskService.findall(pageable);
        return taskPage.map(TaskMapper::toDto);
    }
    @PostMapping("/save")
    public ResponseEntity<TaskDto> save(@Valid @RequestBody TaskDto dto){

        Task task = TaskMapper.toTask(dto);
        Task taskreturned = taskService.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(TaskMapper.toDto(taskreturned));
        
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDto> update(@Valid @PathVariable Long id, @RequestBody TaskDto dto) {
        Task task = TaskMapper.toTask(dto);// mapeamento

        Task taskReturned = taskService.update(task, id);// aqui está passando a tarefa e o id como parametro para a classe service que vai acessar o repositorio e atualizar os dados
        
        // aqui está retornando um status de ok e o dto da terefa que foi atualizada
        return ResponseEntity.status(HttpStatus.OK).body(TaskMapper.toDto(taskReturned));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Task>> delete(@PathVariable Long id){
        Optional<Task> taskReturned = taskService.delete(id);// aqui faz o delete e pega o retorno do objeto que foi deletado
        return ResponseEntity.status(HttpStatus.OK).body(taskReturned);
    }


}
