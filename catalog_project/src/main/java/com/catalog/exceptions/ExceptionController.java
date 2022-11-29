package com.catalog.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoSuchElementException.class)
    Map<String, String> handlNoSuchElementException
            (NoSuchElementException ex) {
        Map<String, String> serviceErrors = new HashMap<>();

        serviceErrors.put("Error Message",ex.getMessage());
        return serviceErrors;
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    Map<String , String > handlEmptyResultDataAccessException
            (EmptyResultDataAccessException ex) {
        Map<String , String> emptyResultDataAccessEx
                = new HashMap<>();

        emptyResultDataAccessEx.put("Error Massage" , "this element aready is not exist");

        return emptyResultDataAccessEx;
    }
}
