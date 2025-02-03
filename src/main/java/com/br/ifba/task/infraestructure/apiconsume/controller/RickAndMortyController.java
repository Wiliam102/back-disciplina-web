package com.br.ifba.task.infraestructure.apiconsume.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ifba.task.infraestructure.apiconsume.cliente.RickAndMortyClient;
import com.br.ifba.task.infraestructure.apiconsume.model.CharacterResponse;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/apitestconsume")
@AllArgsConstructor
public class RickAndMortyController {
RickAndMortyClient rickAndMortyClient;

@GetMapping("/character/{id}")
@ResponseStatus(HttpStatus.OK)
 public Mono<CharacterResponse> getCharacterById(@PathVariable String id){
    return rickAndMortyClient.findCharacterById(id);
 }
}
