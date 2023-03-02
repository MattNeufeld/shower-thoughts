package com.github.mattneufeld.showerthoughts.exception;

/**
 * This is an exception to indicate that the requested values could not be found.
 */
public class NotFoundException extends RuntimeException{
    public NotFoundException(String msg){
        super(msg);
    }
}
