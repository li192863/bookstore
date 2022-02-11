package com.lee.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lee.controller.util.Result;
import com.lee.domain.Book;
import com.lee.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping
    public Result getAll() {
        return new Result(true, service.list());
    }

    @PostMapping
    public Result save(@RequestBody Book book) {
        return new Result(service.save(book));
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        return new Result(service.updateById(book));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return new Result(service.removeById(id));
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        return new Result(true, service.getById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, Book book) {
        System.out.println(book);
        IPage<Book> page = service.getPage(currentPage, pageSize, book);
        // 如果当前页码值大于总页码值则重新查询最后一页
        if (currentPage > page.getPages()) {
            page = service.getPage((int) page.getPages(), pageSize, book);
        }
        return new Result(true, page);
    }
}
