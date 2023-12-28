package com.example.course.work.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class QuestionAlreadyAddedException extends RuntimeException {

    public QuestionAlreadyAddedException() {
    }

    public QuestionAlreadyAddedException(String message) {
        super(message);
    }
}
