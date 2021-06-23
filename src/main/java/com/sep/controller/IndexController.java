package com.sep.controller;

import com.sep.pojo.NewsDetails;
import com.sep.service.NewsDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private NewsDetailsServiceImpl newsDetailsService;

    @RequestMapping("/index/search")
    public String getNewsByAnyString(@RequestParam("title") String title, Model model){
        List<NewsDetails> newsDetails = newsDetailsService.selectContent(title);
        model.addAttribute("news",newsDetails);
        return "search_tab";
    }

    @RequestMapping("/search/{id}")
    public String getNewsByTitle(@PathVariable("id") int id, Model model){
        NewsDetails newsDetails = newsDetailsService.selectOneById(id);
        model.addAttribute("news",newsDetails);
        return "news_detail";
    }

    //跳转首页
    @RequestMapping("/")
    public String getIndex(Model model){
        NewsDetails news31 = newsDetailsService.selectOneById(31);
        NewsDetails news28 = newsDetailsService.selectOneById(28);
        NewsDetails news3 = newsDetailsService.selectOneById(3);
        model.addAttribute("news31",news31);
        model.addAttribute("news28",news28);
        model.addAttribute("news3",news3);
        return "index";
    }

//    @RequestMapping("/index/{id}")
//    public String getNewsById(@PathVariable("id") int id,Model model){
//        NewsDetails newsDetails = newsDetailsService.selectOneById(id);
//        model.addAttribute("news",newsDetails);
//        return "news_detail";
//    }
}
