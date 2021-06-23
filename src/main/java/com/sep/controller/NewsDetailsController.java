package com.sep.controller;

import com.sep.pojo.NewsDetails;
import com.sep.service.NewsDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsDetailsController {
    @Autowired
    private NewsDetailsServiceImpl newsDetailsService;

    @GetMapping("/getNewsDetails")
    public List<NewsDetails> getNewsDetails(){
        return newsDetailsService.selectAllNews();
    }

    @GetMapping("/getNewsByTitle")
    public List<NewsDetails> getNewsByTitle(String title){
        List<NewsDetails> newsDetails = newsDetailsService.selectContent(title);
        return newsDetails;
    }
}
