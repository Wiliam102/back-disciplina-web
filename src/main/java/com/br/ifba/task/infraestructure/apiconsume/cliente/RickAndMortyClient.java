package com.br.ifba.task.infraestructure.apiconsume.cliente;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.br.ifba.task.infraestructure.apiconsume.model.CharacterResponse;

import reactor.core.publisher.Mono;

@Service
public class RickAndMortyClient {
    private final WebClient webClient;

    public RickAndMortyClient(WebClient.Builder webClient){
        this.webClient = webClient.baseUrl("https://rickandmortyapi.com/api").build();
    }
    public Mono<CharacterResponse> findCharacterById(String id){
        return webClient.get().uri("/character/{id}",id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(CharacterResponse.class);
    }

}
