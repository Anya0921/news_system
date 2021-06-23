package com.sep.controller;

import com.sep.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private AdminServiceImpl adminService;

    //判断管理登录接口
//    @PostMapping("/login")
//    public String getLogin(@RequestParam("name")String name,@RequestParam("pwd")String pwd){
//        String password = adminService.selectAdminPass(name);
//        if(pwd.equals(password)){
//            return "redirect:/page/design.html";
//        }else{
//            return "redirect:/page/newslogin.html";
//        }
//    }

    //判断管理登录接口
    @PostMapping("/login")
    public String getLogin(@RequestParam("name")String name,@RequestParam("pwd")String pwd){
        String password = adminService.selectAdminPass(name);
        if(pwd.equals(password)){
            return "design";
        }else{
            return "redirect:/page/newslogin.html";
        }
    }

}
