package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.DefenseApprovalResult;
import com.example.service.ApproveService;
import com.example.service.DefenseApprovalResultService;
import com.example.service.WorkFlowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("答辩成绩提交")
public class DefenseApprovalResultController {
    @Autowired
    private DefenseApprovalResultService defenseApprovalResultService;
    @Autowired
    private WorkFlowService workFlowService;
    @Autowired
    private ApproveService approveService;

    @PostMapping(value = "/updateDefenseApprovalResult")
    @ApiOperation(value = "管理员提交答辩成绩", httpMethod = "POST")
    public JSONObject updateDefenseApprovalResult(@RequestBody DefenseApprovalResult defenseApprovalResult, @RequestBody String approvalName, @RequestBody Integer approvalId) {
        try {
            defenseApprovalResultService.update(defenseApprovalResult);
            approveService.update(defenseApprovalResult, approvalName, approvalId);
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
