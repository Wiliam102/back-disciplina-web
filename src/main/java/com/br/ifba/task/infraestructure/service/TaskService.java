package com.br.ifba.task.infraestructure.service;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.br.ifba.task.infraestructure.entity.Task;
import com.br.ifba.task.infraestructure.exception.TaskAlreadyExistsException;
import com.br.ifba.task.infraestructure.exception.TaskNotFoundException;
import com.br.ifba.task.infraestructure.repository.TaskRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    
    // retornando objetos paginados
    public Page<Task> findall(Pageable pageable){
        return taskRepository.findAll(pageable);
    }

    @Transactional
    public Task save(Task task){
        // verificando se a tarefa já esta cadastrada
        if(taskRepository.existsTaskByDescription(task.getDescription())){
            throw new TaskAlreadyExistsException("A tarefa já esta cadastrada.");
        }
        // salvando a tarefa e retornando-á
        return taskRepository.save(task);

    }
    @Transactional
    public Task update(Task taskUpdate, Long id){
        Task task = taskRepository.findById(id).orElseThrow(()-> new TaskNotFoundException("A tarefa não foi encontrada") );
        
            taskUpdate.setId(id);// aqui está passando o id da taefa pra o objeto que está com os dados atualizados
            return taskRepository.save(taskUpdate);// atualizando e retornando o objeto atualizado
       
    }
    @Transactional
    public Optional<Task> delete(Long id){
        // bunscando a tarefa para retorno
        Optional<Task> task  = taskRepository.findById(id);
        taskRepository.deleteById(id);// deletando objeto pelo id
        return task;// retorntando o objeto deletado
    }

}
