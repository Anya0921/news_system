package com.sep.service;

import com.sep.pojo.NewsDetails;

import java.util.List;

public interface NewsDetailsService {
    //查询所有新闻
    List<NewsDetails> selectAllNews();

    //查询某条新闻
    NewsDetails selectOneById(int id);

    NewsDetails selectOneByTitle(String title);

    //根据作者名字查询新闻
    NewsDetails selectByAuthor(String author);

    //增加一条新闻
    void addOneNews(NewsDetails newsDetails);

    //删除一条新闻
    void deleteOneNews(int id);

    //修改某条新闻
    void updateOneNews(NewsDetails newsDetails);

    /**
     * 模糊查询 根据标题的任意字符查询新闻
     */
    List<NewsDetails> selectContent(String title);
}
