package org.jon.lv.es;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @Package org.jon.lv.es.BookService
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/22 13:56
 * version V1.0.0
 */
public interface BookService {

    Book save(Book book);

    void delete(Book book);

    Book findOne(String id);

    Iterable<Book> findAll();

    Page<Book> findByAuthor(String author, PageRequest pageRequest);

    List<Book> findByTitle(String title);
}