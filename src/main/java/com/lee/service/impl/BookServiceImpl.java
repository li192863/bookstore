package com.lee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.dao.BookMapper;
import com.lee.domain.Book;
import com.lee.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    private BookMapper mapper;

    @Override
    public IPage<Book> getPage(Integer currentPage, Integer pageSize) {
        IPage page = new Page(currentPage, pageSize);
        mapper.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Book> getPage(Integer currentPage, Integer pageSize, Book book) {
        // 组织条件
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());
        // 分页查询
        IPage page = new Page(currentPage, pageSize);
        mapper.selectPage(page, lqw);
        return page;
    }
    /**
     * @Override
     * public IPage<Book> getPage(Integer currentPage, Integer pageSize, Book book) {
     *     // 组织条件
     *     LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
     *     lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
     *     lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
     *     lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());
     *     // 分页查询
     *     IPage page = new Page(currentPage, pageSize);
     *     mapper.selectPage(page, lqw);
     *     return page;
     * }
     */
}
