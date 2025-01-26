package com.br.ifba.task.infraestructure.exception;

public class TaskNotBlankException extends RuntimeException {
    public TaskNotBlankException(String message){
      super(message);
    }

}
