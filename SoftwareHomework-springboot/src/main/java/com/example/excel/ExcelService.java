package com.example.excel;

import com.example.dao.LoginMapper;
import com.example.dao.StudentManagementMapper;
import com.example.dao.UserInfoMapper;
import com.example.entity.Login;
import com.example.entity.StudentManagement;
import com.example.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExcelService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private StudentManagementMapper studentManagementMapper;
    @Autowired
    private LoginMapper loginMapper;
    public void save(List<StudentManagement> list) {
        for(StudentManagement studentManagement : list){
            studentManagementMapper.insert(studentManagement);
            Login login = new Login();
            login.setId(studentManagement.getStudentId());
            login.setRid(studentManagement.getRid());
            login.setPassword("123456");
            loginMapper.insert(login);

            UserInfo userInfo = new UserInfo();
            userInfo.setId(studentManagement.getStudentId());
            userInfo.setCollege(studentManagement.getCollege());
            userInfo.setMajor(studentManagement.getMajor());
            userInfo.setName(studentManagement.getName());
            userInfo.setSex(studentManagement.getSex());

            userInfoMapper.insert(userInfo);
        }
    }
}
