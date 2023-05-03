package com.example.service.impl;

import com.example.dao.UserInfoMapper;
import com.example.entity.UserInfo;
import com.example.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public List<UserInfo> getAllUserInfo() {
        return userInfoMapper.selectAll();
    }
}
