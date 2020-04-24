package com.yuntian.jwt.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @date 2020-04-19 15:50
 * @description
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        log.error("捕获异常", e);
        return ResultGenerator.genFailResult(e.getMessage());
    }


}
