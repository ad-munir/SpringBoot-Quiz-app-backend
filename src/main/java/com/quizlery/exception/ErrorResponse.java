package com.quizlery.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private final String message;
    private final HttpStatus httpStatus;
    private final Date timestamp;
}
