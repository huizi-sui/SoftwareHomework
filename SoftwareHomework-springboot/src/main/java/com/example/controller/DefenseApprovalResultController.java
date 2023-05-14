package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.DefenseApprovalResult;
import com.example.service.ApproveService;
import com.example.service.DefenseApprovalResultService;
import com.example.service.DefenseApprovalService;
import com.example.service.WorkFlowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("答辩成绩提交")
public class DefenseApprovalResultController {
    @Autowired
    private DefenseApprovalResultService defenseApprovalResultService;
    @Autowired
    private DefenseApprovalService defenseApprovalService;
    @Autowired
    private WorkFlowService workFlowService;
    @Autowired
    private ApproveService approveService;

    @GetMapping(value = "/findDefenseApprovalResultById")
    @ApiOperation(value = "学生查看答辩成绩", httpMethod = "GET")
    public JSONObject findDefenseApprovalResultById(@RequestParam Long id) {
        DefenseApprovalResult defenseApprovalResult = defenseApprovalResultService.findById(id);
        return SendMessage.send(JSON.toJSON(defenseApprovalResult), StaticValue.ACCPET_CODE, "查询成功");
    }


    @PostMapping(value = "/updateDefenseApprovalResult/{approvalName}/{approvalId}")
    @ApiOperation(value = "管理员提交答辩成绩", httpMethod = "POST")
    public JSONObject updateDefenseApprovalResult(@RequestBody DefenseApprovalResult defenseApprovalResult, @PathVariable String approvalName, @PathVariable Integer approvalId) {
        try {
            defenseApprovalResultService.update(defenseApprovalResult);
            approveService.update(defenseApprovalResult, approvalName, approvalId);
            defenseApprovalService.update(defenseApprovalResult.getId(), defenseApprovalResult.getStatus());
            boolean result = workFlowService.assuredDefenseApprovalResult(defenseApprovalResult.getId());
            if(!result) {
               throw new Exception("更新工作流程信息失败");
            }
            return SendMessage.send(null, StaticValue.ACCPET_CODE, "操作成功");
        }catch (Exception e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }
}
