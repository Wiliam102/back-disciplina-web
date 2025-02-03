package com.br.ifba.task.infraestructure.apiconsume.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record CharacterResponse(String id,String name, String status, String species, String image, List<String> episode ){

}
