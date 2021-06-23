package com.sep.controller;

import com.sep.pojo.NewsDetails;
import com.sep.service.NewsDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

@Controller
public class NewsAdminController {

    @Autowired
    private NewsDetailsServiceImpl newsDetailsService;

    //跳转查询所有新闻
    @RequestMapping("/admin/select")
    public String getNews(Model model){
        List<NewsDetails> newsDetails = newsDetailsService.selectAllNews();
        model.addAttribute("news",newsDetails);
        return "design";
    }

    //跳转添加页面
    @RequestMapping("/admin/insert")
    public String getAdd(){
        return "insert";
    }

    //跳转修改新闻页面
//    @RequestMapping("/admin/update")
//    public String getUpdate(){
//        return "update";
//    }

//    通过关键字查询
    @RequestMapping("/select")
    public String getNewsByTitle(@RequestParam("keywords") String keywords, Model model){
        List<NewsDetails> newsDetails = newsDetailsService.selectContent(keywords);
        model.addAttribute("news",newsDetails);
        return "design";
    }

    //删除该条新闻
    @RequestMapping("/delete/{id}")
    public String deleteNews(@PathVariable("id")int id){
        newsDetailsService.deleteOneNews(id);
        return "redirect:/admin/select";
    }


    //添加一条新闻
    @PostMapping("/add")
    public String addNews(@RequestParam("type") String type, @RequestParam("title") String title,
                          @RequestParam("author") String author, @RequestParam("time")String time,
                          @RequestParam("content")String content) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(time);
        newsDetailsService.addOneNews(new NewsDetails(title,content,author,date,type));
        return "insert";
    }


    //跳转修改新闻页面
    @RequestMapping("/update/{id}")
    public String getUpdate(@PathVariable("id") int id,Model model){
        NewsDetails newsDetails = newsDetailsService.selectOneById(id);
        model.addAttribute("News",newsDetails);
        return "update";
    }

    //修改一条新闻
    @RequestMapping("/admin/update")
    public String updateNews(@RequestParam("id") int id,@RequestParam("type") String type, @RequestParam("title") String title,
                             @RequestParam("author") String author, @RequestParam("content")String content) throws ParseException {
        newsDetailsService.updateOneNews(new NewsDetails(id,title,content,author,new Date(),type));
        return "redirect:/admin/select";
    }

//    @RequestMapping("/admin/update")
//    public String updateNews(@RequestParam("id") int id,@RequestParam("type") String type, @RequestParam("title") String title,
//                             @RequestParam("author") String author, @RequestParam("content")String content) {
//        newsDetailsService.addOneNews(new NewsDetails(id,title,content,author,new Date(),type));
//        return "redirect:/admin/select";
//    }
}
