package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.SelfEvaluation;
import com.example.service.SelfEvaluationService;
import com.example.service.WorkFlowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "处理自评论文预审信息")
public class SelfEvaluationController {
    @Autowired
    private SelfEvaluationService selfEvaluationService;
    @Autowired
    private WorkFlowService workFlowService;

    @GetMapping("/findSelfEvaluationById")
    @ApiOperation(value = "获取学生的自评论文预审信息", httpMethod = "GET")
    public JSONObject findSelfEvaluationById(@RequestParam Long id) {
        try {
            SelfEvaluation selfEvaluation = selfEvaluationService.findById(id);
            return SendMessage.send(JSON.toJSON(selfEvaluation), StaticValue.ACCPET_CODE, "查询成功");
        } catch (Exception e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }

    @PostMapping(value = "/updateSelfEvaluation")
    @ApiOperation(value = "更新学生自评论文预审信息", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 404, message = "更新失败")
    })
    public JSONObject updateSelfEvaluation(@RequestBody SelfEvaluation selfEvaluation) {
        try {
            boolean result = selfEvaluationService.updateSelfEvaluation(selfEvaluation);
            if(!result) {
                throw new Exception("更新失败");
            }
            boolean exist = workFlowService.findUserIsExist(selfEvaluation.getId());
            if(!exist) {
                throw new Exception("前面操作未完成");
            }
            result = workFlowService.assuredSelfEvaluation(selfEvaluation.getId());
            if(!result) {
                throw new Exception("确认用户信息失败");
            }
            return SendMessage.send(null, StaticValue.ACCPET_CODE, "更新成功");
        }catch (Exception e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }

    /*
    @GetMapping(value = "/findAllSelfEvaluation")
    @ApiOperation(value = "获得所有学生自评论文预审信息", httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 404, message = "查询失败"),
            @ApiResponse(code = 200, message = "查询成功")
    })
    public JSONObject findAllSelfEvaluation(){
        List<SelfEvaluation> selfEvaluations = selfEvaluationService.findAllSelfEvaluation();
        if(selfEvaluations == null) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, "查询失败");
        } else {
            return SendMessage.send(JSON.toJSON(selfEvaluations), StaticValue.ACCPET_CODE, "查询成功");
        }
    }
     */
}
