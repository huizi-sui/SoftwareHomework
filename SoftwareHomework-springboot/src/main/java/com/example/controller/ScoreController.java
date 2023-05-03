package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.Score;
import com.example.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping(value = "findAllScore")
    public JSONObject findAllScore(){
        List<Score> scores = scoreService.findAllScore();
        if(scores == null) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, "查询失败");
        } else {
            return SendMessage.send(JSON.toJSON(scores), StaticValue.ACCPET_CODE, "查询成功");
        }
    }
}
