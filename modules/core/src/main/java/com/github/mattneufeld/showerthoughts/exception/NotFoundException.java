package com.github.mattneufeld.showerthoughts.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String msg){
        super(msg);
    }
}
