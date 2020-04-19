package com.yuntian.security.config;

import com.yuntian.security.common.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @date 2020-04-19 15:50
 * @description
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        log.error("捕获异常", e);
        if (isAjax(request)) {
            return ResultGenerator.genFailResult(e.getMessage());
        } else {
            return getErrorPage(request, e);
        }
    }

    public static boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With")));
    }


    public ModelAndView getErrorPage(HttpServletRequest request, Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == 401) {
            mav.setViewName("/error/401");
        } else if (statusCode == 404) {
            mav.setViewName("/error/404");
        } else if (statusCode == 403) {
            mav.setViewName("/error/403");
        } else {
            mav.setViewName("/error/error");
        }
        return mav;
    }


}
