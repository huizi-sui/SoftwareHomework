package com.example.dao;

import com.example.entity.Login;

import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface LoginMapper extends Mapper<Login> {
    @Select("select count(*) from login")
    Integer count();
    @Select("select * from login where id = #{id}")
    Login selectLoginById(long id);
}
