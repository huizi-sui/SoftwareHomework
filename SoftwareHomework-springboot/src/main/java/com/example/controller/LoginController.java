package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.Login;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/addLogin")
    public JSONObject addLogin(@RequestBody Login login) {
        int rows = loginService.addLogin(login);
        if(rows == 1) {
            return SendMessage.send(null, StaticValue.ACCPET_CODE, "添加成功");
        } else {
            return SendMessage.send(null, StaticValue.ERROR_CODE, "添加用户失败");
        }
    }

    @RequestMapping(value = "/findLoginById", method = RequestMethod.GET)
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
    public JSONObject findAllUser() {
        List<Login> loginList = loginService.findAllLogin();
        return SendMessage.send(JSON.toJSON(loginList), 200, "查询成功");
    }
}
