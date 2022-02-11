package com.lee.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookMapper mapper;

    @Test
    void testSelectList() {
        System.out.println(mapper.selectList(null));
    }
}
