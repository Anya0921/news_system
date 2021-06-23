package com.sep.dao;

import com.sep.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface AdminDao {

//    以用户名查询密码
//    @Select("select admin_pass from admin where admin_name=#{adminName}")
    String selectAdminPass(@Param("adminName") String adminName);

    //查询所有管理员用户
    List<Admin> selectAllAdmin();
}
