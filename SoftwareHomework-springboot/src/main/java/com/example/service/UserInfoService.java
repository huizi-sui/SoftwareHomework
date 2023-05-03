package com.example.service;

import com.example.entity.UserInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserInfoService {
    List<UserInfo> getAllUserInfo();
}
