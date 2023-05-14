package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.Login;
import com.example.entity.UserInfo;
import com.example.service.UserInfoService;
import com.example.service.WorkFlowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "处理学生待确认信息")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private WorkFlowService workFlowService;

    @GetMapping("/getUserInfo")
    @ApiOperation(value = "获取学生信息表，在预毕业信息中显示", httpMethod = "GET")
    public JSONObject getUserInfo(@RequestParam("id") Long id) {
        try {
            UserInfo userInfo = userInfoService.findById(id);
            System.out.println(userInfo);
            return SendMessage.send(JSON.toJSON(userInfo), StaticValue.ACCPET_CODE, "查询成功");
        } catch (ParseException e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }

    @PostMapping(value = "/updateUserInfo")
    @ApiOperation(value = "更新用户确认信息表，学生发现信息不正确，可以修改", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 404, message = "更新失败")
    })
    public JSONObject updateUserInfo(@RequestBody UserInfo userInfo) {
        if(userInfo.getId() == null) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, "学号不能为空");
        }
        try {
            boolean result = userInfoService.updateUserInfo(userInfo);
            if(!result) {
                throw new Exception("更新失败");
            }
            boolean exist = workFlowService.findUserIsExist(userInfo.getId());
            if(!exist) {
                workFlowService.insert(userInfo.getId());
            }
            result = workFlowService.assuredUserInfo(userInfo.getId());
            if(!result) {
                throw new Exception("确认用户信息失败");
            }
            return SendMessage.send(null, StaticValue.ACCPET_CODE, "更新成功");
        }catch (Exception e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }

    }


/*    @GetMapping(value = "findAllUserInfo")
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
    }*/
}
