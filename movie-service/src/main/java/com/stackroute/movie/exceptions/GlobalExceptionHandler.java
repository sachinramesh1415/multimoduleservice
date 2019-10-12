package com.stackroute.movie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<?> handleMovieNotFoundException() {
        return new ResponseEntity<String>("Movie has not been found", HttpStatus.CONFLICT);
    }
    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<?> handleMovieAlreadyExistsException() {
        return new ResponseEntity<String>("Movie already exists",HttpStatus.CONFLICT);
    }
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<?> handleSQLException() {
        return new ResponseEntity<String>("Database Connectivity Error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
