package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.SelfEvaluation;
import com.example.service.SelfEvaluationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Api(tags = "处理自评论文预审信息")
public class SelfEvaluationController {
    @Autowired
    private SelfEvaluationService selfEvaluationService;

    @GetMapping(value = "findAllSelfEvaluation")
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
}
