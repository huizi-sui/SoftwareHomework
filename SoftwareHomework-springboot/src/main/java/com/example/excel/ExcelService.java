package com.example.excel;

import com.example.dao.LoginMapper;
import com.example.dao.StudentManagementMapper;
import com.example.dao.UserInfoMapper;
import com.example.entity.StudentManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExcelService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private StudentManagementMapper studentManagementMapper;
    @Autowired
    private LoginMapper loginMapper;
    public void save(List<ExcelPojo> list) {
        for(ExcelPojo excelPojo : list){
            userInfoMapper.insert(excelPojo.getUserInfoList());
            studentManagementMapper.insert(excelPojo.getStudentManagementList());
            loginMapper.insert(excelPojo.getLoginList());
        }
    }
}
