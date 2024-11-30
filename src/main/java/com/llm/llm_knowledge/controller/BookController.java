package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Book;
import com.llm.llm_knowledge.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("books/v1")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @GetMapping("book")
    public List<Book> allBook(){
        return bookService.allBook();
    }
    
    @GetMapping("page/book")
    public Page<Book> allPageBook(@RequestParam Integer currentNum,@RequestParam Integer currentSize){
        return bookService.allPageBook(currentNum,currentSize);
    }
    
    
}
