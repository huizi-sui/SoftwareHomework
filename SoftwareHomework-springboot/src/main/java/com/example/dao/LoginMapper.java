package com.example.dao;

import com.example.entity.Login;

import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface LoginMapper extends Mapper<Login> {
    // 没有考虑删除用户的情况，若要添加删除用户功能，需要重新考虑学号id的生成策略
    @Select("select count(*) from login")
    Integer count();
    @Select("select * from login where id = #{id}")
    Login selectLoginById(long id);
}
