package com.jiehfut.springlogin.config;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@ResponseBody
@ControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(Exception.class)
    public HashMap<String, Object> exceptionAdvice(Exception e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", "-1");
        result.put("msg", e.getMessage());
        return result;
    }

    @ExceptionHandler(ArithmeticException.class)
    public HashMap<String, Object> arithmeticAdvice(ArithmeticException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", "-2");
        result.put("msg", e.getMessage());
        return result;
    }
}




