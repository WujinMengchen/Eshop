package com.eshop.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

@ControllerAdvice// 交给spring容器管理 标识是一个异常处理器
public class BaseExceptionHandler {
    @ExceptionHandler(value= Exception.class)
    @ResponseBody
    public Result handlerException(Exception e) {
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
