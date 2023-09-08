package com.example.fitnesshelp.exception;

public class ExerciseLoadException extends RuntimeException {
    public ExerciseLoadException(String message) {
        super(message);
    }

    public ExerciseLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}

