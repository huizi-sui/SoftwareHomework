package com.example.service;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.UserInfo;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Transactional
public interface UserInfoService {

    void insert(Long id) throws ParseException;
    boolean updateUserInfo(UserInfo userInfo);
    List<UserInfo> getAllUserInfo();

    UserInfo findById(Long id) throws ParseException;
}
