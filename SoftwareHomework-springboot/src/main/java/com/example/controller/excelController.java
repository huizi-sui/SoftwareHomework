package com.example.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.excel.ExcelDao;
import com.example.excel.ExcelDataListener;
import com.example.excel.ExcelPojo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(tags = "处理Excel相关内容")
public class excelController {
    @Autowired
    private ExcelDao excelDao;

    @PostMapping(value = "/upload")
    @ApiOperation(value = "处理上传excel，将其导入数据库", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 404, message = "异常捕获的错误信息"),
            @ApiResponse(code = 200, message = "成功导入数据库")
    })
    @ApiImplicitParam(name = "file", value = "上传的excel文件")
    public JSONObject upload(@RequestBody MultipartFile file) {
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
