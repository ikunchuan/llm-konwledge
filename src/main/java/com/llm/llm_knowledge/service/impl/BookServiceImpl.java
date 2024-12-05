package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Book;
import com.llm.llm_knowledge.mapper.BookMapper;
import com.llm.llm_knowledge.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BookServiceImpl implements BookService {
    
    @Autowired
    private BookMapper bookMapper;
    
    @Override
    public List<Book> allBook() {
        return bookMapper.selectList(null);
    }
    
    
    @Override
    public Page<Book> allPageBook(Integer currentNum, Integer currentSize) {
        Page<Book> pageBook = new Page<>(currentNum, currentSize);
        return bookMapper.selectPage(pageBook, null);
    }
    
    @Override
    public Integer addBook(Book book) {
        return bookMapper.insert(book);
    }
    
    @Override
    public Integer updateBook(Book book) {
        return bookMapper.updateById(book);
    }
    
    @Override
    public Integer deleteBook(Integer bookId) {
        return bookMapper.deleteById(bookId);
    }
    
    @Override
    public Integer muldeleteBook(List<Integer> bookIds) {
        return bookMapper.deleteByIds(bookIds);
    }
    
    
}
