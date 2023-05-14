package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.DefenseApproval;
import com.example.service.ApproveService;
import com.example.service.DefenseApprovalService;
import com.example.service.WorkFlowService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "评阅答辩审批")
public class DefenseApprovalController {
    @Autowired
    private DefenseApprovalService defenseApprovalService;
    @Autowired
    private ApproveService approveService;
    @Autowired
    private WorkFlowService workFlowService;

    @GetMapping(value = "/findDefenseApprovalById")
    @ApiOperation(value = "查询学生的评阅答辩审批", httpMethod = "GET")
    public JSONObject findDefenseApprovalById(@RequestParam Long id) {
        DefenseApproval defenseApproval = defenseApprovalService.findById(id);
        return SendMessage.send(JSON.toJSON(defenseApproval), StaticValue.ACCPET_CODE, "查询成功");
    }

    @PostMapping(value = "/updateDefenseApproval")
    @ApiOperation(value = "学生发起评阅答辩审批申请")
    public JSONObject updateDefenseApproval(@RequestBody DefenseApproval defenseApproval) {
        System.out.println(defenseApproval);
        try {
            boolean exist = workFlowService.findDefenseApprovalPreviewAssured(defenseApproval.getId());
            if (!exist) {
                throw new Exception("前面操作未完成，不允许申请");
            }
            // 插入或者更新评阅答辩审批表
            // 添加或者更新时，设置为未被管理员审批的状态
            defenseApproval.setAdminIsAgree(1);
            defenseApprovalService.update(defenseApproval);
            System.out.println(1);
            // 添加到申请表中
            approveService.add(defenseApproval);
            System.out.println(1);
            return SendMessage.send(null, StaticValue.ACCPET_CODE, "申请成功");
        }catch (Exception e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }

    @PostMapping(value = "/agreeDefenseApproval/{approvalName}/{approvalId}")
    @ApiOperation(value = "管理员同意或不同意答辩申请")
    public JSONObject agreeDefenseApproval(@RequestBody DefenseApproval defenseApproval,@PathVariable String approvalName, @PathVariable  Integer approvalId) {
        try {
            approveService.update(defenseApproval, approvalName, approvalId);
            defenseApprovalService.update(defenseApproval);
            if(defenseApproval.getAdminIsAgree() == 3) {
                // 更新工作流程， 因为申请时已经判断前面都完成了，因此只需要更新就好
                boolean result = workFlowService.assuredDefenseApproval(defenseApproval.getId());
                if (!result) {
                    throw new Exception("确认盲审审核信息失败");
                }
            }
            return SendMessage.send(null, StaticValue.ACCPET_CODE, "操作成功");
        }catch (Exception e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }

/*    @GetMapping(value = "/findAllDefenseApproval")
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
    }*/
}
