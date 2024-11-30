package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("book")
public class Book {
    
    @TableId(type = IdType.AUTO)
    private Integer bookId;
    private String bookIsbn;
    private String bookName;
    private String bookImgUrl;
    private Date bookIssuetime;
    private String bookAuthor;
    private String bookKeywords;
    private String bookIntroduction;
    private Integer categoryId;
    private String language;
    private Integer pageCount;
    private String format;
    private String publisher;
    
    @TableField(fill= FieldFill.INSERT)
    private Date createdTime;
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private Date updatedTime;
    
}
