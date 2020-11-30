package com.osborn.elastic;

import com.osborn.elastic.bean.Article;
//import io.searchbox.client.JestClient;
//import io.searchbox.core.Index;
//import io.searchbox.core.Search;
//import io.searchbox.core.SearchResult;
import com.osborn.elastic.bean.Book;
import com.osborn.elastic.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot10ElasticApplicationTests {

//    @Autowired
//    private JestClient jestClient;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testLikeSearch() {
        List<Book> bookNames = bookRepository.findByBookNameLike("西");
        bookNames.stream().forEach(System.out::println);
    }

    @Test
    public void test02() {
        Book book01 = new Book(1, "西游记", "吴承恩");
        Book book02 = new Book(2, "三国演义", "罗贯中");
        bookRepository.index(book02);
    }

    @Test
    public void contextLoads() {
        Article article = new Article(1, "osborn", "Java", "坚持终身，永不放弃！！！");
        //构建一个索引功能
//        Index index = new Index.Builder(article).index("steven").type("news").build();
//
//        try {
//            //执行
//            jestClient.execute(index);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void search() {
        //查询表达式
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"坚持\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建搜索功能
//        Search search = new Search.Builder(json).addIndex("steven").addType("news").build();
//        try {
//            //执行
//            SearchResult result = jestClient.execute(search);
//            System.out.println(result.getSourceAsString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
