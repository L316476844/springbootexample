package org.jon.lv.es;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package org.jon.lv.es.BookRepository
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/22 13:55
 * version V1.0.0
 */
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    Page<Book> findByAuthor(String author, Pageable pageable);

    List<Book> findByTitle(String title);

}