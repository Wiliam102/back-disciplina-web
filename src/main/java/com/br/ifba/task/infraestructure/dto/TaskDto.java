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
    @NotBlank(message = "A descricao nao pode ser vazia")
    @Size(min=5, max=300, message = "A descricao deve ser no minmo 5 caracters e maximo 300 caracters")
    private String description;

    public TaskDto(){}

}
