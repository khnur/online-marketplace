package com.example.springBoot21.controller;

import com.example.springBoot21.dto.ErrorDto;
import com.example.springBoot21.exceptions.ItemNotExistsException;
import com.example.springBoot21.exceptions.UserAlreadyExistsException;
import com.example.springBoot21.exceptions.UserNotExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;


public class ExceptionController {
    @ExceptionHandler(ItemNotExistsException.class)
    public ResponseEntity<?> handleItemNotFound(HttpServletRequest request, RuntimeException e) {
        return ResponseEntity.status(NOT_FOUND).body(
                ErrorDto.builder()
                        .timestamp(new Date())
                        .status(NOT_FOUND.value())
                        .error(NOT_FOUND.getReasonPhrase())
                        .path(request.getServletPath())
                        .message(e.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleUserConflict(HttpServletRequest request, RuntimeException e) {
        return ResponseEntity.status(CONFLICT).body(
                ErrorDto.builder()
                        .timestamp(new Date())
                        .status(CONFLICT.value())
                        .error(CONFLICT.getReasonPhrase())
                        .path(request.getServletPath())
                        .message(e.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(UserNotExistsException.class)
    public ResponseEntity<?> handleUserNotFound(HttpServletRequest request, RuntimeException e) {
        return ResponseEntity.status(NOT_FOUND).body(
                ErrorDto.builder()
                        .timestamp(new Date())
                        .status(NOT_FOUND.value())
                        .error(NOT_FOUND.getReasonPhrase())
                        .path(request.getServletPath())
                        .message(e.getMessage())
                        .build()
        );
    }
}
