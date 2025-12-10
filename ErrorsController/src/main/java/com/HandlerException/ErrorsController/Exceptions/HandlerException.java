package com.HandlerException.ErrorsController.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
@org.springframework.web.bind.annotation.ControllerAdvice
@RestControllerAdvice
public class HandlerException {
// For errors inside of body with if else
    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> notFoundException(Exception ex) {
        Map<String, Object> errors = new LinkedHashMap<>();

        errors.put("date", new Date());
        errors.put("status", HttpStatus.NOT_FOUND);
        errors.put("message", ex.getMessage());

        return errors;
    }
// For errors with the body request, validations in the model request @valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationsExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new LinkedHashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("time", LocalDateTime.now().toString());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("errors", errors);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

// For general errors example bad url
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> globalException(Exception e) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss,SSS");
        String dateNow = LocalDateTime.now().format(formatter);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("fecha", dateNow);
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("errors", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    };
}














