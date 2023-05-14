package com.example.excel;

import com.example.entity.Login;
import com.example.entity.StudentManagement;
import com.example.entity.UserInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode
public class ExcelPojo {
    private StudentManagement studentManagementList;
    private UserInfo userInfoList;
    private Login loginList;
}
