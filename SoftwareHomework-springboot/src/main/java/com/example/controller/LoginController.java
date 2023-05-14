package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.Login;
import com.example.entity.UserInfo;
import com.example.service.LoginService;
import com.example.service.UserInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/addLogin")
    @ApiOperation(value = "添加一个用户", httpMethod = "POST", notes = "暂用不到")
    public JSONObject addLogin(@RequestBody Login login) {
        int rows = loginService.addLogin(login);
        if(rows == 1) {
            return SendMessage.send(null, StaticValue.ACCPET_CODE, "添加成功");
        } else {
            return SendMessage.send(null, StaticValue.ERROR_CODE, "添加用户失败");
        }
    }

    @RequestMapping(value = "/findLoginById", method = RequestMethod.GET)
    @ApiOperation(value = "根据学号查询用户", httpMethod = "GET", notes = "暂未用到")
    @ApiImplicitParam(name = "id", value = "学号", required = true, dataType = "Long")
    public JSONObject findLoginById(long id) {
        Login login = loginService.findLoginById(id);
        if(login == null) {
            SendMessage.send(null, StaticValue.ERROR_CODE, "不存在该用户");
        } else {
            SendMessage.send(JSON.toJSON(login), StaticValue.ACCPET_CODE, "查找成功");
        }
        return null;
    }

    @PostMapping(value = "/login")
    @ApiOperation(value = "检测用户登录信息是否正确", httpMethod = "POST", notes = "根据用户的学号、密码、身份判断是否正确" +
            "是否可以登录到系统")
    @ApiResponses({
            @ApiResponse(code = 404, message = "账号密码输入错误"),
            @ApiResponse(code = 301, message = "身份不符"),
            @ApiResponse(code = 300, message = "密码不正确"),
            @ApiResponse(code = 200, message = "信息匹配")
    })
    @ApiImplicitParam(name = "Login")
    public JSONObject login(@RequestBody Login login) {
        Login existLogin = loginService.findLoginById(login.getId());
        int code;
        String message;
        if(existLogin == null) {
            code = StaticValue.ERROR_CODE;
            message = "账号密码输入错误";
        } else if(existLogin.getPassword().equals(login.getPassword())) {
            if(existLogin.getRid() == login.getRid()) {
                code = StaticValue.ACCPET_CODE;
                message = "登录成功";
                try {
                    UserInfo userInfo = userInfoService.findById(login.getId());
                    Map<String, String> map = new HashMap<>();
                    map.put("name", userInfo.getName());
                    return SendMessage.send(JSON.toJSON(map), code, message);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

            } else {
                code = StaticValue.PERMISSION_CODE;
                message = "登录失败";
            }
        } else {
            code = StaticValue.WRONG_PASSWORD_CODE;
            message = "密码输入错误";
        }
        return SendMessage.send(null, code, message);
    }

    @GetMapping(value = "/findAllUser")
    @ApiOperation(value = "查询所有用户", httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功"),
            @ApiResponse(code = 404, message = "查询失败")
    })
    public JSONObject findAllUser() {
        List<Login> loginList = loginService.findAllLogin();
        if(loginList == null) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, "查询失败");
        } else {
            return SendMessage.send(JSON.toJSON(loginList), StaticValue.ACCPET_CODE, "查询成功");
        }

    }
}
