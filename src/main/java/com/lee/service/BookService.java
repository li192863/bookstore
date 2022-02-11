package com.lee.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.domain.Book;

public interface BookService extends IService<Book> {
    IPage<Book> getPage(Integer currentPage, Integer pageSize);
    IPage<Book> getPage(Integer currentPage, Integer pageSize, Book book);
}
