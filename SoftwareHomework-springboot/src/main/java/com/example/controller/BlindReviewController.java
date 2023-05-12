package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.BlindReview;
import com.example.service.ApproveService;
import com.example.service.BlindReviewService;
import com.example.service.WorkFlowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("盲审表")
public class BlindReviewController {
    @Autowired
    private BlindReviewService blindReviewService;
    @Autowired
    private WorkFlowService workFlowService;
    @Autowired
    private ApproveService approveService;

    @GetMapping(value = "/findBlindReviewById")
    @ApiOperation(value = "获取学生盲审信息", httpMethod = "GET")
    public JSONObject findBlindReviewById(@RequestParam Long id) {
        BlindReview blindReview = blindReviewService.findBlindReviewById(id);
        return SendMessage.send(JSON.toJSON(blindReview), StaticValue.ACCPET_CODE, "查询成功");
    }

    @PostMapping(value = "/addBlindReview")
    @ApiOperation(value = "上传盲审信息")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功"),
            @ApiResponse(code = 404, message = "操作失败")
    })
    public JSONObject addBlindReview(@RequestBody BlindReview blindReview) {
        try {
            boolean result = workFlowService.findDefenseApprovalPreviewAssured(blindReview.getId());
            if(result) {
                throw new Exception("已经盲审审批通过，无需再次提交");
            }
            boolean exist = workFlowService.findBlindReviewPreviewAssured(blindReview.getId());
            if(!exist) {
                throw new Exception("前面操作未完成");
            }
            System.out.println(blindReview);
            blindReviewService.update(blindReview);
            approveService.add(blindReview);
            result = workFlowService.assuredBlindReview(blindReview.getId());
            if(!result) {
                throw new Exception("确认盲审信息失败");
            }
            return SendMessage.send(null, StaticValue.ACCPET_CODE, "提交成功");
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }
}
