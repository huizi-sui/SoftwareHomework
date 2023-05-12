package com.example.service.impl;

import com.example.dao.LoginMapper;
import com.example.dao.UserInfoMapper;
import com.example.entity.Login;
import com.example.entity.UserInfo;
import com.example.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private LoginMapper loginMapper;

    public void insert(Long id) throws ParseException {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("待填写");
        userInfo.setCollege("软件学院");
        userInfo.setLevel(22);
        String dateString = "2025-06-12";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = dateFormat.parse(dateString);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        userInfo.setDate(sqlDate);
        userInfo.setSex("男");
        userInfo.setMajor("软件工程专业");
        userInfo.setApprovalResult("暂未获得学位");

        Login login = loginMapper.selectLoginById(id);
        userInfo.setEmail(login.getEmail());

        userInfoMapper.insert(userInfo);
    }
    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        try {
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<UserInfo> getAllUserInfo() {
        return userInfoMapper.selectAll();
    }

    @Override
    public UserInfo findById(Long id) throws ParseException {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        if(userInfo == null) {
            insert(id);
            userInfo = userInfoMapper.selectByPrimaryKey(id);
        }
        return userInfo;
    }
}
