package com.br.ifba.task.infraestructure.exception;

public class TaskAlreadyExistsException extends RuntimeException{
    public TaskAlreadyExistsException(String message){
        super(message);
    }

}
