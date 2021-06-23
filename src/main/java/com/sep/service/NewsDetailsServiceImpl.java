package com.sep.service;

import com.sep.dao.NewsDetailsDao;
import com.sep.pojo.NewsDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsDetailsServiceImpl implements NewsDetailsService{

    @Autowired
    private NewsDetailsDao newsDetailsDao;

    @Override
    public List<NewsDetails> selectAllNews() {
        List<NewsDetails> newsDetails = newsDetailsDao.selectAllNews();
//        newsDetails.forEach(System.out::println);
        return newsDetails;
    }

    @Override
    public NewsDetails selectOneById(int id) {
        return newsDetailsDao.selectOneById(id);
    }

    @Override
    public NewsDetails selectOneByTitle(String title) {
        return newsDetailsDao.selectOneByTitle(title);
    }

    @Override
    public NewsDetails selectByAuthor(String author) {
        return newsDetailsDao.selectByAuthor(author);
    }

    @Override
    public void addOneNews(NewsDetails newsDetails) {
        newsDetailsDao.addOneNews(newsDetails);
    }

    @Override
    public void deleteOneNews(int id) {
        newsDetailsDao.deleteOneNews(id);
    }

    @Override
    public void updateOneNews(NewsDetails newsDetails) {
        newsDetailsDao.updateOneNews(newsDetails);
    }

    @Override
    public List<NewsDetails> selectContent(String title) {
        return newsDetailsDao.selectContent(title);
    }
}
