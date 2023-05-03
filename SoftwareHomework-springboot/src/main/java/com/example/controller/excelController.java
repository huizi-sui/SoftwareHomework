package com.example.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.excel.ExcelDao;
import com.example.excel.ExcelDataListener;
import com.example.excel.ExcelPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class excelController {
    @Autowired
    private ExcelDao excelDao;

    @PostMapping(value = "/upload")
    public JSONObject upload(MultipartFile file) {
        System.out.println(file.getName());
        try {
            // 默认去掉了第一行
            EasyExcel.read(file.getInputStream(), ExcelPojo.class, new ExcelDataListener(excelDao)).sheet().doRead();
            return SendMessage.send(null, StaticValue.ACCPET_CODE, "成功导入数据库");
        }catch (Exception e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }
}
