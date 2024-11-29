package com.llm.llm_knowledge.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
