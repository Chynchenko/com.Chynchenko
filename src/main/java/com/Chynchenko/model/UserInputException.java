package com.Chynchenko.model;

public class UserInputException extends Throwable {
    public UserInputException () {
    }

    public UserInputException (final String message) {
        super(message);

    }
}