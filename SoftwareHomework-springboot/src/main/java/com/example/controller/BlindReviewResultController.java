package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.BlindReview;
import com.example.entity.BlindReviewResult;
import com.example.service.ApproveService;
import com.example.service.BlindReviewResultService;
import com.example.service.BlindReviewService;
import com.example.service.WorkFlowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "盲审查重结果")
public class BlindReviewResultController {
    @Autowired
    private BlindReviewResultService blindReviewResultService;
    @Autowired
    private WorkFlowService workFlowService;
    @Autowired
    private BlindReviewService blindReviewService;
    @Autowired
    private ApproveService approveService;

    @PostMapping(value = "/updateBlindReviewResult/{approvalName}/{approvalId}")
    @ApiOperation(value = "管理员提交盲审评阅总评信息", httpMethod = "POST")
    public JSONObject updateBlindReviewResult(@RequestBody BlindReviewResult blindReviewResult, @PathVariable String approvalName, @PathVariable Integer approvalId) {
        try {
            // 盲审已提交后才有盲审评阅总评，因此无需进行工作流程判断，只需更新
            blindReviewResultService.update(blindReviewResult);
            approveService.update(blindReviewResult, approvalName, approvalId);
            workFlowService.assuredBlindReviewResult(blindReviewResult.getId());
            return SendMessage.send(null, StaticValue.ACCPET_CODE, "操作成功");
        }catch (Exception e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }


/*    @GetMapping(value = "/findAllBlindReviewResult")
    @ApiOperation(value = "获得所有学生盲审查重结果", httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 404, message = "查询失败"),
            @ApiResponse(code = 200, message = "查询成功")
    })
    public JSONObject findAllBlindReviewResult() {
        List<BlindReview> blindReviews = blindReviewResultService.findAllBlindReviewResult();
        if(blindReviews == null) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, "查询失败");
        } else {
            return SendMessage.send(JSON.toJSON(blindReviews), StaticValue.ACCPET_CODE, "查询成功");
        }
    }*/
}
