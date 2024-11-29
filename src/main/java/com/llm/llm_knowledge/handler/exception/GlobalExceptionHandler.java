package com.llm.llm_knowledge.handler.exception;

import cn.dev33.satoken.exception.NotLoginException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.llm.llm_knowledge.exception.UserException;
import com.llm.llm_knowledge.pojo.ResultEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.awt.*;

/**
 * @author : symao
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ResultEntity> handlerUserException(Exception ex, WebRequest request) {
        ResultEntity error = new ResultEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), "error", null);
        return new ResponseEntity<ResultEntity>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 用户未登录异常
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(NotLoginException.class)
    public ResponseEntity<ResultEntity> handleNotLoginException(Exception ex, WebRequest request) {
        ResultEntity resultEntity = new ResultEntity(HttpStatus.UNAUTHORIZED.value(), "用户未登录", "not login", null);
        return new ResponseEntity<ResultEntity>(resultEntity, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
