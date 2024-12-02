package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Book;
import com.llm.llm_knowledge.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books/v1")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    /**查询所有书籍数据*/
    @GetMapping("book")
    public List<Book> allBook(){
        return bookService.allBook();
    }
    
    /**分页查询 传入的参数为Num和Size*/
    @GetMapping("page/book")
    public Page<Book> allPageBook(@RequestParam Integer currentNum,@RequestParam Integer currentSize){
        return bookService.allPageBook(currentNum,currentSize);
    }
    
    /**添加书籍*/
    @PostMapping("book")
    public Integer addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }
    
    /**更新书籍信息*/
    @PutMapping("book/")
    public Integer updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }
    
    /**删除书籍*/
    @DeleteMapping("del/book")
    public Integer deleteBook(@PathVariable Integer bookId){
        return bookService.deleteBook(bookId);
    }
    
    /**批量删除书籍*/
    @DeleteMapping("muldel/book")
    public Integer muldeleteBook(@RequestBody List<Integer> bookIds){
        return bookService.muldeleteBook(bookIds);
    }
    
}
