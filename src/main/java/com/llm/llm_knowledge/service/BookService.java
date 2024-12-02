package com.llm.llm_knowledge.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Book;
import com.llm.llm_knowledge.entity.Question;

import java.util.List;

public interface BookService {
    
    /**查询所有书籍数据*/
    List<Book> allBook();
    
    Page<Book> allPageBook(Integer currentNum, Integer currentSize);
    
    Integer addBook(Book book);
    
    Integer updateBook(Book book);
    
    Integer deleteBook(Integer bookId);
    
    Integer muldeleteBook(List<Integer> bookIds);
}
