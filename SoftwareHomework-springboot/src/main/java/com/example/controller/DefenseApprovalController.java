package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.DefenseApproval;
import com.example.service.DefenseApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DefenseApprovalController {
    @Autowired
    private DefenseApprovalService defenseApprovalService;

    @GetMapping(value = "/findAllDefenseApproval")
    public JSONObject findAllDefenseApproval() {
        List<DefenseApproval> defenseApprovalList = defenseApprovalService.findAllDefenseApproval();
        if(defenseApprovalList == null) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, "查询失败");
        } else {
            return SendMessage.send(JSON.toJSON(defenseApprovalList), StaticValue.ACCPET_CODE, "查询成功");
        }
    }
}
