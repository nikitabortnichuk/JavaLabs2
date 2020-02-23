package com.bortnichuk.entity.exception;

public class SetterCalledException extends RuntimeException{

    private static final String MESSAGE = "Can not set a value!";

    public SetterCalledException() {
        System.out.println(MESSAGE);
    }

}
