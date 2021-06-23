package com.sep.service;

import com.sep.pojo.Admin;

import java.util.List;

public interface AdminService {
    //以用户名查询密码
    String selectAdminPass(String adminName);

    //查询管理员用户
    List<Admin> selectAllAdmin();
}
