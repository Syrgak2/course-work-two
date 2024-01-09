package com.example.course.work.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IllegalAmountException extends RuntimeException {


    public IllegalAmountException() {
    }

    public IllegalAmountException(String message) {
        super(message);
    }
}
