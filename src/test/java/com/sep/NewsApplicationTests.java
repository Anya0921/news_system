package com.sep;

import com.sep.pojo.NewsDetails;
import com.sep.service.NewsDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class NewsApplicationTests {

    @Autowired
    private NewsDetailsServiceImpl newsDetailsService;

    @Test
    void contextLoads() {
//        System.out.println(newsDetailsService.selectOneById(2));
//        newsDetailsService.updateOneNews(new NewsDetails(2,"周杰伦结婚","fasccasc","小林",new Date(),"娱乐"));
//        System.out.println(newsDetailsService.selectOneById(2));
//        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//        System.out.println(format);
        List<NewsDetails> newsDetails = newsDetailsService.selectContent("湖人");
        for(NewsDetails news:newsDetails){
            System.out.println(news.getTitle());
        }
    }

    @Test
    void addNews(){
        for (int i = 0; i < 10; i++) {
            newsDetailsService.addOneNews(new NewsDetails("test","test123","sep",new Date(),"test"));
        }
    }

}
