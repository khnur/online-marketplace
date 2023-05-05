package com.example.springBoot21.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class ErrorDto {
    private Date timestamp;
    private int status;
    private String error;
    private String path;
    private String message;
}
