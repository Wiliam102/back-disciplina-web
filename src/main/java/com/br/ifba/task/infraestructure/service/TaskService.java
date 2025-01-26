package com.br.ifba.task.infraestructure.service;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.ifba.task.infraestructure.entity.Task;
import com.br.ifba.task.infraestructure.exception.TaskAlreadyExistsException;
import com.br.ifba.task.infraestructure.exception.TaskNotBlankException;
import com.br.ifba.task.infraestructure.exception.TaskNotNullException;
import com.br.ifba.task.infraestructure.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> findall(){
        return taskRepository.findAll();
    }

    public Task save(Task task){
        // verificando se a tarefa é nula ou campo vazio
        if(task == null){
           throw new TaskNotNullException("A tarefa não pode ser nula");
        }
        if(task.getDescription().equals("") || task.getDescription().equals(" ")){
            throw new TaskNotBlankException("A descrição da tarefa não pode ser vazia");
        }
        // verificando se a tarefa já esta cadastrada
        if(taskRepository.existsTaskByDescription(task.getDescription())){
            throw new TaskAlreadyExistsException("A tarefa já esta cadastrada.");
        }
        // salvando a tarefa e retornando-á
        return taskRepository.save(task);

    }
    public Task update(Task taskUpdate, Long id){
        // busacando a tarefa no banco e verificando se existe
        if(taskUpdate.getDescription().equals("") || taskUpdate.getDescription().equals(" ")){
            throw new RuntimeException("A descricao nao pode ser vazia");
        }
        Optional<Task> task = taskRepository.findById(id);
        if(task!=null)
        {
            taskUpdate.setId(id);// setando id
            return taskRepository.save(taskUpdate);// atualizando

        }
        else
        return null;
       
    }

    public Optional<Task> delete(Long id){
        // bunscando a tarefa para retorno
        Optional<Task> task  = taskRepository.findById(id);
        taskRepository.deleteById(id);
        return task;
    }

}
