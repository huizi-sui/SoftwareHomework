package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.BlindReviewResult;
import com.example.service.BlindReviewResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlindReviewResultController {
    @Autowired
    private BlindReviewResultService blindReviewResultService;

    @GetMapping(value = "/findAllBlindReviewResult")
    public JSONObject findAllBlindReviewResult() {
        List<BlindReviewResult> blindReviewResults = blindReviewResultService.findAllBlindReviewResult();
        if(blindReviewResults == null) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, "查询失败");
        } else {
            return SendMessage.send(JSON.toJSON(blindReviewResults), StaticValue.ACCPET_CODE, "查询成功");
        }
    }
}
