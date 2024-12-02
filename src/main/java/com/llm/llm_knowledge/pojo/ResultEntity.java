package com.llm.llm_knowledge.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author : symao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultEntity {

    private String message;
    private Integer code;
    private Object data;

    /**
     * 成功返回
     * @return
     */
    public static ResultEntity success() {
        return new ResultEntity("success", HttpStatus.OK.value(), null);
    }

    public static ResultEntity success(Object data) {
        return new ResultEntity("success", HttpStatus.OK.value(), data);
    }


    public static ResultEntity success(String message) {
        return new ResultEntity(message, HttpStatus.OK.value(), null);
    }

    public static ResultEntity success(String message, String status) {
        return new ResultEntity(message, HttpStatus.OK.value(), null);
    }

    public static ResultEntity success(String message, String status, Object data) {
        return new ResultEntity(message, HttpStatus.OK.value(), data);
    }

    /**
     * 返回失败
     * @return
     */
    public static ResultEntity fail() {
        return new ResultEntity("系统异常", HttpStatus.INTERNAL_SERVER_ERROR.value(), null);
    }

    public static ResultEntity fail(String message) {
        return new ResultEntity(message, HttpStatus.INTERNAL_SERVER_ERROR.value(), null);
    }

    public static ResultEntity fail(String message, HttpStatus code) {
        return new ResultEntity(message, code.value(), null);
    }

}
