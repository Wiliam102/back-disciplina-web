package com.br.ifba.task.infraestructure.modelmapper;

import com.br.ifba.task.infraestructure.dto.TaskDto;
import com.br.ifba.task.infraestructure.entity.Task;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.modelmapper.ModelMapper;
import java.util.List;
import org.modelmapper.TypeToken;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskMapper {
    public static Task toTask(TaskDto dto){
        return new ModelMapper().map(dto, Task.class);
    }

    public static TaskDto toDto(Task task){
        return new ModelMapper().map(task, TaskDto.class);
    }

    public static List<TaskDto> listExpenseToDto(List<Task> listTask){
        ModelMapper modelMapper = new ModelMapper();
       return modelMapper.map(listTask, new TypeToken<List<TaskDto>>() {}.getType());
    }

}
