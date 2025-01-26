package com.br.ifba.task.infraestructure.exception;

public class TaskNotNullException extends RuntimeException {
    public TaskNotNullException(String message){
        super(message);
    }

}
