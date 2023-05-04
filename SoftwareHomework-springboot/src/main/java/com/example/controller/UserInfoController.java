package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.UserInfo;
import com.example.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "处理学生待确认信息")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "findAllUserInfo")
    @ApiOperation(value = "获得所有学生待确认信息", httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 404, message = "查询失败"),
            @ApiResponse(code = 200, message = "查询成功")
    })
    public JSONObject findAllUserInfo(){
        List<UserInfo> userInfos = userInfoService.getAllUserInfo();
        if(userInfos == null) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, "查询失败");
        } else {
            return SendMessage.send(JSON.toJSON(userInfos), StaticValue.ACCPET_CODE, "查询成功");
        }
    }
}
