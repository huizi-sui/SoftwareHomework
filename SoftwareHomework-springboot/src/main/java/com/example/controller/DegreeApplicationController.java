package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.DegreeApplication;
import com.example.service.ApproveService;
import com.example.service.DegreeApplicationService;
import com.example.service.WorkFlowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "学位申请")
public class DegreeApplicationController {
    @Autowired
    private DegreeApplicationService degreeApplicationService;
    @Autowired
    private WorkFlowService workFlowService;
    @Autowired
    private ApproveService approveService;

    @GetMapping(value = "/findDegreeApplicationById")
    @ApiOperation(value = "查询学生学位申请信息", httpMethod = "GET")
    public JSONObject findDegreeApplicationById(@RequestParam Long id) {
        DegreeApplication degreeApplication = degreeApplicationService.findById(id);
        return SendMessage.send(JSON.toJSON(degreeApplication), StaticValue.ACCPET_CODE, "查询成功");
    }

    @PostMapping(value = "/degreeApplication")
    @ApiOperation(value = "学生申请学位", httpMethod = "POST")
    public JSONObject applyDegree(@RequestBody DegreeApplication degreeApplication) {
        try {
            boolean result = workFlowService.findDegreeApplicationPreviewAssured(degreeApplication.getId());
            if(!result) {
                throw new Exception("前面操作未完成，不允许申请学位");
            }
            degreeApplication.setAdminIsAgree(1);
            degreeApplicationService.update(degreeApplication);
            approveService.add(degreeApplication);
            workFlowService.assuredDegreeApplication(degreeApplication.getId());
            return SendMessage.send(null, StaticValue.ACCPET_CODE, "操作成功");
        }catch (Exception e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }

    @PostMapping(value = "/approvalDegreeApplication")
    @ApiOperation(value = "管理员审批学位信息", httpMethod = "POST")
    public JSONObject approvalDegreeApplication(@RequestBody DegreeApplication degreeApplication,@RequestBody String approvalName, @RequestBody Integer approvalId) {
        try {
            // 管理员审批，只需更新，无需检查
            workFlowService.assuredApprovalResult(degreeApplication.getId());
            approveService.update(degreeApplication, approvalName, approvalId);
            degreeApplicationService.update(degreeApplication);
            return SendMessage.send(null, StaticValue.ACCPET_CODE, "操作成功");
        }catch (Exception e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }

    /*   @GetMapping(value = "/findAllDegreeApplication")
    @ApiOperation(value = "获得所有学生学位申请信息", httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 404, message = "查询失败"),
            @ApiResponse(code = 200, message = "查询成功")
    })
    public JSONObject findAllDegreeApplication() {
        List<DegreeApplication> degreeApplications = degreeApplicationService.findAllDegreeApplication();
        if(degreeApplications == null) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, "查询失败");
        } else {
            return SendMessage.send(JSON.toJSON(degreeApplications), StaticValue.ACCPET_CODE, "查询成功");
        }
    }*/
}
