// JacksonTypeHandler.java
package com.llm.llm_knowledge.handler;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import org.apache.ibatis.type.MappedTypes;
import java.util.List;

@MappedTypes(List.class)
public class StringListTypeHandler extends JacksonTypeHandler {
    public StringListTypeHandler(Class<?> type) {
        super(type);
    }
}