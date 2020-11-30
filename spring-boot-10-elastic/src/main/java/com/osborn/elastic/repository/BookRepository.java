package com.osborn.elastic.repository;

import com.osborn.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-12-02 15:16
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    //自定义查询,参照https://docs.spring.io/spring-data/elasticsearch/docs/3.1.3.RELEASE/reference/html/
    public List<Book> findByBookNameLike(String bookName);
}
