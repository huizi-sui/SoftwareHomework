package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.DefenseApproval;
import com.example.service.DefenseApprovalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "评阅答辩审批")
public class DefenseApprovalController {
    @Autowired
    private DefenseApprovalService defenseApprovalService;

    @GetMapping(value = "/findAllDefenseApproval")
    @ApiOperation(value = "获得所有学生评阅答辩审批信息", httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 404, message = "查询失败"),
            @ApiResponse(code = 200, message = "查询成功")
    })
    public JSONObject findAllDefenseApproval() {
        List<DefenseApproval> defenseApprovalList = defenseApprovalService.findAllDefenseApproval();
        if(defenseApprovalList == null) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, "查询失败");
        } else {
            return SendMessage.send(JSON.toJSON(defenseApprovalList), StaticValue.ACCPET_CODE, "查询成功");
        }
    }
}
