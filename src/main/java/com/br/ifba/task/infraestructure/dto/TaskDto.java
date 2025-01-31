package com.br.ifba.task.infraestructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;;

@Getter
@Setter
@AllArgsConstructor
public class TaskDto {
    private Long id;
    @NotBlank
    @Size(min=5, max=200)
    private String description;

    public TaskDto(){}

}
