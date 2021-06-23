package com.sep.controller;

import com.sep.pojo.Admin;
import com.sep.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping("/getAdminPass")
    public String getAdminPass(String adminName){
        return adminService.selectAdminPass(adminName);
    }

    @GetMapping("/getAdmin")
    public List<Admin> getAdmin(){
        return adminService.selectAllAdmin();
    }

}
