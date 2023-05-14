package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.WorkFlow;
import com.example.service.ApproveService;
import com.example.service.WorkFlowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "处理工作流程表")
public class WorkFlowController {
    @Autowired
    private WorkFlowService workFlowService;
    @Autowired
    private ApproveService approveService;


    @GetMapping(value = "/findWorkFlowById")
    @ApiOperation(value = "根据学号查询工作流程信息", httpMethod = "GET")
    public JSONObject findWorkFlowById(@RequestParam Long id) {
        WorkFlow workFlow = workFlowService.findById(id);
        return SendMessage.send(JSON.toJSON(workFlow), StaticValue.ACCPET_CODE, "查询成功");
    }

    @GetMapping(value = "/assuredAllowDownload")
    @ApiOperation(value = "学生点击下载材料后即调用该接口", httpMethod = "GET")
    public JSONObject assuredAllowDownload(@RequestParam Long id) {
        try {
            boolean result = workFlowService.assuredAllowDownload(id);
            if(!result) {
                throw new Exception("操作失败");
            }
            // 添加答辩成绩提交审批
            approveService.add(id);
            return SendMessage.send(null, StaticValue.ACCPET_CODE, "操作成功");
        }catch (Exception e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }

    @GetMapping(value = "/findAllWorkFlow")
    @ApiOperation(value = "获得所有学生工作流程信息", httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 404, message = "查询失败"),
            @ApiResponse(code = 200, message = "查询成功")
    })
    public JSONObject findAllWorkFlow(){
        List<WorkFlow> workFlows = workFlowService.findAllWorkFlow();
        if(workFlows == null) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, "查询失败");
        } else {
            return SendMessage.send(JSON.toJSON(workFlows), StaticValue.ACCPET_CODE, "查询成功");
        }
    }
}
