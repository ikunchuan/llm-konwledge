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

    private Integer code;
    private String message;
    private String status;
    private Object data;

    /**
     * 成功返回
     * @return
     */
    public static ResultEntity success() {
        return new ResultEntity(HttpStatus.OK.value(), "success", "success", null);
    }

    public static ResultEntity success(Object data) {
        return new ResultEntity(HttpStatus.OK.value(), "success", "success", data);
    }


    public static ResultEntity success(String message) {
        return new ResultEntity(HttpStatus.OK.value(), message, "success", null);
    }

    public static ResultEntity success(String message, String status) {
        return new ResultEntity(HttpStatus.OK.value(), message, status, null);
    }

    public static ResultEntity success(String message, String status, Object data) {
        return new ResultEntity(HttpStatus.OK.value(), message, status, data);
    }

    /**
     * 返回失败
     * @return
     */
    public static ResultEntity fail() {
        return new ResultEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(), "fail", "fail", null);
    }

    public static ResultEntity fail(String message) {
        return new ResultEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, "fail", null);
    }

    public static ResultEntity fail(String message, String status) {
        return new ResultEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, status, null);
    }

}
