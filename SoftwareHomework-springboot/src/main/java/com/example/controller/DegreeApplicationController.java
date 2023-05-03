package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.DegreeApplication;
import com.example.service.DegreeApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DegreeApplicationController {
    @Autowired
    private DegreeApplicationService degreeApplicationService;

    @GetMapping(value = "/findAllDegreeApplication")
    public JSONObject findAllDegreeApplication() {
        List<DegreeApplication> degreeApplications = degreeApplicationService.findAllDegreeApplication();
        if(degreeApplications == null) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, "查询失败");
        } else {
            return SendMessage.send(JSON.toJSON(degreeApplications), StaticValue.ACCPET_CODE, "查询成功");
        }
    }
}
