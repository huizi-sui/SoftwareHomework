package com.example.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.Approve;
import com.example.entity.DefenseApproval;
import com.example.entity.DegreeApplication;
import com.example.entity.SelfEvaluation;
import com.example.service.ApproveService;
import com.example.service.DefenseApprovalService;
import com.example.service.DegreeApplicationService;
import com.example.service.SelfEvaluationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api("审批处理")
public class ApprovalController {
    @Autowired
    private ApproveService approveService;
    @Autowired
    private DefenseApprovalService defenseApprovalService;
    @Autowired
    private SelfEvaluationService selfEvaluationService;
    @Autowired
    private DegreeApplicationService degreeApplicationService;

    @GetMapping(value = "/findAllApprove")
    @ApiOperation(value = "查询所有审批申请", httpMethod = "GET")
    public JSONObject findAllApprove() {
        try {
            List<Approve> approves = approveService.findAll();
            return SendMessage.send(JSON.toJSON(approves), StaticValue.ACCPET_CODE, "查询成功");
        } catch (Exception e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }

    @PostMapping(value = "/findSomeApprove")
    @ApiOperation(value = "根据某些条件查询", httpMethod = "POST")
    public JSONObject findSomeApprove(@RequestBody Approve approve) {
        System.out.println(approve);
        try {
            List<Approve> approves = approveService.findSome(approve);
            return SendMessage.send(JSON.toJSON(approves), StaticValue.ACCPET_CODE, "查询成功");
        } catch (Exception e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }

    @GetMapping(value = "/approveStudent")
    @ApiOperation(value = "审批学生的某一项，通过operator表明审批的是什么，返回数据库中已存在的基础信息")
    public JSONObject approveStudent(@RequestParam Long id, @RequestParam int operator) {
        try {
            if(operator == 1 || operator == 4) {
                // 评阅审批答辩、答辩成绩提交
                DefenseApproval defenseApproval = defenseApprovalService.findById(id);
                if(defenseApproval == null) {
                    throw new Exception("查询出错");
                }
                return SendMessage.send(JSON.toJSON(defenseApproval), StaticValue.ACCPET_CODE, "查询成功");
            } else if(operator == 2) {
                // 盲审评阅总评
                SelfEvaluation selfEvaluation = selfEvaluationService.findById(id);
                if (null == selfEvaluation) {
                    throw new Exception("查询出错");
                }
                Map<String, String> map = new HashMap<>();
                map.put("title", selfEvaluation.getTitle());
                map.put("keyWords", selfEvaluation.getKeyWords());
                map.put("summary", selfEvaluation.getSummary());
                return SendMessage.send(JSON.toJSON(map), StaticValue.ACCPET_CODE, "查询成功");
            } else if(operator == 3) {
                DegreeApplication degreeApplication = degreeApplicationService.findById(id);
                return SendMessage.send(JSON.toJSON(degreeApplication), StaticValue.ACCPET_CODE, "查询成功");
            } else {
                    throw new Exception("没有此类审批");

            }
        }catch (Exception e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }

    }
}
