package com.example.dao;

import com.example.entity.Login;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {
    // 创建新用户
    int insertLogin(Login login);

    Login selectLoginById(Long id);

    int count();
}
