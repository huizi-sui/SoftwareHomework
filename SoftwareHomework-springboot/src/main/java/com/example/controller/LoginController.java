package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.Login;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public String findLoginById(@RequestBody Map<String, Long> map) {
        Long id = map.get("id");
        Login login = loginService.findLoginById(id);
        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();
        if(login == null) {
            result.put("code", 404);
        } else {
            result.put("code", 200);
        }
        data.put("login", login);
        result.put("data", data);
        return result.toJSONString();
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody Map<String, String> map) {
        Login existLogin = loginService.findLoginById(Long.getLong(map.get("id")));
        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();
        if(existLogin == null) {
            result.put("code", 404);
        } else if(existLogin.getPassword().equals(map.get("password"))) {
            data.put("login", existLogin);
            result.put("code", 200);
        } else {
            result.put("code", 300);
        }
        result.put("data", data);
        return result.toJSONString();
    }
}
