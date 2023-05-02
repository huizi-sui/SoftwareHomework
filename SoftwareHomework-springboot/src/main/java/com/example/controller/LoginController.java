package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.Login;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/addLogin")
    public String addLogin(Login login) {
        int rows = loginService.addLogin(login);
        JSONObject result = new JSONObject();
        if(rows == 1) {
            result.put("code", 200);
        } else {
            result.put("code", 404);
        }
        return result.toJSONString();
    }

    @RequestMapping(value = "/findLoginById", method = RequestMethod.GET)
    public String findLoginById(long id) {
        Login login = loginService.findLoginById(id);
        int code;
        if(login == null) {
            code = StaticValue.ERROR_CODE;
        } else {
            code = StaticValue.ACCPET_CODE;
        }
        return SendMessage.send(JSONObject.toJSONString(login), code, null);
    }

    @PostMapping(value = "/login")
    public String login(Login login) {
        Login existLogin = loginService.findLoginById(login.getId());
        int code;
        String message = null;
        if(existLogin == null) {
            code = StaticValue.ERROR_CODE;
        } else if(existLogin.getPassword().equals(login.getPassword())) {
            code = StaticValue.ACCPET_CODE;
        } else {
            code = StaticValue.WRONG_PASSWORD_CODE;
            message = "密码输入错误";
        }
        return SendMessage.send(JSONObject.toJSONString(existLogin), code, message);
    }
}
