package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.SelfEvaluation;
import com.example.service.SelfEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SelfEvaluationController {
    @Autowired
    private SelfEvaluationService selfEvaluationService;

    @GetMapping(value = "findAllSelfEvaluation")
    public JSONObject findAllSelfEvaluation(){
        List<SelfEvaluation> selfEvaluations = selfEvaluationService.findAllSelfEvaluation();
        if(selfEvaluations == null) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, "查询失败");
        } else {
            return SendMessage.send(JSON.toJSON(selfEvaluations), StaticValue.ACCPET_CODE, "查询成功");
        }
    }
}
