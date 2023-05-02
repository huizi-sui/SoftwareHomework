package com.example.service;

import com.example.entity.Login;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LoginService {
    // 添加新用户
    int addLogin(Login login);
    // 检验用户是否存在
    Login findLoginById(Long id);
}
