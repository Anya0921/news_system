package com.sep.service;

import com.sep.dao.AdminDao;
import com.sep.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sep.service.*;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao adminDao;

    @Override
    public String selectAdminPass(String adminName) {
        return adminDao.selectAdminPass(adminName);
    }

    @Override
    public List<Admin> selectAllAdmin() {
        return adminDao.selectAllAdmin();
    }
}
