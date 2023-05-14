package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.Unit.SendMessage;
import com.example.Unit.StaticValue;
import com.example.entity.StudentManagement;
import com.example.service.StudentManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@Api(tags = "学生管理")
public class StudentManagementController {
    @Autowired
    private StudentManagementService studentManagementService;

    @GetMapping("/getAllStudentInfo")
    @ApiOperation(value = "获取所有学生信息", httpMethod = "GET")
    public JSONObject getAllStudentInfo(){
        try{
            List<StudentManagement> studentManagementList = studentManagementService.findAll();
            return SendMessage.send(JSON.toJSON(studentManagementList), StaticValue.ACCPET_CODE, "查询所有学生信息");
        }catch (Exception e){
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }

    @GetMapping("/getSomeStudentInfo")
    @ApiOperation(value = "根据条件获取学生信息", httpMethod = "GET")
    public JSONObject getSomeStudentInfo(@RequestBody StudentManagement studentManagement){
        try{
            List<StudentManagement> studentManagementList = studentManagementService.findSome(studentManagement);
            return SendMessage.send(JSON.toJSON(studentManagementList), StaticValue.ACCPET_CODE, "根据条件查询学生信息");

        }catch (Exception e){
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }

    @PostMapping(value = "/updateStudentManagementInfo")
    @ApiOperation(value = "更新学生管理信息", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 404, message = "更新失败")
    })
    public JSONObject updataStudentManagementInfo(@RequestBody StudentManagement studentManagement){
        try{
            boolean result = studentManagementService.update(studentManagement);
            if(!result) {
                throw new Exception("更新失败");
            }
            return SendMessage.send(null, StaticValue.ACCPET_CODE, "更新成功");
        } catch (Exception e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }

    @PostMapping(value = "/deleteStudentManagementInfo")
    @ApiOperation(value = "更新学生管理信息", httpMethod = "DELETE")
    @ApiResponses({
            @ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 404, message = "更新失败")
    })
    public JSONObject updataStudentManagementInfo(@RequestParam("student_id") Long id){
        try{
            boolean result = studentManagementService.delete(id);
            if(!result) {
                throw new Exception("删除失败");
            }
            return SendMessage.send(null, StaticValue.ACCPET_CODE, "删除成功");
        } catch (Exception e) {
            return SendMessage.send(null, StaticValue.ERROR_CODE, e.getMessage());
        }
    }

}
