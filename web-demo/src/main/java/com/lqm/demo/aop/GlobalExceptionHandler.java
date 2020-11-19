package com.lqm.demo.aop;

import com.lqm.demo.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.*;
import java.util.Iterator;

/**
 * @Author Liqm
 * @Date 2020/11/17 0017
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * ValidationException 所有Bean验证失败的基础类型
     * @param e
     * @return
     */
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result validationException(ValidationException e) {
        log.warn("参数错误:{}", e.getMessage());
        return Result.fail("参数错误");
    }

    /**
     * ServletRequestBindingException 所有缺失参数的异常的基础类
     * @param e
     * @return
     */
    @ExceptionHandler(ServletRequestBindingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result servletRequestBindingException(ServletRequestBindingException e) {
        log.warn("参数缺失:{}", e.getMessage());
        return Result.fail("参数缺失");
    }

    /**
     * 分辨不清异常类型时使用，
     */
    @ExceptionHandler(UnexpectedTypeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result unexpectedTypeException(UnexpectedTypeException e) {
        log.warn("参数类型不匹配:{}", e);
        return Result.fail("参数非法");
    }

    /**
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result missingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.warn("缺少参数:{}", e.getParameterName());
        return Result.fail("缺少参数" + e.getParameterName());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result constraintViolationException(ConstraintViolationException e) {
        Iterator<ConstraintViolation<?>> iterator = e.getConstraintViolations().iterator();
        StringBuffer sb = new StringBuffer();
        while (iterator.hasNext()) {
            ConstraintViolation<?> next = iterator.next();
            sb.append(next.getMessageTemplate()).append("，");
        }
        log.warn("参数异常:{}", sb.toString());
        return Result.fail(sb.toString());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.warn("参数类型不匹配:{}", e.getMessage());
        return Result.fail("非法参数:" + e.getName());
    }





}
